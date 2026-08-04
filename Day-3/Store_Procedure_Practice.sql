-- ============================================================
-- STORED PROCEDURES (MySQL)
-- ============================================================

-- Sample Table
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Category VARCHAR(50),
    Price DECIMAL(10,2)
);

INSERT INTO Products VALUES
(101,'Laptop','Electronics',65000),
(102,'Mobile','Electronics',30000),
(103,'Chair','Furniture',4500),
(104,'Table','Furniture',8500),
(105,'Shoes','Fashion',2500);

-- 1. PROCEDURE WITHOUT PARAMETERS

DELIMITER $$
CREATE PROCEDURE GetProducts()
BEGIN
    SELECT *
    FROM Products;
END $$
DELIMITER ;

CALL GetProducts();


-- 2. PROCEDURE WITH INPUT PARAMETER (IN)
DELIMITER $$
CREATE PROCEDURE GetProductsByCategory(
    IN CategoryName VARCHAR(50)
)
BEGIN
    SELECT *
    FROM Products
    WHERE Category = CategoryName;
END $$
DELIMITER ;

CALL GetProductsByCategory('Electronics');


-- 3. PROCEDURE WITH MULTIPLE INPUT PARAMETERS
DELIMITER $$
CREATE PROCEDURE ProductsAbovePrice(
    IN MinimumPrice DECIMAL(10,2),
    IN CategoryType VARCHAR(50)
)
BEGIN
    SELECT *
    FROM Products
    WHERE Price >= MinimumPrice
    AND Category = CategoryType;
END $$
DELIMITER ;

CALL ProductsAbovePrice(5000,'Furniture');


-- 4. INSERT USING PROCEDURE

DELIMITER $$
CREATE PROCEDURE AddProduct(
    IN PId INT,
    IN PName VARCHAR(100),
    IN PCategory VARCHAR(50),
    IN PPrice DECIMAL(10,2)
)
BEGIN
    INSERT INTO Products
    VALUES(PId,PName,PCategory,PPrice);
END $$
DELIMITER ;

CALL AddProduct(106,'Watch','Fashion',3500);


-- 5. UPDATE USING PROCEDURE

DELIMITER $$
CREATE PROCEDURE UpdateProductPrice(
    IN PId INT,
    IN NewPrice DECIMAL(10,2)
)
BEGIN
    UPDATE Products
    SET Price = NewPrice
    WHERE ProductID = PId;
END $$
DELIMITER ;

CALL UpdateProductPrice(102,32000);


-- 6. DELETE USING PROCEDURE

DELIMITER $$
CREATE PROCEDURE DeleteProduct(
    IN PId INT
)
BEGIN
    DELETE
    FROM Products
    WHERE ProductID = PId;
END $$
DELIMITER ;

CALL DeleteProduct(105);


-- 7. OUT PARAMETER
-- Used to return a value from a procedure.

DELIMITER $$
CREATE PROCEDURE ProductCount(
    OUT TotalProducts INT
)
BEGIN
    SELECT COUNT(*)
    INTO TotalProducts
    FROM Products;
END $$
DELIMITER ;

CALL ProductCount(@Total);

SELECT @Total;

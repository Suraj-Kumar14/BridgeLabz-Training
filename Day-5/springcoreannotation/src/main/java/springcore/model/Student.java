package springcore.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

 //   @Autowired
    private Address address;

//    public Student() {
//        System.out.println("Student Bean Created");
//    }
    
    @Autowired
    public Student(Address address) {

        System.out.println("Constructor Injection Called");

        this.address = address;
    }
    
//    @Autowired
//    public void setAddress(Address address) {
//        System.out.println("Setter Injection Called");
//        this.address = address;
//    }

    @Override
    public String toString() {
        return "Student [address=" + address + "]";
    }
}
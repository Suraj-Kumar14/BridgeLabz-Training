package com.geomeasure;

public class Line {
	
	    private double x1, y1, x2, y2;

	    // Constructor
	    public Line(double x1, double y1, double x2, double y2) {
	        this.x1 = x1;
	        this.y1 = y1;
	        this.x2 = x2;
	        this.y2 = y2;
	    }

	    // Method to calculate length
	    public double calculateLength() {
	        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	    }

	    // Compare this line with another line
	    public String compareTo(Line other) {
	        double length1 = this.calculateLength();
	        double length2 = other.calculateLength();

	        if (length1 == length2) {
	            return "Both lines are equal in length.";
	        } else if (length1 > length2) {
	            return "This line is longer than the other line.";
	        } else {
	            return "This line is shorter than the other line.";
	        }
	    }

	    @Override
	    public String toString() {
	        return "Line[(" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")] Length: " + calculateLength();
	    }
}

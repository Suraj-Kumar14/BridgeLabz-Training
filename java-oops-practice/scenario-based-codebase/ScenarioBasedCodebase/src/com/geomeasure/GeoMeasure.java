package com.geomeasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeoMeasure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first line
        System.out.println("Enter coordinates for Line 1 (x1 y1 x2 y2): ");
        Line line1 = new Line(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        // Input for second line
        System.out.println("Enter coordinates for Line 2 (x1 y1 x2 y2): ");
        Line line2 = new Line(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        // Compare two lines
        System.out.println(line1.compareTo(line2));

        List<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);

        // Add more lines if needed
        System.out.println("Do you want to add more lines? (yes/no)");
        String choice = sc.next();
        while (choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter coordinates for new line (x1 y1 x2 y2): ");
            Line newLine = new Line(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            lines.add(newLine);
            System.out.println("Do you want to add more lines? (yes/no)");
            choice = sc.next();
        }

        System.out.println("\nAll Lines:");
        for (Line l : lines) {
            System.out.println(l);
        }

        sc.close();
    }
}

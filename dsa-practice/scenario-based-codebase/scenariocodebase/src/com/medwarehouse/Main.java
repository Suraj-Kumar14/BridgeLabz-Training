package com.medwarehouse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Medicine> branch1 = new ArrayList<>();
        List<Medicine> branch2 = new ArrayList<>();

        // Correct pattern: dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        branch1.add(new Medicine("Paracitamol", LocalDate.parse("21/01/2026", formatter)));
        branch1.add(new Medicine("Ibuprofen", LocalDate.parse("18/01/2026", formatter)));
        branch1.add(new Medicine("Clavam 625", LocalDate.parse("22/01/2026", formatter)));

        branch2.add(new Medicine("Cheston", LocalDate.parse("10/01/2026", formatter)));
        branch2.add(new Medicine("Monocef", LocalDate.parse("25/01/2026", formatter)));
        branch2.add(new Medicine("Dolo 625", LocalDate.parse("20/01/2026", formatter)));

        MedWarehouse med = new MedWarehouse();
        for(int i=0;i<branch1.size();i++) {
        	med.addMedicine(branch1.get(i));
        }
        
        for(int i=0;i<branch2.size();i++) {
        	med.addMedicine(branch2.get(i));
        }
//        med.addMedicine(branch1.get(0));
//        med.addMedicine(branch1.get(1));
//        med.addMedicine(branch1.get(2));
//        
//        med.addMedicine(branch2.get(0));
//        med.addMedicine(branch2.get(1));
//        med.addMedicine(branch2.get(2));
        System.out.println();
        med.showMedicine();
        med.sortMedicine();
        System.out.println();
        med.checkExpiry();
        System.out.println();
        med.showMedicine();
    }
}
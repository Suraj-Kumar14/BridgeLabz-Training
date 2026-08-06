package com.springcore.model;

public class Student {

    private int id;
    private String name;
    private Address address;

    public Student() {
        System.out.println("Student Bean Created");
    }

    public Student(int id, String name, Address address) {

        this.id = id;
        this.name = name;
        this.address = address;

        System.out.println("Student Parameterized Constructor Called");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("setId() Called");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName() Called");
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("setAddress() Called");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [id=" + id +
                ", name=" + name +
                ", address=" + address + "]";
    }

}
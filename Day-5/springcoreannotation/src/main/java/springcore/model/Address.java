package springcore.model;

import org.springframework.stereotype.Component;

@Component
public class Address {

    private String city = "Bhopal";
    private String state = "Madhya Pradesh";

    public Address() {
        System.out.println("Address Bean Created");
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}
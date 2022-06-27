package main.java.com.iman.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Child {
    private int childId;
    private Parent parent;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + dateOfBirth + " " +gender +
                " Parent: " + parent.getFirstName() + " " + parent.getLastName();
    }
}

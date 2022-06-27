package main.java.com.iman.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Parent {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private List<Child> children;

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + children ;
    }
}

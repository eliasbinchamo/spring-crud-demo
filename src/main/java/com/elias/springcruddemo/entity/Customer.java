package com.elias.springcruddemo.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    long Id;


    private String firstName, lastName;

    public Customer() {
    }

    public long getId() {
        return Id;
    }
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {

        return "Customer [id=" + Id + ", firstName="
                + firstName + ", lastName=" + lastName + "]";
    }
}

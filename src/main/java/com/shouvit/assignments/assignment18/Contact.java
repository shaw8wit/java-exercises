package com.shouvit.assignments.assignment18;

import lombok.Data;

import java.util.Date;

@Data
public class Contact {
    private int id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Integer pincode;
    private String country;
    private Date birthDate;

    Contact(int id, String firstname, String lastname, Gender gender, String email, String phone, String address, String city, String state, int pincode, String country, Date birthDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
        this.birthDate = birthDate;
    }

    public Contact() {
    }
}

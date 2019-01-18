package com.gpch.login.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "place")
public class Place {
    @Id
    @Column(name = "Id")
    Integer id;
    @NotBlank(message = "Wpisz coś kurwa")
    @Column(name = "name")
    String name;
    @NotBlank
    @Column(name = "address")
    String address;
    @Column(name = "contact_number")
    Integer contactNumber;
    @Column(name = "email")
    String email;
    @Column(name = "website")
    String website;
    @Column(name = "verified")
    Boolean verified;
    @Enumerated(EnumType.STRING)
    @Column(name = "sports")
    Sport sports;


    enum Sport {
        FOOTBALL, VOLLEYBALL, BASKETBALL
    }
}

package com.centauroapp.co.centaurosapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table()
public class Client {
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    @Column()
    private String identificationClient;

    @Column()
    private String typeIdentification;

    @Column()
    private String nameClient;

    @Column()
    private String lastNameClient;

    @Column()
    private Date birthdayDate;

    @Column()
    private String addressClient;

    @Column()
    private String phoneNumberClient;

    @Column()
    private String profession;

    @Column()
    private double salary;

    @Column()
    private double expenses;

    @Column()
    private String typeContract;



}

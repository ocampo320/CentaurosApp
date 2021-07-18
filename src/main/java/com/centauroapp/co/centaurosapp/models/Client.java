package com.centauroapp.co.centaurosapp.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@Builder
public class Client {
    private String identificationClient;
    private String typeIdentification;
    private String nameClient;
    private String lastNameClient;
    private Date birthdayDate;
    private String addressClient;
    private String phoneNumberClient;
    private String profession;
    private double salary;
    private double expenses;
    private String typeContract;


}

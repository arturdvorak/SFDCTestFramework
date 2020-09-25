package models;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class Contact {
    private String salutation;
    private String firstName;
    private String lastName;
    private String accountName;
    private String title;
    private String department;
    private String birthdate;
    private String reportsTo;
    private String leadSorurce;
    private String phone;
    private String homePhone;
    private String mobile;
    private String otherPhone;
    private String fax;
    private String email;
    private String assistant;
    private String assistantPhone;
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingZip;
    private String mailingCountry;
    private String otherStreet;
    private String otherCity;
    private String otherState;
    private String otherZip;
    private String otherCountry;
    private String lang;
    private String level;
    private String description;
}

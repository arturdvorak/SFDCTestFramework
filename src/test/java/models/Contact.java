package models;

import lombok.*;

@Getter
@Setter
@Builder
public class Contact {
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String accountName;
    private String title;
    private String email;
    private String phone;
    private String mobile;
    private String reportsTo;
    private String department;
    private String fax;
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingZip;
    private String mailingCountry;
}

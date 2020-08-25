package models;

import lombok.*;

@Getter
@Setter
@Builder
public class Account {
    private String accountName;
    private String type;
    private String website;
    private String description;
    private String parentAccount;
    private String phone;
    private String industry;
    private int employees;
    private String billingStreet;
    private String billingCity;
    private String billingState;
    private String billingZip;
    private String billingCountry;
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingZip;
    private String mailingCountry;
}

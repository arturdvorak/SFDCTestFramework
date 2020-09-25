package models;

import lombok.*;

@Data
@Builder
public class Account {
    private String accountName;
    private String parentAccount;
    private int accountNumber;
    private String accountSite;
    private String type;
    private String industry;
    private int annualRevenue;
    private String rating;
    private String phone;
    private String fax;
    private String website;
    private String tickerSymbol;
    private String ownership;
    private int employees;
    private int sicCode;
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
    private String customerPriority;
    private int numberOfLocations;
    private String sla;
    private String upsellOpportunity;
    private String active;
    private String description;
}

package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
public class Account {
    @Expose
    @SerializedName("Name")
    private String accountName;
    @Expose
    @SerializedName("ParentId")
    private String parentAccount;
    @Expose
    @SerializedName("AccountNumber")
    private int accountNumber;
    @Expose
    @SerializedName("Site")
    private String accountSite;
    @Expose
    @SerializedName("Type")
    private String type;
    @Expose
    @SerializedName("Industry")
    private String industry;
    @Expose
    @SerializedName("AnnualRevenue")
    private int annualRevenue;
    @Expose
    @SerializedName("Rating")
    private String rating;
    @Expose
    @SerializedName("Phone")
    private String phone;
    @Expose
    @SerializedName("Fax")
    private String fax;
    @Expose
    @SerializedName("Website")
    private String website;
    @Expose
    @SerializedName("TickerSymbol")
    private String tickerSymbol;
    @Expose
    @SerializedName("Ownership")
    private String ownership;
    @Expose
    @SerializedName("NumberOfEmployees")
    private int employees;
    @Expose
    @SerializedName("Sic")
    private int sicCode;
    @Expose
    @SerializedName("BillingStreet")
    private String billingStreet;
    @Expose
    @SerializedName("BillingCity")
    private String billingCity;
    @Expose
    @SerializedName("BillingState")
    private String billingState;
    @Expose
    @SerializedName("BillingPostalCode")
    private String billingZip;
    @Expose
    @SerializedName("BillingCountry")
    private String billingCountry;
    @Expose
    @SerializedName("ShippingStreet")
    private String mailingStreet;
    @Expose
    @SerializedName("ShippingCity")
    private String mailingCity;
    @Expose
    @SerializedName("ShippingState")
    private String mailingState;
    @Expose
    @SerializedName("ShippingPostalCode")
    private String mailingZip;
    @Expose
    @SerializedName("ShippingCountry")
    private String mailingCountry;
    @Expose
    @SerializedName("CustomerPriority__c")
    private String customerPriority;
    @Expose
    @SerializedName("NumberofLocations__c")
    private int numberOfLocations;
    @Expose
    @SerializedName("SLA__c")
    private String sla;
    @Expose
    @SerializedName("UpsellOpportunity__c")
    private String upsellOpportunity;
    @Expose
    @SerializedName("Active__c")
    private String active;
    @Expose
    @SerializedName("Description")
    private String description;
}

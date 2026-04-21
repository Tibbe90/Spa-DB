package com.SpaDB.SpaDB.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SpaPackages")
public class SpaPackage {

    @Id
    private String packageId;
    private String title;
    private String price;
    private String maxAtendees;
    private int basePrice;
    private String timeSlot;

    public SpaPackage(String packageId, String title, String price, String maxAtendees, int basePrice,
            String timeSlot) {
        this.packageId = packageId;
        this.title = title;
        this.price = price;
        this.maxAtendees = maxAtendees;
        this.basePrice = basePrice;
        this.timeSlot = timeSlot;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaxAtendees() {
        return maxAtendees;
    }

    public void setMaxAtendees(String maxAtendees) {
        this.maxAtendees = maxAtendees;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    

}

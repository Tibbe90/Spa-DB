package com.SpaDB.SpaDB.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class BookingInfo {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int nrOfAtendees;
    private String date;
    private String time;
    private String packageTitle;
    private int packagePrice;

    private String email;
    private String phoneNr;
    private int totalPrice;

    public BookingInfo() {}
    
    public BookingInfo(String id, String firstName, String lastName, int nrOfAtendees, String date, String time,
            String packageTitle, String email, String phoneNr) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nrOfAtendees = nrOfAtendees;
        this.date = date;
        this.time = time;
        this.packageTitle = packageTitle;
        this.email = email;
        this.phoneNr = phoneNr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNrOfAtendees() {
        return nrOfAtendees;
    }

    public void setNrOfAtendees(int nrOfAtendees) {
        this.nrOfAtendees = nrOfAtendees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPackageTitle() {
        return packageTitle;
    }

    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    public int getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(int packagePrice) {
        this.packagePrice = packagePrice;
    }
    
    
}

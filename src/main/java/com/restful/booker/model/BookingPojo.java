package com.restful.booker.model;/**
 * @author VibrantSoul
 */

import java.util.HashMap;

/**
 *@author VibrantSoul
 */
public class BookingPojo {
    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositpaid;
    private HashMap<String,String> bookingDates;
    private String checkIn;
    private String checkOut;
    private String additionalNeeds;

    public HashMap<String, String> getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(HashMap<String, String> bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }
    public boolean isDepositpaid(){
        return depositpaid;
    }
    public void setDepositpaid(boolean depositpaid){
        this.depositpaid = depositpaid;
    }
    public String getAdditionalNeeds(){
        return additionalNeeds;
    }
    public void setAdditionalNeeds(String additionalNeeds){
        this.additionalNeeds = additionalNeeds;
    }

}

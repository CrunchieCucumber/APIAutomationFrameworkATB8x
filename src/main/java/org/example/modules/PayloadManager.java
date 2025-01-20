package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {
    Gson gson;

    public String createPayloadBookingAsString(){

        Booking booking = new Booking();
        booking.setFirstname("Peter");
        booking.setLastname("Parker");
        booking.setTotalprice(200);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2025-01-01");
        bookingDates.setCheckout("2025-02-16");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        gson = new Gson();
        String jsonStringPayload = gson.toJson(booking);
        System.out.println(jsonStringPayload);
        return jsonStringPayload;
    }

    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public Booking getResponseFromJson(String getResponse){
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonAuthPayloadString = gson.toJson(auth);
        return jsonAuthPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = new TokenResponse();
        tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken();
    }

    public String fullUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Tony");
        booking.setLastname("Stark");
        booking.setTotalprice(3000);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2025-02-17");
        bookingDates.setCheckout("2025-02-27");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Dinner");
        return gson.toJson(booking);
    }
    
}

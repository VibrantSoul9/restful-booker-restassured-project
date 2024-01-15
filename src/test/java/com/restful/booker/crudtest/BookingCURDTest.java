package com.restful.booker.crudtest;/**
 * @author VibrantSoul
 */

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 *@author VibrantSoul
 */
public class BookingCURDTest extends TestBase {
    @Test
    public void getAllBookingIDS(){
        Response response = given()
                .when()
                .get();
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void getSingleBookingIDs(){
        Response response = given()
                .when()
                .get("/430");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void createBooking(){
        String firstName = TestUtils.getRandomValue()+"Aman";
        String lastName = TestUtils.getRandomValue()+ "Chaman";

        HashMap<String, String> bookingDates = new HashMap();
        bookingDates.put("checkin", "2024-01-10");
        bookingDates.put("checkout", "2024-10-10");
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName("Vibrant");
        bookingPojo.setLastName("Soul");
        bookingPojo.setTotalPrice(2200);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingDates(bookingDates);
        bookingPojo.setAdditionalNeeds("Dinner");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("cookie", "token=0f24634eb80c6ca")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void updateBooking() {
        String firstName = TestUtils.getRandomValue()+ "Aman";
        String lastName = TestUtils.getRandomValue()+ "Chaman";
        HashMap<String, String> bookingDates = new HashMap();
        bookingDates.put("checkin", "2023 - 01 - 10");
        bookingDates.put("checkout", "2024 - 10 - 10");
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName(firstName);
        bookingPojo.setLastName(lastName);
        bookingPojo.setTotalPrice(111);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingDates(bookingDates);
        bookingPojo.setAdditionalNeeds("Dinner");
        Response response = given().log().all().
                header("Content-Type", "application/json")
                .auth().preemptive().basic("admin", "password123")
                .header("Accept", "application/json")
                .body(bookingPojo)
                .when()
                .put("/booking/430");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void partialUpdateBooking() {
        String firstName = TestUtils.getRandomValue()+ "Aman";
        String lastName = TestUtils.getRandomValue()+ "Chaman";
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName(firstName);
        bookingPojo.setLastName(lastName);
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body(bookingPojo)
                .when()
                .patch("/104");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void deleteBooking(){
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .delete("/104");
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void pingCheck(){
        Response response = given().log().all()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .get("https://restful-booker.herokuapp.com/ping");
        response.then().statusCode(201);
        response.prettyPrint();
    }
    }




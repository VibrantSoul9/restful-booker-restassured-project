package com.restful.booker.testsuite;/**
 * @author VibrantSoul
 */

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;

/**
 *@author VibrantSoul
 */
public class BookingAssertion {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        response= (ValidatableResponse) given()
                .when()
                .get("/booking")
                .then().statusCode(200);
    }
    // Extract the value of the lastname
    @Test
    public void test001(){
        List<String> lastName = response.extract().path("booking.lastnmae");
        System.out.println("...StartingTest....");
        System.out.println("The value of lastname is : " + lastName);
        System.out.println("...End of Test...");
    }
    // Extract the length of the data
    @Test
    public void test002(){
        List<Integer> listOfData = response.extract().path("data.length");
        System.out.println("...StartingTest...");
        System.out.println("The size of the data is : "+ listOfData.size());
        System.out.println("...End of Test...");
    }
    //Extract Booking ID from the lists
    @Test
    public void test003(){
        List<Integer> bookingId = response.extract().path("bookingid");
        System.out.println("...StartingTest...");
        System.out.println("The size of the data is : "+ bookingId);
        System.out.println("...End of Test...");
    }
}

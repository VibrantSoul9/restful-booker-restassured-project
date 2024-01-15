package com.restful.booker.testsuite;/**
 * @author VibrantSoul
 */

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

/**
 *@author VibrantSoul
 */
public class Assertion {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking/101")
                .then().statusCode(200);
    }
    // Verify checkin is on 20/10/2020
    @Test
    public void test001(){
        response.body("bookingdates.checkin", equalTo("2018-01-01"));
    }
    //Verify totalprice is greater than 100
    @Test
    public void test002()
    {
        response.body("totalprice", greaterThan(100));
    }
    //Verify that the lastname is "Allen"
    @Test
    public void test003(){
        response.body("lastname", equalTo("Allen"));
    }
    // Verify that the additionalneeds is superbowls
    @Test
    public void test004(){
        response.body("additionalneeds", equalTo("super bowls"));
    }
}

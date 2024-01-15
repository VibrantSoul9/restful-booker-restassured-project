package com.restful.booker.testbase;/**
 * @author VibrantSoul
 */

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 *@author VibrantSoul
 */
public class TestBase {
    @BeforeClass
    public void inIt(){
        RestAssured.baseURI = "http://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";

    }
}

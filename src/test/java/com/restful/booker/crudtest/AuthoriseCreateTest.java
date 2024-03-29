package com.restful.booker.crudtest;/**
 * @author VibrantSoul
 */

import com.restful.booker.model.AuthorizationPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 *@author VibrantSoul
 */
public class AuthoriseCreateTest {
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/auth";
    }
    @Test
    public void createToken(){
       // String userName = TestUtils.getRandomValue()+ "admin";
        // String password = TestUtils.getRandomValue()+ "password108";
        AuthorizationPojo authorizationPojo = new AuthorizationPojo();
        authorizationPojo.setUsername("admin");
        authorizationPojo.setPassword("password108");
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(authorizationPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(200);
    }

}

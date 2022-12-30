package io.swagger.petstore.testsuite;
// **** Created By Harshit Patel ****

import io.restassured.response.Response;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreatePetTest extends TestBase {

    @Test
    public void createAUser(){
        PetPojo petPojo = new PetPojo();


        Response response = given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post("/user/createWithArray");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}

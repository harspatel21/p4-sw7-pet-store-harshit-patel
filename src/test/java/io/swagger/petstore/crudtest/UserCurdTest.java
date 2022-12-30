package io.swagger.petstore.crudtest;
// **** Created By Harshit Patel ****

import io.restassured.response.Response;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCurdTest extends TestBase {

    @Test
    public void createUser(){

        UserPojo userPojo = new UserPojo();

        userPojo.setId(124);
        userPojo.setUsername("JamesB");
        userPojo.setFirstName("James");
        userPojo.setLastName("Bond");
        userPojo.setEmail("JBond" + getRandomValue() + "@gmail.com");
        userPojo.setPassword("Jbond123");
        userPojo.setPhone("020889055605");
        userPojo.setUserStatus(1);
        Response response=given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/user");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getUserByUserId(){
        Response response=given()
                .when()
                .get("/user/JamesB");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void updateUserByUserName(){

        UserPojo userPojo = new UserPojo();

        userPojo.setId(124);
        userPojo.setUsername("JagguD");
        userPojo.setFirstName("Jaggu");
        userPojo.setLastName("Dada");
        userPojo.setEmail("JDada" + getRandomValue() + "@gmail.com");
        userPojo.setPassword("Jdada123");
        userPojo.setPhone("02125825212");
        userPojo.setUserStatus(1);

        Response response=given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .put("/user/JagguD");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void deleteUserByUsername(){

        Response response=given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/user/JagguD");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}

package io.swagger.petstore.testbase;

import io.restassured.RestAssured;
import io.swagger.petstore.utils.TestUtils;
import org.junit.BeforeClass;


public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath = "/v2";

    }
}

package io.swagger.petstore.crudtest;
// **** Created By Harshit Patel ****

import io.restassured.response.Response;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class PetCurdTest extends TestBase {

    @Test
    public void addNewPet() {
        PetPojo petPojo = new PetPojo();

        petPojo.setId(580);

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("id", 220);
        newCategory.put("name", "Badshah");
        petPojo.setCategory(newCategory);

        petPojo.setName("Tiger");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.com%2Fpets%2Ftiger-cub-loki-dies-london-zoo-after-seizures%2F&psig=AOvVaw2K4wKXXnJ9hirasFmtHMcV&ust=1672505406149000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOiBrqfmofwCFQAAAAAdAAAAABAE");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 222);
        tagHash.put("name", "BabyTiger");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post("/pet");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void findPetById() {
        Response response = given()
                .when()
                .get("/pet/580");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void updateExistingPetDetail() {

        PetPojo petPojo = new PetPojo();

        petPojo.setId(580);

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("id", 220);
        newCategory.put("name", "XBadshah");
        petPojo.setCategory(newCategory);

        petPojo.setName("Tiger");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fpeople.com%2Fpets%2Ftiger-cub-loki-dies-london-zoo-after-seizures%2F&psig=AOvVaw2K4wKXXnJ9hirasFmtHMcV&ust=1672505406149000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOiBrqfmofwCFQAAAAAdAAAAABAE");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 222);
        tagHash.put("name", "MyBabyTiger");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post("/pet");
        response.then().statusCode(200);
        response.prettyPrint();



    }

    @Test
    public void deletePet() {

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/pet/580");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

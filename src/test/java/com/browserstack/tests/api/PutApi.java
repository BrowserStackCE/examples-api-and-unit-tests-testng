package com.browserstack.tests.api;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutApi {

  @BeforeClass
  public void setup() {
    // Set the base URI for the Reqres API
    RestAssured.baseURI = "https://reqres.in/api";
  }

  @Test
  public void testUpdateUser() {
    // Data to be sent in the PUT request (JSON format)
    String requestBody = "{\n" +
        "    \"name\": \"John\",\n" +
        "    \"job\": \"Software Engineer\"\n" +
        "}";

    // Sending PUT request to update user with ID 2
    Response response = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .put("/users/2")
        .then()
        .extract()
        .response();

    // Assert status code is 200 (OK)
    Assert.assertEquals(response.getStatusCode(), 200);

    // Assert response body contains the updated data
    String name = response.jsonPath().getString("name");
    String job = response.jsonPath().getString("job");

    Assert.assertEquals(name, "John");
    Assert.assertEquals(job, "Software Engineer");

    // Optionally print the response for debugging
    System.out.println("Response Body: " + response.getBody().asString());
  }

  @Test
  public void testUpdateNonExistentUser() {
    // Data to be sent in the PUT request (JSON format)
    String requestBody = "{\n" +
        "    \"name\": \"Jane\",\n" +
        "    \"job\": \"Data Scientist\"\n" +
        "}";

    // Sending PUT request to update a non-existent user with ID 999
    Response response = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .put("/users/999")
        .then()
        .extract()
        .response();

    // Assert status code is still 200 (Reqres API returns 200 even for non-existent
    // users)
    Assert.assertEquals(response.getStatusCode(), 200);

    // Assert the response body contains the data we sent
    String name = response.jsonPath().getString("name");
    String job = response.jsonPath().getString("job");

    Assert.assertEquals(name, "Jane");
    Assert.assertEquals(job, "Data Scientist");

    // Optionally print the response for debugging
    System.out.println("Response Body: " + response.getBody().asString());
  }
}

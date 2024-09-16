package com.browserstack.tests.api;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteApi {

  @BeforeClass
  public void setup() {
    // Base URL for Reqres API
    RestAssured.baseURI = "https://reqres.in/api";
  }

  @Test
  public void deleteUserTest() {
    // Delete request to remove a user by ID (example: user with id 2)
    Response response = RestAssured
        .given()
        .when()
        .delete("/users/2")
        .then()
        .extract()
        .response();

    // Assert that the status code is 204 (No Content)
    Assert.assertEquals(response.getStatusCode(), 204, "Expected 204 No Content response");
  }

  @Test
  public void deleteNonExistentUserTest() {
    // Trying to delete a non-existent user (example: user with id 999)
    Response response = RestAssured
        .given()
        .when()
        .delete("/users/999")
        .then()
        .extract()
        .response();

    // Assert that the status code is 204 (No Content), even for non-existent users
    Assert.assertEquals(response.getStatusCode(), 204, "Expected 204 No Content response for non-existent user");
  }
}

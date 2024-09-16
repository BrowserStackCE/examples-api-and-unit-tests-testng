package com.browserstack.tests.api;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApi {
  @BeforeMethod
  public void setup() {
    RestAssured.baseURI = "https://reqres.in/api";
  }

  @Test
  public void getUserList() {
    Response response = RestAssured.get("/users?page=2");
    Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
    Assert.assertNotNull(response.jsonPath().getList("data"), "User list should not be null");
  }

  @Test
  public void getSingleUser() {
    Response response = RestAssured.get("/users/2");
    Assert.assertEquals(response.getStatusCode(), 201, "Status code should be 200");
    Assert.assertNotNull(response.jsonPath().get("data.id"), "User ID should not be null");
  }

  @Test
  public void getSingleUserNotFound() {
    Response response = RestAssured.get("/users/23");
    Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404");
  }

  @Test
  public void getListResource() {
    Response response = RestAssured.get("/unknown");
    Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
    Assert.assertNotNull(response.jsonPath().getList("data"), "Resource list should not be null");
  }

  @Test
  public void getSingleResource() {
    Response response = RestAssured.get("/unknown/2");
    Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
    Assert.assertNotNull(response.jsonPath().get("data.id"), "Resource ID should not be null");
  }

  @Test
  public void getSingleResourceNotFound() {
    Response response = RestAssured.get("/unknown/23");
    Assert.assertEquals(response.getStatusCode(), 404, "Status code should be 404");
  }

  @Test
  public void getDelayedResponse() {
    Response response = RestAssured.get("/users?delay=3");
    Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
    Assert.assertNotNull(response.jsonPath().getList("data"), "User list should not be null");
  }
}

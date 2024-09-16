package com.browserstack.tests.api;

import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostApi {

  @BeforeClass
  public void setup() {
    // Set the base URI for Reqres API
    RestAssured.baseURI = "https://reqres.in/api";
  }

  @Test
  public void createUserTest() {
    // Create a new user with POST request
    String requestBody = "{\n" +
        "    \"name\": \"John\",\n" +
        "    \"job\": \"Developer\"\n" +
        "}";

    Response response = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post("/users")
        .then()
        .statusCode(201)
        .body("name", equalTo("John"))
        .body("job", equalTo("Developer"))
        .extract()
        .response();

    // Validate response data
    Assert.assertEquals(response.getStatusCode(), 201);
    Assert.assertNotNull(response.jsonPath().getString("id"));
  }

  @Test
  public void registerUserSuccessTest() {
    // Successful registration with POST request
    String requestBody = "{\n" +
        "    \"email\": \"eve.holt@reqres.in\",\n" +
        "    \"password\": \"pistol\"\n" +
        "}";

    Response response = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post("/register")
        .then()
        .statusCode(200)
        .body("id", equalTo(4))
        .extract()
        .response();

    // Validate the response
    Assert.assertNotNull(response.jsonPath().getString("token"));
  }

  @Test
  public void registerUserFailureTest() {
    // Failed registration due to missing password
    String requestBody = "{\n" +
        "    \"email\": \"sydney@fife\"\n" +
        "}";

    Response response = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post("/register")
        .then()
        .statusCode(400)
        .body("error", equalTo("Missing password"))
        .extract()
        .response();

    // Validate the error message
    Assert.assertEquals(response.getStatusCode(), 400);
    Assert.assertEquals(response.jsonPath().getString("error"), "Missing password");
  }

  @Test
  public void loginSuccessTest() {
    // Introduce randomness to simulate flakiness
    boolean flaky = Math.random() > 0.5;

    // Successful login with POST request
    String requestBody = "{\n" +
        "    \"email\": \"eve.holt@reqres.in\",\n" +
        "    \"password\": \"cityslicka\"\n" +
        "}";

    Response response = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post("/login")
        .then()
        .statusCode(200)
        .extract()
        .response();

    // Validate the response
    if (flaky) {
      // Flaky condition: intentionally fail the test
      Assert.fail("Login was not successful.");
    } else {
      Assert.assertNotNull(response.jsonPath().getString("token"));
    }
  }

  @Test
  public void loginFailureTest() {
    // Failed login due to missing password
    String requestBody = "{\n" +
        "    \"email\": \"peter@klaven\"\n" +
        "}";

    Response response = given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post("/login")
        .then()
        .statusCode(400)
        .body("error", equalTo("Missing password"))
        .extract()
        .response();

    // Validate the error message
    Assert.assertEquals(response.getStatusCode(), 400);
    Assert.assertEquals(response.jsonPath().getString("error"), "Missing password");
  }
}

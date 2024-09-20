![Logo](https://avatars.githubusercontent.com/u/1119453?s=200&v=4)

# API and Unit tests on Observability

## Introduction

TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful.

This repository demonstrates a comprehensive test framework for both API and unit testing, developed using TestNG and Java. It supports writing and executing tests for APIs (using the [Reqres](https://reqres.in/) API) as well as unit tests for individual components. The project is designed with modularity in mind, providing an organized structure for efficient test development and execution.

---

## Repository setup

- Clone the repository

- Ensure you have the following dependencies installed on the machine

  - Java >= 8
  - Maven >= 3.1+

  Maven:

  ```sh
   mvn install -DskipTests
  ```
  
## About the tests in this repository

This repository contains the following API and unit tests:

| **Module** | **Test Name**           | **Description**                                                                                                                                       |
|------------|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| API        | GetRequestTest           | This test verifies the GET requests for the [Reqres API](https://reqres.in/), ensuring correct data is fetched and validating the response structure.   |
| API        | PostRequestTest          | This test verifies the POST requests, ensuring data is successfully created and the response includes the correct status code and payload.              |
| API        | PutRequestTest           | This test verifies the PUT requests for updating resources in the [Reqres API](https://reqres.in/), checking data integrity post-update.                |
| API        | DeleteRequestTest        | This test verifies the DELETE requests, ensuring resources are deleted successfully and the correct response code is returned.                          |
| Unit       | CreditCardValidatorTest  | This unit test checks the whether the entered credit card number is correct or not.                                                                     |
| Unit       | EmailValidatorTest       | This unit test checks the correctness of the email validation logic, ensuring only properly formatted email addresses are accepted.                     |
| Unit       | ShoppingCartTest         | This unit test verifies that the shopping cart functionality works correctly, verifying item addition and cart emptying functionality.                  |
| Unit       | UserRegistrationTest     | This test validates the user registration process, which includes testing valid and invalid user registration scenarios.                                |


---

# BrowserStack Test Observability

[BrowserStack Test Observability](https://www.browserstack.com/test-observability) is a tool that provides deep insights into test execution, performance, and debugging to help teams improve test reliability and speed.

## Prerequisites

- Create a new [BrowserStack account](https://www.browserstack.com/users/sign_up) or use an existing one.
- Identify your BrowserStack username and access key from the [BrowserStack Automate Dashboard](https://automate.browserstack.com/) and export them as environment variables using the below commands.

  - For \*nix based and Mac machines:

  ```sh
  export BROWSERSTACK_USERNAME=<browserstack-username> &&
  export BROWSERSTACK_ACCESS_KEY=<browserstack-access-key>
  ```

  - For Windows:

  ```shell
  set BROWSERSTACK_USERNAME=<browserstack-username>
  set BROWSERSTACK_ACCESS_KEY=<browserstack-access-key>
  ```

  Alternatively, you can also hardcode username and access_key objects in the [browserstack.yml](browserstack.yml) file.

Note:

- We have configured a list of test capabilities in the [browserstack.yml](browserstack.yml) file. You can certainly update them based on your test requirements.

## Running Your Tests

### Run only API tests on BrowserStack Test Observability

In this section, we will run only API tests on Browserstack Test Observability. To change test capabilities for this configuration, please refer to the `browserstack.yml` file.

- How to run the test?

  To run the default API tests on your own machine, use the following command:

  Maven:

  ```sh
  mvn clean test -P api-test
  ```

  To run a specific API test, use the following command with the additional 'test-name' argument:

  Maven:

  ```sh
  mvn clean test -P api-test -Dtest=GetApi
  ```

  where, the argument `test` or `test-name` can be any testclass implemented in this repository.

- Output

  This run profile executes API tests on BrowserStack's Test Observability. Please refer to your [BrowserStack dashboard](https://observability.browserstack.com/) for test results.

### Run only Unit tests on BrowserStack Test Observability

In this section, we will run only Unit tests on Browserstack Test Observability. To change test capabilities for this configuration, please refer to the `browserstack.yml` file.

- How to run the test?

  To run the default Unit tests on your own machine, use the following command:

  Maven:

  ```sh
  mvn clean test -P unit-test
  ```

  To run a specific Unit test, use the following command with the additional 'test-name' argument:

  Maven:

  ```sh
  mvn clean test -P unit-test -Dtest=ShoppingCartTest
  ```

  where, the argument `test` or `test-name` can be any testclass implemented in this repository.

- Output

  This run profile executes unit tests on BrowserStack's Test Observability. Please refer to your [BrowserStack dashboard](https://observability.browserstack.com/) for test results.


### Run the whole suite of tests on BrowserStack Test Observability

In this section, we will run the Enitre test suite on Browserstack Test Observability. To change test capabilities for this configuration, please refer to the `browserstack.yml` file.

- How to run the test?

  To run the default tests on your own machine, use the following command:

  Maven:

  ```sh
  mvn clean test -P sample-test
  ```

  To run a specific test, use the following command with the additional 'test-name' argument:

  Maven:

  ```sh
  mvn clean test -P sample-test -Dtest=ShoppingCartTest
  ```

  where, the argument `test` or `test-name` can be any testclass implemented in this repository.

- Output

  This run profile executes all tests on BrowserStack's Test Observability. Please refer to your [BrowserStack dashboard](https://observability.browserstack.com/) for test results.

## Additional Resources

- View your test results on the [BrowserStack Observability dashboard](https://observability.browserstack.com/)

![Logo](https://avatars.githubusercontent.com/u/1119453?s=200&v=4)

# BrowserStack Examples API and UNIT tests

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
| Unit       | CreditCardValidatorTest  | This unit test checks the validity of credit card numbers using various test cases to ensure the validation logic is accurate.                           |
| Unit       | EmailValidatorTest       | This unit test checks the correctness of the email validation logic, ensuring only properly formatted email addresses are accepted.                     |
| Unit       | ShoppingCartTest         | This test verifies that the shopping cart functionality works correctly, including adding and removing items and calculating the total cost.            |
| Unit       | UserRegistrationTest     | This test validates the user registration process, ensuring proper handling of form inputs and successful user creation.                                |


---

## Test infrastructure environments
- [BrowserStack](https://browserstack.com)

---

# BrowserStack

[BrowserStack](https://browserstack.com) provides instant access to 2,000+ real mobile devices and browsers on a highly reliable cloud infrastructure that effortlessly scales as testing needs grow.

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

- We have configured a list of test capabilities in the [browserstack.yml](browserstack.yml) file. You can certainly update them based on your device / browser test requirements.
- The exact test capability values can be easily identified using the [Browserstack Capability Generator](https://browserstack.com/automate/capabilities)

## Running Your Tests

### Run only api tests on BrowserStack

In this section, we will run only api tests on Browserstack. To change test capabilities for this configuration, please refer to the `browserstack.yml` file.

- How to run the test?

  To run the default api tests on your own machine, use the following command:

  Maven:

  ```sh
  mvn clean test -P api-test
  ```

  To run a specific api test, use the following command with the additional 'test-name' argument:

  Maven:

  ```sh
  mvn clean test -P api-test -Dtest=GetApi
  ```

  where, the argument `test` or `test-name` can be any testclass implemented in this repository.

- Output

  This run profile executes api tests on BrowserStack's Test Observability. Please refer to your [BrowserStack dashboard](https://observability.browserstack.com/) for test results.

### Run only unit tests on BrowserStack

In this section, we will run only unit tests on Browserstack. To change test capabilities for this configuration, please refer to the `browserstack.yml` file.

- How to run the test?

  To run the default unit tests on your own machine, use the following command:

  Maven:

  ```sh
  mvn clean test -P unit-test
  ```

  To run a specific unit test, use the following command with the additional 'test-name' argument:

  Maven:

  ```sh
  mvn clean test -P unit-test -Dtest=ShoppingCartTest
  ```

  where, the argument `test` or `test-name` can be any testclass implemented in this repository.

- Output

  This run profile executes unit tests on BrowserStack's Test Observability. Please refer to your [BrowserStack dashboard](https://observability.browserstack.com/) for test results.


### Run the whole suite of tests on BrowserStack

In this section, we will run the enitre test suite on Browserstack. To change test capabilities for this configuration, please refer to the `browserstack.yml` file.

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

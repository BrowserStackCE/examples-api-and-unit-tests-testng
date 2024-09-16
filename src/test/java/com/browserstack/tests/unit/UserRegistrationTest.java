package com.browserstack.tests.unit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.pages.UserRegistrationService;

public class UserRegistrationTest {

  @Test
  public void testValidRegistration() {
    UserRegistrationService service = new UserRegistrationService();

    // Introduce flakiness with random failure
    boolean flaky = Math.random() > 0.5;

    if (flaky) {
      Assert.fail("Could not register the user");
    } else {
      Assert.assertTrue(service.registerUser("validUser", "strongPass123"));
    }
  }

  @Test
  public void testInvalidUsername() {
    UserRegistrationService service = new UserRegistrationService();
    Assert.assertFalse(service.registerUser("", "strongPass123"));
  }

  @Test
  public void testInvalidPassword() {
    UserRegistrationService service = new UserRegistrationService();
    Assert.assertFalse(service.registerUser("validUser", "short"));
  }

  @Test
  public void testNullInputs() {
    UserRegistrationService service = new UserRegistrationService();
    Assert.assertFalse(service.registerUser(null, "password"));
    Assert.assertFalse(service.registerUser("validUser", null));
  }
}

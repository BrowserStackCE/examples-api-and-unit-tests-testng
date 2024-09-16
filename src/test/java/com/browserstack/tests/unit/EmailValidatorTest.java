package com.browserstack.tests.unit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.browserstack.pages.EmailValidator;

public class EmailValidatorTest {

  private EmailValidator emailValidator;

  @BeforeMethod
  public void setUp() {
    emailValidator = new EmailValidator();
  }

  @Test
  public void testValidEmails() {
    Assert.assertTrue(emailValidator.isValid("test.email@example.com"));
    Assert.assertTrue(emailValidator.isValid("user123@gmail.com"));
    Assert.assertTrue(emailValidator.isValid("first.last@domain.co"));
    Assert.assertTrue(emailValidator.isValid("email@subdomain.example.com"));
  }

  @Test
  public void testInvalidEmails() {
    Assert.assertFalse(emailValidator.isValid("plainaddress")); // Missing "@" and domain
    Assert.assertFalse(emailValidator.isValid("missingAt.com")); // Missing "@"
    Assert.assertFalse(emailValidator.isValid("email@.com")); // Missing domain before "."
    Assert.assertFalse(emailValidator.isValid("@domain.com")); // Missing local part
    Assert.assertFalse(emailValidator.isValid("email@domain@domain.com")); // Multiple "@"
  }

  @Test
  public void testNullEmail() {
    Assert.assertTrue(emailValidator.isValid(null)); // Null case
  }

  @Test
  public void testEdgeCaseEmails() {
    Assert.assertTrue(emailValidator.isValid("a@b.com")); // Minimum valid email
    Assert.assertTrue(emailValidator.isValid("1234567890@example.com")); // Numeric local part
    Assert.assertTrue(emailValidator.isValid("_______@example.com")); // Underscore in local part
  }
}

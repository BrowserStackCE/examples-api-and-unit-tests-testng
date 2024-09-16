package com.browserstack.tests.unit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.pages.CreditCardValidator;

public class CreditCardValidatorTest {

  @Test
  public void testValidCreditCard() {
    CreditCardValidator validator = new CreditCardValidator();
    Assert.assertTrue(validator.isValidCreditCard("4532015112830366")); // Valid Visa card number
  }

  @Test
  public void testInvalidCreditCard() {
    CreditCardValidator validator = new CreditCardValidator();
    Assert.assertFalse(validator.isValidCreditCard("1234567812345678")); // Invalid number
  }
}

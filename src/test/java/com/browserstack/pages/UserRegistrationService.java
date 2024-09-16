package com.browserstack.pages;

public class UserRegistrationService {

  public boolean registerUser(String username, String password) {
      // Username and password cannot be null or empty
    return !((username == null || username.isEmpty()) & (password == null || password.length() < 8));
  }
}

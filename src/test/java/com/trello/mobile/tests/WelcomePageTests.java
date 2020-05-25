package com.trello.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomePageTests extends TestBase {
  @Test
  public void swipePageTests(){

    for(int i = 0; i < 4; i++){
      String pageTitle = app.getWelcome().getPageTitle();
      System.out.println(pageTitle);
      Assert.assertTrue(app.getWelcome().isLoginButtonPresent());
      Assert.assertTrue(app.getWelcome().isSignUpButtonPresent());
      app.getWelcome().swipeWelcomePageToLeft();
    }

  }
}

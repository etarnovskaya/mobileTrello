package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePage extends  HelperBase {
  public WelcomePage(AppiumDriver driver) {
    super(driver);
  }

  public String getPageTitle() {
    return driver.findElement(By.xpath("//*[@resource-id='com.trello:id/text']")).getText();
  }

  public boolean isLoginButtonPresent() {
    return isElementPresent(By.xpath("//*[@resource-id='com.trello:id/log_in_button']"));
  }

  public boolean isSignUpButtonPresent() {
    return isElementPresent(By.xpath("//*[@resource-id='com.trello:id/sign_up_button']"));
  }

  public void swipeWelcomePageToLeft() {
    swipeToLeft(By.xpath("//*[@resource-id='com.trello:id/view_pager']"));
  }
}

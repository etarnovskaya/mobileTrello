package com.trello.mobile.manager;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
  AppiumDriver driver;

  public HelperBase(AppiumDriver driver) {
    this.driver = driver;
  }

  public void returnToHomePage() throws InterruptedException {
     click(By.xpath("//*[@name='house']"));
     click(By.xpath("//*[@name='house']"));
     Thread.sleep(4000);
   }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void waitForElementLocatedAndClick(By locator, int timeOut) {
    new WebDriverWait(driver, timeOut)
            .until(ExpectedConditions.presenceOfElementLocated(locator)).click();
  }

  public void type(By locator, String text) {
    if(text != null){
      waitForElementLocatedAndClick(locator, 20);
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }
  }

  public void confirm() {
    click(By.cssSelector(".js-confirm"));
  }

  public boolean isElementPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public void takeScreenshot(long timeMillis){
    File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screen-"+ timeMillis +".png");

    try {
      Files.copy(tmp, screenshot);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void refreshPage() {
    driver.navigate().refresh();
  }
}

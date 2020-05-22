package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper  extends  HelperBase{
  public SessionHelper(AppiumDriver driver) {
    super(driver);
  }

  public void loginAtlasiianAcc(String email, String pwd) throws InterruptedException {
    initLogin();
    fillLoginFormAtlassianAcc(email, pwd);
    confirmLoginAtlassian();
  }

  public void confirmLoginAtlassian() {
    click(By.cssSelector("#login-submit"));
  }

  public void initLogin() {
    click(By.id("log_in_button"));

  }

  public void fillLoginForm(String userEmail, String password) {
    type(By.xpath("//*[@resource-id='com.trello:id/user']"), userEmail);
    click(By.id("button1"));
    selectBrowserChrome();
    type(By.name("password"), password);
  }

  private void selectBrowserChrome() {
    click(By.xpath(""));
  }

  public void confirmLogin() {
    click(By.id("login"));
  }

  public void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
    type(By.name("user"), userEmail);
    click(By.cssSelector("#login.button-green"));
    Thread.sleep(5000);
    type(By.cssSelector("input#password"), password);

  }

  public void login(String email, String password) {
    initLogin();
    fillLoginForm(email, password);
    confirmLogin();
  }
}

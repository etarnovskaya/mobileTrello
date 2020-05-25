package com.trello.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends  TestBase{
  @Test
  public void testLogin(){
    app.getSession().initLogin();
    app.getSession().fillLoginForm("rochman.elena@gmail.com", "12345.com");
    //submitLogin
    Assert.assertTrue(app.getSession().waitForElementsPresent(By.xpath("//*[@content-desc='Open Drawer']"), 60));
  }
}

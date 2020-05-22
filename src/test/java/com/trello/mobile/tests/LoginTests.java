package com.trello.mobile.tests;

import org.testng.annotations.Test;

public class LoginTests extends  TestBase{
  @Test
  public void testLogin(){
    app.getSession().initLogin();
    app.getSession().fillLoginForm("rochman.elena@gmail.com", "12345.com");
    //submitLogin
    //Assert
  }
}

package com.trello.mobile.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.trello.mobile.model.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class apiTests {

@Test
    public void testLogin(){
    String baseURL = "http://super-scheduler-app.herokuapp.com/";
    String json = login(baseURL, new User().setEmail("elena28+4@gmail.com").setPassword("Aa1234567")).asString();

    //JsonElement parsed =
    JsonElement parsed = new JsonParser().parse(json);
    String token = parsed.getAsJsonObject().get("token").getAsString();
   // System.out.println(token);
    String status = parsed.getAsJsonObject().get("status").getAsString();
    Assert.assertEquals(status, "Login success", "Status is '" + status + "'. ");
}

@Test
    public void testLoginStatusCode(){
        String baseURL = "http://super-scheduler-app.herokuapp.com/";
        int statusCode = login(baseURL, "elena28+4@gmail.com", "Aa1234567").getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200, "Status is '" + statusCode + "'. ");
    }


    @Test
    public void testLoginTiming(){
        String baseURL = "http://super-scheduler-app.herokuapp.com/";
        long time = login(baseURL, "elena28+4@gmail.com", "Aa1234567").timeIn(SECONDS);
        System.out.println(time);
        Assert.assertTrue(time < 5, "Time responce is " + time + " seconds.");
    }

    private Response login(String baseURL, String email, String password) {
        return RestAssured.given()
                .header("Content-Type", "application/json").given()
                .body("{\"email\" : \"" + email + "\", \"password\": \"" + password + "\"}")
                .when().post(baseURL + "api/login");
    }

    private Response login(String baseURL, User user) {
        return RestAssured.given()
                .header("Content-Type", "application/json").given()
                .body("{\"email\" : \"" + user.getEmail() + "\", \"password\": \"" + user.getPassword() + "\"}")
                .when().post(baseURL + "api/login");
    }
}

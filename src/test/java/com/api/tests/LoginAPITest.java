package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
@Listeners(com.api.listners.TestListner.class)
public class LoginAPITest {
    @Test(description = "Verify if login API is working")
    public void loginTest() {
        /*RestAssured.baseURI = "http://64.227.160.186:8080";
        RequestSpecification x = RestAssured.given();
        RequestSpecification y = x.header("Content-Type","application/json");
        RequestSpecification z = y.body("{\"username\": \"apurva\", \"password\": \"api(learn)!\"}");
        Response response = z.post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);*/

        //use channing
        /*Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json").body("{\"username\": \"apurva\", \"password\": \"api(learn)!\"}").post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);*/
        //Using Authservice
     /*   AuthService authService = new AuthService();
        Response response = authService.login("{\"username\": \"apurva\", \"password\": \"api(learn)!\"}");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);*/

        //Using POJO classes - models
        LoginRequest loginRequest = new LoginRequest("apurva","api(learn)!");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println("Token = " + loginResponse.getToken());
        System.out.println("Username = " + loginResponse.getUsername());
        System.out.println("Email = " + loginResponse.getEmail());
        System.out.println("Id = " + loginResponse.getId());
        Assert.assertTrue(loginResponse.getToken() !=null);
        Assert.assertEquals(loginResponse.getEmail(),"vinpha@yahoo.com");
        Assert.assertEquals(loginResponse.getId(),44);

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

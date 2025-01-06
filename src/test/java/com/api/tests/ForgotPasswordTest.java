package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description = " Verify Forgot password functionality")
    public void forgotPasswordTest(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("adshete@yahoo.com");
        System.out.println("Forgot password response = " + response.asPrettyString());
    }

}

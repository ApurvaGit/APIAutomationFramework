package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Verify Signup functionality")
    public void createAccountTest(){        //This constructs a SignUpRequest object with the provided data using the Builder Pattern and prints its string representation.
        SignUpRequest signUpRequest =  new SignUpRequest.Builder()
                .userName("user0api")
                .password("user0api")
                .email("userapi0@email.com")
                .firstName("userapi0")
                .lastName("Test")
                .mobileNumber("1234567890")
                .build();

        AuthService authService = new AuthService();
        Response response =  authService.signUp(signUpRequest);
        System.out.println("account creation message = "+ response.asPrettyString());
       Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
       Assert.assertEquals(response.statusCode(),200);
    }
}

package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test(description="Verify get profile functionality of User management")
    public void getProfileRequestTest(){
        AuthService authService = new AuthService();
        Response response =  authService.login(new LoginRequest("apurva","api(learn)!"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println("Auth Token = " + loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println("get profile  = " +response.asPrettyString());
        UserProfileResponse userProfileResponse =response.as(UserProfileResponse.class);
        System.out.println("Get UserProfile " + userProfileResponse);
        System.out.println("Get User Name " + userProfileResponse.getUsername());
    }
}

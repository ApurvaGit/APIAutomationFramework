package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(description = "Verify Update functionality using PUT request")
    public void updateProfileTest() {
        AuthService authService = new AuthService();

        //login to the authservice
        Response response = authService.login(new LoginRequest("apurva", "api(learn)!"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        //extract profile by sending auth token
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println("Get Profile response " + response.asPrettyString());

        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "apurva");

        //passing params(ProfileRequest.class) to update the profile
        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("me")
                .lastName("api")
                .email("vinpha@yahoo.com")
                .mobileNumber("0987654321")
                .build();
        //updating profile using ProfileRequest.class
        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        System.out.println("UpdateProfile response " + response.asPrettyString());
    }
}

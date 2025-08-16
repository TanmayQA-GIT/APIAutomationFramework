package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import groovy.util.logging.Log;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listners.Testlistner.class)
public class GetProfileRequestTest {

    @Test(description = "Verify the user profile..")
    public void getProfileInfoTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Tanmay", "Kashyap@1"));
        LoginResponse LoginResponse = response.as(LoginResponse.class);
        System.out.println(LoginResponse.getToken());
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(LoginResponse.getToken());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "Tanmay");

    }

}

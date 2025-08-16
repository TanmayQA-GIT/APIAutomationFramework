package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.api.listners.Testlistner.class)
public class UpdateProfileTest {

    @Test(description = "Verify the profile update api")
    public void updateProfileTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Tanmay", "Kashyap@1"));
        LoginResponse loginresponse = response.as(LoginResponse.class);
        System.out.println(loginresponse.getToken());
        System.out.println("****************************************");
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginresponse.getToken());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getFirstName());
        System.out.println("****************************************");
        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Kashyap")
                .lastName("Parashar")
                .email("test1234@gmail.com")
                .mobileNumber("9999999990")
                .build();

        response=userProfileManagementService.updateProfile(loginresponse.getToken(), profileRequest);

        System.out.println(response.asPrettyString());
    }
}

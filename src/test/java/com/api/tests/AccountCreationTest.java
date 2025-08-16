package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listners.Testlistner.class)
public class AccountCreationTest {

    @Test(description="Verify if SignUp Api is working fine")
    public void createAccountTest()
    {
        SignUpRequest signUpRequest= new SignUpRequest.Builder()
                .username("KashyapSDET")
                .email("test@123456")
                .firstName("tanmay")
                .password("Test009")
                .lastName("Sharma")
                .mobileNumber("3333333330")
                .build();
        AuthService authService = new AuthService();
        Response response=authService.signup(signUpRequest);
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");




    }

}

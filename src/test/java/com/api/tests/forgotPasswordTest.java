package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listners.Testlistner.class)

public class forgotPasswordTest {
    @Test(description="Verify the forgot password option..")
    public void forgotpasswordtest()
    {
        AuthService authService = new AuthService();
       Response response= authService.forgotpassword("test@1234");
        System.out.println(response.asPrettyString());

    }
}

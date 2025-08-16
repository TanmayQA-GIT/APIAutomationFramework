package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Listeners(com.api.listners.Testlistner.class)
public class loginApiTest {

    @Test(description = "Verify if login API is working....")
    public void loginTest() {

        LoginRequest loginRequest = new LoginRequest("Tanmay", "Kashyap@1");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
       LoginResponse loginResponse= response.as(LoginResponse.class);

       // response.as(Class<T> clss )
         // This method converts (or deserializes) the response body (JSON or XML)
         // into a Java object of the given class type.
         // as() internally uses a deserializer like Jackson
         // or Gson to map JSON fields to Java object fields.

        System.out.println(response.asPrettyString());
        System.out.println("Token: "+loginResponse.getToken());
        System.out.println("Username: "+loginResponse.getUsername());
        System.out.println("Email: "+loginResponse.getEmail());
        System.out.println("Role: "+loginResponse.getRoles());

        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(),"tanmay.sharma9411@gmail.com");


    }
}

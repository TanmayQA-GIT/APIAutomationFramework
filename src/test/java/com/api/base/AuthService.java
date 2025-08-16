package com.api.base;

import com.api.models.request.LoginRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService {
    private static final String BASE_PATH = "/api/auth/";

    public Response login(Object payload) {
        return postRequest(payload, BASE_PATH + "login");
    }

    public Response forgotpassword(String emailAddress)
    {
        HashMap<String,String> payload = new HashMap<String,String>();
        payload.put("email",emailAddress);
        return postRequest(payload,BASE_PATH+ "forgot-password");
    }
    public Response signup(Object payload)
    {
        return postRequest(payload,BASE_PATH+ "signup");
    }


}

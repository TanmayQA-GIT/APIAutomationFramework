package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    //wrapper for Rest Assured
    // BASE URI
    // CREATING THE REQUEST
    // HANDLING THE RESPONSE

    private static final String BASE_URI = "http://64.227.160.186:8080";

    private RequestSpecification requestSpecification;

   static  {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService() {
        // default constructor -- to initialise the instance variable.
        // so here request specification will be initialised as BASE_URI is class variable or static
        requestSpecification = given().baseUri(BASE_URI);
    }

    protected void setAuthToken(String token)
    {
        requestSpecification.header("Authorization","Bearer "+token);
    }


    protected Response postRequest(Object payload, String endpoint) {

        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);

    }

    protected Response putRequest(Object payload, String endpoint) {

        requestSpecification.log().all();
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);


    }

    protected Response getRequest(String endpoint) {

        return requestSpecification.get(endpoint);

    }


}

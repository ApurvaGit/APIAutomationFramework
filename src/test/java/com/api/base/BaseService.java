package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    //BASE URI
    //Create REQUEST
    //Handle RESPONSE

    private static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;

    //if you put any code in the static block it will get executed only once, and will be available for all
    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService(){       //Job of constructor is to Initialize the instance variables
        requestSpecification = given().baseUri(BASE_URL);
    }

    public void setAuthToken(String token){
        requestSpecification.header("Authorization","Bearer "+token);

    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    protected Response postRequest(String baseUrl, Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }
    //This method used LoginRequest as a param, so its tightly coupled and can not be used for any other post request, to make it work for all post requests make it loosely coupled by changing the method param to Object as follows
 /*   protected Response postRequest(LoginRequest payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }*/
    protected Response postRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);
    }
}

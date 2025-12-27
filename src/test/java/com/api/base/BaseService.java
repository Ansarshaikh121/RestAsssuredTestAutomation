package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.Filters.LoginFilters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    private final static String BASE_URL = "http://64.227.160.186:8080";

    static
    {
        RestAssured.filters(new LoginFilters());
    }

    RequestSpecification requestSpecification;

    public BaseService()
    {
        requestSpecification = given().baseUri(BASE_URL);
    }
    public void setToken(String token)
    {
        requestSpecification.header("Authorization","Bearer "+token);
    }
    public Response postRequest(Object payload, String endpoint)
    {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }
    public Response getRequest(String endpoint)
    {
        return requestSpecification.contentType(ContentType.JSON).put(endpoint);
    }

}

package com.api.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserManagementService  extends BaseService {

    private final static String BASE_PATH = "/api/users/";

    public Response getProfile(String token)
    {
        setToken(token);
        return getRequest(BASE_PATH+"profile");

    }
}

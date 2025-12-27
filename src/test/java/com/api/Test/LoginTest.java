package com.api.Test;

import com.api.Request.LoginRequest;
import com.api.Response.LoginResponse;
import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginTest {

    AuthService authService = new AuthService();

    @Test(description = "Test Login API")
    public void testLoginAPI()
    {
        LoginRequest loginRequest = new LoginRequest.Builder()
                .UserName("Ansar")
                        .Password("Ansar121").Build();
        Response response = authService.login(loginRequest);
        LoginResponse response1 = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());

        System.out.println("Email ID : "+response1.getEmail());
        System.out.println("Username : "+response1.getUsername());
        System.out.println("Token : "+response1.getToken());



    }
}

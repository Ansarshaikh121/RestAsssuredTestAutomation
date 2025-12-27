package com.api.Test;

import com.api.Request.LoginRequest;
import com.api.Response.LoginResponse;
import com.api.Response.UserProfileResponse;
import com.api.base.AuthService;
import com.api.base.UserManagementService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileTest {

    UserManagementService userManagementService = new UserManagementService();
    AuthService authService = new AuthService();

    @Test(description = "Get Profile Test")
    public void ProfileToGet()
    {
        LoginRequest loginRequest = new LoginRequest.Builder()
                .UserName("Ansar")
                .Password("Ansar121").Build();
        Response response = authService.login(loginRequest);
        LoginResponse response1 = response.as(LoginResponse.class);
        System.out.println(response1.getToken());

        Response response2 = userManagementService.getProfile(response1.getToken());

        UserProfileResponse userProfileResponse = response2.as(UserProfileResponse.class);
        System.out.println(response2.asPrettyString());

        System.out.println(userProfileResponse.getemail());


    }
}

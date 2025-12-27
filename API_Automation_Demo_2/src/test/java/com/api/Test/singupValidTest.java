package com.api.Test;

import com.api.Request.SingupRequest;
import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class singupValidTest {

    AuthService authService = new AuthService();

    @Test(description = "Singup Test")
    public void singupValidTest()
    {
        SingupRequest singupRequest = new SingupRequest.Builder()
                .UserName("Shiba1211")
                .password("Shiba@123")
                .email("ShibaSh@gmail.com")
                .lastName("Shaikhh")
                .firstName("Shibad")
                .mobileNumber("7498562564")
                .Build();

        Response response = authService.singup(singupRequest);
        System.out.println(response.asPrettyString());
    }
}

package com.api.Test;

import com.api.Request.ForgotPasswordRequest;
import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    AuthService authService = new AuthService();

    @Test(description = "Forgot Password Test")
    public void forgotPassword()
    {
        ForgotPasswordRequest forgotPasswordTest = new ForgotPasswordRequest.Builder()
                .email("ansarshaikh121@gmai.com")
                .Build();

        Response response = authService.forgotpassword(forgotPasswordTest);
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.asPrettyString(),"{\n" +
                "    \"message\": \"If your email exists in our system, you will receive reset instructions.\"\n" +
                "}" +
                "");
    }
}

package com.api.Filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginFilters implements Filter {

    private static final Logger logger = LogManager.getLogger(LoginFilters.class);


    public void logRequest(FilterableRequestSpecification requestSpec)
    {
        logger.info("BASE URL : "+requestSpec.getBaseUri());
        logger.info("Header : "+requestSpec.getHeaders());
        logger.info("Body : "+requestSpec.getBody());
    }
    public void logResponse(Response response)
    {
        logger.info("Status Code : "+response.getStatusCode());
        logger.info("Header : "+response.headers());
        logger.info("Header : "+response.body().prettyPrint());
    }


    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {

        logRequest(requestSpec);
        Response response = ctx.next(requestSpec,responseSpec);
        logResponse(response);
        return response;
    }
}

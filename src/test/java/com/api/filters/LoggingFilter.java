package com.api.filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);    //Request is going to executed
        logResponse(response);
        return response;        //return for assertions
    }

    public void logRequest(FilterableRequestSpecification filterableRequestSpecification) {
        logger.info("BASE_URI: " + filterableRequestSpecification.getBaseUri());
        logger.info("Request Header: " + filterableRequestSpecification.getHeaders());
        logger.info("PayLoad: " + filterableRequestSpecification.getBody());
        // logger.info("BASE_URI: " + filterableRequestSpecification.getBaseUri());
    }

    public void logResponse(Response response) {
        logger.info("Response Status code : " + response.getStatusCode());
        logger.info("Response Header: " + response.headers());
        logger.info("Response Body : " + response.getBody().prettyPrint());
    }
}

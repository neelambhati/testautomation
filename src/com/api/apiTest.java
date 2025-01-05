package com.api;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiTest {

	public static void main(String[] args) {
		Response response = RestAssured.given()
	            .baseUri("https://api.coindesk.com/v1/bpi/currentprice.json").get();
	        response.then().statusCode(200);
		
	// Verify the response contains the expected BPIs (USD, GBP, EUR)
    response.then().body("bpi", hasKey("USD"));
    response.then().body("bpi", hasKey("GBP"));
    response.then().body("bpi", hasKey("EUR"));

    // Verify the 'GBP' description equals 'British Pound Sterling'
    response.then().body("bpi.GBP.description", equalTo("British Pound Sterling"));
//sop
	}

}

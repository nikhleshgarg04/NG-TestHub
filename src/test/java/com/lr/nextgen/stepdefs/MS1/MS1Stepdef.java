package com.lr.nextgen.stepdefs.MS1;

import java.util.HashMap;
import java.util.Map;

import com.lr.nextgen.base.BaseClass;
import com.lr.nextgen.endppoint.APIEndPoints;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.config.EncoderConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class MS1Stepdef extends BaseClass {

	public static EncoderConfig encoderconfig = new EncoderConfig();
	
	@Given("^i have a url and login credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_have_a_url_and_login_credentials_and(String arg1, String arg2) {
	    // Write code here that turns the phrase above into concrete actions
		//System.out.println(BaseURL + APIEndPoints.ENDPOINT_2);
		/*
		 * Map<String, String> param = new HashMap<>(); param.put("lat", "36.7201600");
		 * param.put("lng", "-4.4203400");
		 */
		System.out.println("entering into reset call now");
		APP_LOG.info(BaseURL+APIEndPoints.ENDPOINT_2);
		Header someHeader = new Header("Accept", "application/json");
		//RequestSpecification request=null;
		//request.accept("*/*");
		//request.body(null);
		//request.relaxedHTTPSValidation();
		//response = request.get(BaseURL+APIEndPoints.ENDPOINT_2);
		
		String BaseURL = "http://api.sunrise-sunset.org";
		 //given().header(someHeader).and().expect().body(equalTo("x
		response = SerenityRest.when().get(BaseURL.concat(APIEndPoints.ENDPOINT_2));
				//(BaseURL + APIEndPoints.ENDPOINT_2);
		//SerenityRest.given().queryParams(param).get(BaseURL + APIEndPoints.ENDPOINT_1);
	   System.out.println("rest call completed");
	   response.then().log().status();
	   System.out.println("now pringint body");
	   System.out.println();
	   response.prettyPrint();
	   System.out.print("now printing pretty body");
	   System.out.println();
	   response.then().log().all(true);
	   APP_LOG.info(response.asString());
	}


	/*
	 * @When("^I input given credentials and press login$") public void
	 * i_input_given_credentials_and_press_login() { // Write code here that turns
	 * the phrase above into concrete actions // throw new PendingException(); }
	 * 
	 * @Then("^i will be navigated to login home page$") public void
	 * i_will_be_navigated_to_login_home_page(DataTable dt) { // Write code here
	 * that turns the phrase above into concrete actions // throw new
	 * PendingException(); }
	 */
}

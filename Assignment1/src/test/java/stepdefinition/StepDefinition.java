package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	@Given("I set POST student service api endpoint")
	public void i_set_post_student_service_api_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    String addUrl = "http://localhost:8081/student/addStudents";
	    System.out.println("Add url"+addUrl);
	    //throw new io.cucumber.java.PendingException();
	    
	}

	@When("I set request header")
	public void i_set_request_header() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("set record");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("send a Post http request")
	public void send_a_post_http_request() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("send request");
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("I receive valid response")
	public void i_receive_valid_response() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("receive valid response");
	   // throw new io.cucumber.java.PendingException();
	}
	
}

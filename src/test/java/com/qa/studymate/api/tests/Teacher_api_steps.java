package com.qa.studymate.api.tests;

import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class Teacher_api_steps extends ApiBase {

    @Given("the endpoint path is {string}")
    public void the_endpoint_path_is(String endpoint) {
        request = request.basePath(endpoint);
    }

    @Given("then request content type is {string}")
    public void then_request_content_type_is(String contentType) {
        request = request.contentType(contentType);
    }

    @When("I send a POST request")
    public void i_send_a_post_request() {
        response = request.post();
    }

}

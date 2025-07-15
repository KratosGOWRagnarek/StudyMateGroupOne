package com.qa.studymate.api.tests;

import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class Group_api_steps extends ApiBase {


    @When("I send GET request")
    public void i_send_get_request() {
        response = request.get();

    }

    @Then("verify group response contains expected text")
    public void verify_group_response_contains_expected_text() {
        String responseBody = response.asPrettyString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body:" + response.getBody().asPrettyString());

        Assert.assertTrue(responseBody.contains("objects"));
        Assert.assertTrue(responseBody.contains("name"));

    }


    @When("I send DELETE request")
    public void i_send_delete_request() {
        response = request.delete();

    }

}

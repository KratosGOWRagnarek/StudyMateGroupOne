package com.qa.studymate.api.tests;

import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Student_api_steps extends ApiBase {
    @Then("verify response contains expected text")
    public void verify_group_response_contains_expected_text() {
        String responseBody = response.asPrettyString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body:" + response.getBody().asPrettyString());

        Assert.assertTrue(responseBody.contains("objects"));
    }
}

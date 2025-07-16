package com.qa.studymate.api.tests;
import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Map;

public class Student_api_steps extends ApiBase {
    @Then("verify response contains expected text")
    public void verify_group_response_contains_expected_text() {
        String responseBody = response.asPrettyString();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body:" + response.getBody().asPrettyString());

        Assert.assertTrue(responseBody.contains("objects"));
    }

    @Given("the request body contains following fields")
    public void the_request_body_contains_following_fields(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asMap();
        Map<String, String> data = dataTable.asMap();
        for (String key : data.keySet()) {
            requestBody.put(key, data.get(key));
        }
        request = request.body(requestBody.toString());
    }
}

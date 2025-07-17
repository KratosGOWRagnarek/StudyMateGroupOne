package com.qa.studymate.api.tests;

import com.qa.studymate.api.pojo.ApiBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
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

    @Given("the request body contains fields")
    public void the_request_body_contains_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if ("courses".equalsIgnoreCase(key)) {
                JSONArray coursesArray = new JSONArray();
                if (!value.trim().isEmpty()) {
                    for (String course : value.split(",")) {
                        coursesArray.put(Integer.parseInt(course.trim()));
                    }
                }
                requestBody.put("courses", coursesArray);
            } else {
                requestBody.put(key, value);
            }
        }
        request = request.body(requestBody.toString());
        System.out.println("Final Request Body:");
        System.out.println(requestBody.toString(2)); // Pretty print
    }

}

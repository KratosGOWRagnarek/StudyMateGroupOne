package com.qa.studymate.ui.stepDefinitions;

import com.qa.studymate.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class LoginStepDef {
    WebDriver driver = Driver.getDriver("chrome");
    LoginPage loginPage = new LoginPage(driver);

    @Given("User enters valid credentials and logs in")
    public void user_enters_valid_credentials_and_logs_in() {
        loginPage.login(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
    }

    @Then("verify user is on proper page")
    public void verify_user_is_on_proper_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(ConfigReader.readProperty("expected_url")));
        String expectedUrl = ConfigReader.readProperty("expected_url");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Given("User chooses {string}")
    public void user_chooses(String language) {
        loginPage.chooseLanguage(language);
    }

    @Given("User enters {string} and {string}")
    public void user_enters_and(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("User should see {string}")
    public void user_should_see(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getLoginErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}

package com.qa.studymate.ui.stepDefinitions;

import com.qa.studymate.ui.pages.GroupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import java.io.File;
import java.time.Duration;


public class GroupStepDef {

    WebDriver driver = Driver.getDriver("chrome");
    GroupPage groupPage = new GroupPage(driver);

    @Given("User creates group and enters {string}, {string}, {string}, {string}")
    public void user_creates_group_and_enters(String groupImagePath, String groupName, String groupDate, String groupDescription) {
        String absolutePath = new File(groupImagePath).getAbsolutePath();
        groupPage.createGroup(absolutePath, groupName, groupDate, groupDescription);
    }

    @Then("validate {string}")
    public void validate(String expectedCreatedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(groupPage.groupCreatedMessage));
        Assert.assertEquals(expectedCreatedMessage, groupPage.groupCreatedMessage.getText());
    }

    @Then("User deletes created {string} and validates {string}")
    public void user_deletes_created_group_and_validates(String groupName, String expectedDeletedMessage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        groupPage.deleteGroup(groupName);
        wait.until(ExpectedConditions.visibilityOf(groupPage.groupDeletedMessage));
        Assert.assertEquals(expectedDeletedMessage, groupPage.groupDeletedMessage.getText());

    }
}

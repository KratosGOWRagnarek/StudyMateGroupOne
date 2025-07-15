package com.qa.studymate.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

import static utils.Driver.driver;

public class GroupPage {

    public GroupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Create group']")
    public WebElement createGroupButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement groupImageInput;

    @FindBy(css = "input[name='name']")
    public WebElement groupNameInput;

    @FindBy(css = "input[name='dateOfFinish']")
    public WebElement groupDateInput;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement groupDescriptionInput;

    @FindBy(xpath = "//button[.='Create']")
    public WebElement groupCreateButton;

    @FindBy(xpath = "//p[.='Group successfully saved']")
    public WebElement groupCreatedMessage;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement confirmGroupDeleteButton;

    @FindBy(xpath = "//p[.='Group successfully moved to trash']")
    public WebElement groupDeletedMessage;


    public void createGroup(String groupImagePath, String groupName, String groupDate, String groupDescription) {
        createGroupButton.click();
        groupImageInput.sendKeys(groupImagePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(groupNameInput));
        groupNameInput.sendKeys(groupName);
        groupDateInput.click();
        groupDateInput.sendKeys(groupDate);
        groupDescriptionInput.click();
        groupDescriptionInput.sendKeys(groupDescription);
        groupCreateButton.click();
    }


    public void deleteGroup(String groupName) {
        By locator = By.xpath("//div[.='" + groupName + "']/following::button[1]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement deleteAndEditMenu = wait.until(ExpectedConditions.elementToBeClickable(locator));
        BrowserUtils.clickJS(driver, deleteAndEditMenu);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='" + groupName + "']/following::li[contains(., 'Delete group') and @tabindex='-1'][1]")));
        WebElement deleteButton = driver.findElement(By.xpath("//div[.='" + groupName + "']/following::li[contains(., 'Delete group') and @tabindex='-1'][1]"));
        BrowserUtils.clickJS(driver, deleteButton);
        wait.until(ExpectedConditions.elementToBeClickable(confirmGroupDeleteButton));
        confirmGroupDeleteButton.click();
    }
}




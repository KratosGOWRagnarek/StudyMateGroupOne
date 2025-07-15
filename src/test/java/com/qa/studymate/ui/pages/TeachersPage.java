package com.qa.studymate.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

import static utils.Driver.driver;

public class TeachersPage {
    public TeachersPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(text(),'Teachers')]")
    public WebElement teachersSection;

    @FindBy(xpath = "(//button[normalize-space()='Add teacher'])[1]")
     public WebElement addTeacherButton;

    @FindBy(xpath = "//input[@name='name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='email']")
   public WebElement emailAddress;

    @FindBy(xpath = "//input[@name='specialization']")
    public WebElement specialization;

    @FindBy(xpath = "//div[@class='MuiFormControl-root css-ccwj9y']")
    WebElement chooseCoursesButton;

    @FindBy(xpath = "//ul/li[1]//input")
   public WebElement automationBox;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement addButton;

    @FindBy (xpath = "/html/body/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[6]/div/button")
    public WebElement deleteDropDown;

    @FindBy(xpath = "//li[.='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[.='Delete']")
    private WebElement redDeleteButton;

    @FindBy(xpath = "//tbody")
    public WebElement table;

    public void addTeacherInfoFunctionality(String name, String lastName, String num, String email, String special) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement teachersSection = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(text(),'Teachers')]")));
        teachersSection.click();
        addTeacherButton.click();
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.phoneNumber.click();
        this.phoneNumber.sendKeys(num);
        this.emailAddress.sendKeys(email);
        this.specialization.sendKeys(special);
    }
        public void courseButton() throws InterruptedException {
        chooseCoursesButton.click();
        automationBox.click();
        Thread.sleep(2000);
            WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", button);
        }
    public void verifyTeacherAdded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(table, "Kelly"));
        Assert.assertTrue(table.getText().contains("Kelly"));
    }
    public void deleteTeacher(String specialization) throws InterruptedException {
        Thread.sleep(3000);
        WebElement locator = driver.findElement(By.xpath("//td[.='" + specialization + "']/following-sibling::td//button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        BrowserUtils.clickJS(driver, locator);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[.='" + specialization + "']/following::li[contains(., 'Delete') and @tabindex='-1'][1]")
        ));
        WebElement deleteButton = driver.findElement(
                By.xpath("//td[.='" + specialization + "']/following::li[contains(., 'Delete') and @tabindex='-1'][1]")
        );
        BrowserUtils.clickJS(driver, deleteButton);
        BrowserUtils.clickJS(driver,redDeleteButton);
        Thread.sleep(3000);

    }

    }





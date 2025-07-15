package com.qa.studymate.ui.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.Driver;

import static utils.ConfigReader.readProperty;

public class Hook {


    public WebDriver driver;

//    @Before
//    public void setup() {
//        driver = Driver.getDriver("chrome");
//        driver.get(readProperty("url"));
//    }
//
//    @After
//    public void tearDown(Scenario scenario) {
//        BrowserUtils.getScreenShotCucumber(driver, scenario);
//        Driver.closeDriver();
//    }
}



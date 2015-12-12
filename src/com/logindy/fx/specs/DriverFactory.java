package com.logindy.fx.specs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;

public class DriverFactory {

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    @BeforeSuite
    public void Setup() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
    }
}

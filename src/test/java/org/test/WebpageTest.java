package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://kaushik-web-arch.github.io/cie/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Personal Portfolio";
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertTrue(actualTitle.contains("Portfolio"), "Title should contain 'Portfolio'");
    }

    @Test
    public void portfolioValidationTest() {
        WebElement heading = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(heading.getText(), "Student Personal Portfolio");

        WebElement contactBtn = driver.findElement(By.id("contactBtn"));
        contactBtn.click();

        String messageText = driver.findElement(By.id("message")).getText();
        Assert.assertTrue(messageText.contains("Thank you"), "Contact message should appear after clicking button");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}

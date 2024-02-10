package com.fast_fingers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

public class FastFingersAutomation {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://10fastfingers.com/typing-test/english");
        WebElement denyButton = driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonDecline']"));
        WebElement inputButton = driver.findElement(By.xpath("//input[@id='inputfield']"));


        denyButton.click();
        // fastFingersPage.denyButton.click();
        List<WebElement> spans = driver.findElements(By.xpath("//*[@id=\"row1\"]/span"));
        //  List<WebElement> spans = driver.findElements(By.cssSelector("#row1 span"));

        for (WebElement span : spans) {
            String text = span.getText();
            //fastFingersPage.inputButton.sendKeys(text, " ");
            inputButton.sendKeys(text, " ");

        }
        BrowserUtils.sleep(55);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement textWPM = driver.findElement(By.xpath("//td[@id='wpm']"));
        Assert.assertTrue(textWPM.isDisplayed());
        System.out.println(textWPM.getText());


        driver.close();
    }
}



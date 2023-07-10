package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Elements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class Tests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeSuite
    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://swanker.club/");

    }
    @AfterSuite
    public void tearDown(){
        driver.close();
        driver.quit();
    }
    @Test
    public void authorisationTest1(){
        Elements.headerSignInButton(driver).click();
        assertEquals(driver.getCurrentUrl(),"https://swanker.club/auth/sign-in/");
        Elements.signInLoginField(driver).sendKeys("testcontroller338@gmail.com");
        Elements.signInPasswordField(driver).sendKeys("@!ddgJSSzDz39cD");
        Elements.signInButtonLogin(driver).click();
        WebElement verify = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(Elements::headerMyProfileButton);
        assertEquals(verify.getText(), "My Profile");
        System.out.println("authorisation complete!");

    }
    @Test
    public void changePass(){
        Elements.headerMyProfileButton(driver).click();

        wait.until(ExpectedConditions.elementToBeClickable(Elements.myProfileMenuEmailAndPass(driver)));
        assertEquals(driver.getCurrentUrl(),"https://swanker.club/profile/general");

        Elements.myProfileMenuEmailAndPass(driver).click();
        assertEquals(driver.getCurrentUrl(),"https://swanker.club/profile/email-password");

        Elements.emailAndPasswordChangeButton(driver).click();
//        wait.until(ExpectedConditions.elementToBeClickable(Elements.emailAndPasswordPasswordField(driver)));

        WebElement assertNewPass = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(Elements::emailAndPasswordNewPasswordField);
        assertEquals(assertNewPass.getAttribute("name"), "newPassword");

        Elements.emailAndPasswordPasswordField(driver).sendKeys("@!ddgJSSzDz39cD");
        Elements.emailAndPasswordNewPasswordField(driver).sendKeys("@!ddgJSSzDz39cDs");
        Elements.emailAndPasswordSaveButton(driver).click();
        WebElement assertChange = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(Elements::emailAndPasswordChangeButton);
        assertEquals(assertChange.getText(), "Change");
        Elements.myProfileMenuLogOut(driver).click();
        System.out.println("Change pass test complete!");
    }
}

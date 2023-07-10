package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
    private static WebElement element;

    public static WebElement headerSignInButton(WebDriver driver){
        element = driver.findElement(By.xpath("//a[text()=\"Sign in\"]"));
        return element;
    }
    public static WebElement signInLoginField(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id='login']"));
        return element;
    }
    public static WebElement signInPasswordField(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id='password']"));
        return element;
    }
    public static WebElement signInButtonLogin(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@class='btn d-block w-100']"));
        return element;
    }
    public static WebElement headerMyProfileButton(WebDriver driver){
        element = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-outline-light sw-profile-btn']"));
        return element;
    }
    public static WebElement myProfileMenuEmailAndPass(WebDriver driver){
        element = driver.findElement(By.xpath("//li[2]//a[@class = 'sw-profile-menu__link d-none d-lg-block']"));
        return element;
    }
    public static WebElement emailAndPasswordChangeButton(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@class = 'btn']"));
        return element;
    }
    public static WebElement emailAndPasswordNewPasswordField(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id= 'newPassword']"));
        return element;
    }
    public static WebElement emailAndPasswordPasswordField(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id= 'password']"));
        return element;
    }
    public static WebElement emailAndPasswordSaveButton(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@class= 'btn w-100']"));
        return element;
    }
    public static WebElement myProfileMenuLogOut(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@class= 'sw-profile-menu__button']"));
        return element;
    }
}

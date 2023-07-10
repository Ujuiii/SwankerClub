package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Tests {
    private WebDriver driver;


    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }
}

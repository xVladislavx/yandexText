package AgoraSelenium;

import AgoraPageObjectSelenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class AgoraTestNewSelenium {
    AgoraPageObjectSelenium agoraSelenium;
    WebDriver webDriver;

    @BeforeMethod
    public void st() throws InterruptedException {
        File file = new File("C:/Users/Vladislav/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://agorafreight.com/book/wizard");
        agoraSelenium = new AgoraPageObjectSelenium(webDriver);
    }

    @AfterMethod
    public void closeIt(){
        try {
            String command = "cmd /c taskkill /f /im chrome.exe";
            Runtime.getRuntime().exec(command);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        webDriver.close();
    }

    @Test(invocationCount = 10)
    public void test(){
        //System.out.println(agoraSelenium.flag);
        agoraSelenium.flagClick(20L);
        agoraSelenium.engFlagClick(20L);
        agoraSelenium.cookieClick(20L);
    }
}

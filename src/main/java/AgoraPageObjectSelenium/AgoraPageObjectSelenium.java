package AgoraPageObjectSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgoraPageObjectSelenium {

    protected static WebDriver webDriver;
    public AgoraPageObjectSelenium(WebDriver webDriver) throws InterruptedException {
        this.webDriver = webDriver;
        waitForLoad(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void waitForLoad(WebDriver webDriver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState")
                    .equals("complete"); }
            };

        WebDriverWait wait = new WebDriverWait(webDriver, 6);
        try { waitSec(3); }
        catch (Exception e) { }
        try { wait.until(pageLoadCondition); }
        catch (Exception a) { }
    }

    public void waitSec(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    @FindBy(xpath = "//*[@id=\"react-select-2--value-item\"]")
    public WebElement flag;

    @FindBy(xpath = "//*[@id=\"react-select-2--option-0\"]")
    public WebElement englishFlag;

    @FindBy(xpath = "//*[@id=\"react-select-2--option-1\"]")
    public WebElement russianFlag;

    @FindBy(className = "fa-close")
    public WebElement cookie;



    public void flagClick(Long timeout){
        WebDriverWait wait = new WebDriverWait(webDriver, timeout.intValue());
        try{
            wait.until(ExpectedConditions.visibilityOf(flag));
            wait.until(ExpectedConditions.elementToBeClickable(flag));
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", flag);
            flag.click();
        }
        catch (Exception e){
        }
    }

    public void engFlagClick(Long timeout){
        WebDriverWait wait = new WebDriverWait(webDriver, timeout.intValue());
        try{
            wait.until(ExpectedConditions.visibilityOf(englishFlag));
            wait.until(ExpectedConditions.elementToBeClickable(englishFlag));
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", englishFlag);
            englishFlag.click();
        }
        catch (Exception e){
        }
    }

    public void cookieClick(Long timeout){
        WebDriverWait wait = new WebDriverWait(webDriver, timeout.intValue());
        try{
            wait.until(ExpectedConditions.visibilityOf(cookie));
            wait.until(ExpectedConditions.elementToBeClickable(cookie));
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", cookie);
            cookie.click();
        }
        catch (Exception e){
        }
    }
}

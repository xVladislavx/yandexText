package AgoraFreight;

import com.codeborne.selenide.SelenideElement;

//import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Flag {
    private SelenideElement flag;

    public void clickOnFlag() throws InterruptedException {
        flag = $(By.className("header__buttons_language-switcher"));
        flag.click();
    }

    public void getEnglishFlag() throws InterruptedException{
        $(By.className("Select-menu-outer")).find(By.id("react-select-2--option-0")).click();
    }
}

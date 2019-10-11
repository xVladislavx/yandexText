package AgoraFreight;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Flag {
    private SelenideElement flag;

    public void clickOnFlag() {
        flag = $(By.className("header__buttons_language-switcher"));
        flag.click();
    }

    public void getEnglishFlag() {
        $(By.className("Select-menu-outer")).find(By.id("react-select-2--option-0")).click();
    }

    public void getRussianFlag() {
        $(By.className("Select-menu-outer")).find(By.id("react-select-2--option-1")).click();
    }
}

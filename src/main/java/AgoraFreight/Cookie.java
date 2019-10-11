package AgoraFreight;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Cookie {

    public void closeCookieInfo(){
        $$(By.className("fa")).filterBy(cssClass("fa-close")).get(0).click();
    }
}

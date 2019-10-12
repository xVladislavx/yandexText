package YandexRequests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Pictures {

    public void findTab(){

        //находим нужную вкладку
        SelenideElement element = $$(By.className("home-link"))
                .findBy(attribute("data-id", "images"))
                .shouldHave(attribute("href", "https://yandex.ru/images/"));
        //проходим по ней
        element.click();
        //выводим url
        System.out.println(url());
    }
}

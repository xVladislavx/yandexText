import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

//import org.junit.Test;
import com.codeborne.selenide.conditions.Text;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import javax.xml.bind.Element;
import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class AgoraTest {

    @Test(invocationCount = 10)
    public void searchingToFrom() throws InterruptedException {
        Configuration.startMaximized = true;
        open("https://agorafreight.com/book/wizard");

        SelenideElement flag;
        SelenideElement from;
        ElementsCollection elements;
        ElementsCollection cities;
        ElementsCollection length;
        ElementsCollection width;
        ElementsCollection height;
        ElementsCollection weight;

        //Выбираем язык. Для этого ищем объект и нажимаем, чтобы раскрыть
        flag = $(By.className("header__buttons_language-switcher"));
        flag.click();
        Thread.sleep(1000);

        //Кликаем именно на английский язык
        $(By.className("Select-menu-outer")).find(By.id("react-select-2--option-0")).click();

        //Ждем немного
        Thread.sleep(3000);
        //Находим выпадающие меню From-To
        elements = $$(By.className("wizard__direction-block_country")).filterBy(text("Country"));

        //выбираем второй список
        from = elements.get(1);
        from.click();
        //Тут была попытка вывода одного единственного элемента профильтрованного по параметрам.
        //Селенид выводит только первый подхъодящий элемент.
        //Похоже, что лучше делать $$, а не $.--->
                /*        System.out.println($(By.className("Select-menu-outer")).find(By.className("Select-menu"))
                                .find(By.className("Select-option")).findAll(By.id("react-select-16--option-1")));

                        System.out.println($(By.className("Select-option")));*/
        $$(By.className("Select-option")).findBy(id("react-select-16--option-2")).click();
        Thread.sleep(1000);

        //////////////////Опции доставки - откуда\\\\\\\\\\\\\\\\\\\\
        ////На инпут кликов не получается - вылезает ошибка
        //$$(By.className("form-check-input")).findBy(name("TO_RAILWAY_HUB")).click();
        //А на лейблы можно
        $$(By.className("form-check-label")).findBy(text("Sea port")).click();
        Thread.sleep(1000);

        //сначала надо открыть выпадающий список
        $(By.className("wizard__direction-block_info-hubs")).click();
        Thread.sleep(1000);

        //выбираем город порта исходный
        System.out.println($$(By.className("Select-option")).filterBy(text("Shanghai, Shanghai, China")));
        ElementsCollection element = $$(By.className("Select-option")).filterBy(text("Shanghai, Shanghai, China"));
        element.get(0).click();
        Thread.sleep(1000);

        //Открываем выпадающее меню для выбора нужного города
        //System.out.println($$(By.className("form-check-label")).findBy(text("Delivery address")));
        cities = $$(By.className("geosuggest__input"));
        cities.get(1).setValue("G");
        Thread.sleep(1000);

        $$(By.className("geosuggest__item")).findBy(text("Gabrovo, Болгария")).click();
        Thread.sleep(1000);

        //Выбираем поля ввода габаритов посылки в зависимости от атрибута
        //System.out.println($$(By.className("form-control")).filterBy(attribute("placeholder")));
        length = $$(By.className("form-control")).filterBy(attribute("placeholder", "L"));
        length.get(0).setValue("100");

        width = $$(By.className("form-control")).filterBy(attribute("placeholder", "W"));
        width.get(0).setValue("20");

        height = $$(By.className("form-control")).filterBy(attribute("placeholder", "H"));
        height.get(0).setValue("200");

        weight = $$(By.className("form-control")).filterBy(attribute("placeholder", "KG"));
        weight.get(0).setValue("200");

        Thread.sleep(3000);

        //////////////////Опции доставки - откуда\\\\\\\\\\\\\\\\\\\\
    }

}

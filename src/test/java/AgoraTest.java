import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class AgoraTest {

    @Test
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
        //Выбираем нужный город
        $$(By.className("Select-option")).findBy(id("react-select-14--option-17")).click();
        Thread.sleep(1000);
        //System.out.println($$(By.className("form-check-label")).findBy(text("Delivery address")));
        cities = $$(By.className("geosuggest__input"));
        cities.get(1).setValue("G");
        Thread.sleep(1000);
        $$(By.className("geosuggest__item")).findBy(text("Gabrovo, Болгария")).click();
        Thread.sleep(1000);

        length = $$(By.className("form-control")).filterBy(id("f-element-9"));
        length.get(0).setValue("100");

        width = $$(By.className("form-control")).filterBy(id("f-element-10"));
        width.get(0).setValue("20");

        height = $$(By.className("form-control")).filterBy(id("f-element-11"));
        height.get(0).setValue("200");

        weight = $$(By.className("form-control")).filterBy(id("f-element-12"));
        weight.get(0).setValue("200");

        Thread.sleep(10000);

        //////////////////Опции доставки - откуда\\\\\\\\\\\\\\\\\\\\
    }

}

package AgoraFreight;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Destination {
    private ElementsCollection destinations;

    //инициализирует коллекцию с блоками From - To
    public void findDestinations(){
        destinations = $$(By.className("wizard__direction-block_country")).filterBy(text("Country"));
    }

    //из коллекции тащит нужный блок
    //принимает одно значение
    public void findArrivalCoutry(){
        SelenideElement fromBlock = destinations.get(1);
        fromBlock.click();
    }

    //выбирает нужную страну доставки в блоке прибытия
    //принимает одно значение
    public void arrivalCountry(){
        SelenideElement departureCountry = $$(By.className("Select-option")).findBy(id("react-select-16--option-2"));
        departureCountry.click();
    }

    //заполняет опции доставки в блоке отправки
    //принимает два значения
    public void departureOptions(String city){
        $$(By.className("form-check-label")).findBy(text("Sea port")).click();//только после выбора "порт" появляется выпадающее меню с городами
        $(By.className("wizard__direction-block_info-hubs")).click(); //открываем список городов
        ElementsCollection element = $$(By.className("Select-option")).filterBy(text(city));
        element.get(0).click();
    }

    //вызов выпадающего меню и поиск в нем нужного города доставки по первой введенной букве
    //принимает два значения
    public void arrivalDropDown(String letter, String city){
        ElementsCollection cities = $$(By.className("geosuggest__input"));// получаем два элемента From и To
        cities.get(1).setValue(letter);
        $$(By.className("geosuggest__item")).findBy(text(city)).click();
    }
}

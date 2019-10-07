package AgoraFreight;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

//import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Destination {
    private ElementsCollection destinations;

    public void findDestinations(){
        destinations = $$(By.className("wizard__direction-block_country")).filterBy(text("Country"));
    }

    public void findArrivalCoutry(){
        SelenideElement fromBlock = destinations.get(1);
        fromBlock.click();
    }

    public void arrivalCoutry(){
        SelenideElement departureCountry = $$(By.className("Select-option")).findBy(id("react-select-16--option-2"));
        departureCountry.click();
    }

    public void departureOptions(){//arrival
        $$(By.className("form-check-label")).findBy(text("Sea port")).click();//только после выбора "порт" появляется выпадающее меню с городами
        $(By.className("wizard__direction-block_info-hubs")).click(); //открываем список городов
        ElementsCollection element = $$(By.className("Select-option")).filterBy(text("Shanghai, Shanghai, China"));
        element.get(0).click();
    }

    public void arrivalDropDown(){
        ElementsCollection cities = $$(By.className("geosuggest__input"));// получаем два элемента From и To
        cities.get(1).setValue("G");
        $$(By.className("geosuggest__item")).findBy(text("Gabrovo, Болгария")).click();
    }
}

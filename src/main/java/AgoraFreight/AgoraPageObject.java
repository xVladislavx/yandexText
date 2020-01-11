package AgoraFreight;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AgoraPageObject {
    private ElementsCollection destinations;
    private SelenideElement flag;
    private double volume;
    private String volumeAsString;

    //////////////////////////////
    /////////FLAG BLOCK///////////
    //////////////////////////////
    public void clickOnFlag() {
        //flag = $(By.className("header__buttons_language-switcher"));
        flag = $(By.xpath("//*[@id=\"react-select-2--value-item\"]/div/span"));
        flag.click();
    }
    //*[@id="react-select-2--value"]/div[2]
    public void getEnglishFlag() {
        /*$(By.className("Select-menu-outer"))
                .find(By.id("react-select-2--option-0")).click();*/
        $(By.xpath("//*[@id=\"react-select-2--option-0\"]")).click();
    }

    public void getRussianFlag() {
/*        $(By.className("Select-menu-outer"))
                .find(By.id("react-select-2--option-1")).click();*/
        $(By.xpath("//*[@id=\"react-select-2--option-1\"]")).click();
    }

    //////////////////////////////
    ////////COOKIES BLOCK/////////
    //////////////////////////////
    public void closeCookieInfo(){
        if($$(By.className("fa-close")).size() > 0){
            $$(By.className("fa-close")).get(0).click();//"cookieInfo__close" works
        }
    }

    //////////////////////////////
    //////DESTINATIONS BLOCK//////
    //////////////////////////////

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
        SelenideElement departureCountry = $$(By.className("Select-option")).findBy(id("react-select-14--option-2"));
        departureCountry.click();
    }

    //заполняет опции доставки в блоке отправки
    //принимает два значения
    public void departureOptions(String city){
        $$(By.className("form-check-label")).findBy(text("Sea port")).click();//только после выбора "порт" появляется выпадающее меню с городами
        $(By.className("wizard__direction-block_info-hubs")).click(); //открываем список городов
        $(By.className("Select-option")).shouldBe(visible);
        ElementsCollection element = $$(By.className("Select-option")).filterBy(text(city));
        element.get(0).click();
    }

    //вызов выпадающего меню и поиск в нем нужного города доставки по первой введенной букве
    //принимает два значения
    public void arrivalDropDown(String letter, String city){
        ElementsCollection cities = $$(By.className("geosuggest__input"));// получаем два элемента From и To
        cities.get(1).setValue(letter);
        $(By.className("geosuggest__item")).shouldBe(visible);
        $$(By.className("geosuggest__item")).findBy(text(city)).click();
    }

    //////////////////////////////
    /////////CARGO BLOCK//////////
    //////////////////////////////

    public void setLength(int len){
        ElementsCollection length = $$(By.className("form-control"))
                .filterBy(attribute("placeholder", "L"));
        length.get(0).setValue(Integer.toString(len));
    }

    public void setWidth(int wid){
        ElementsCollection  width = $$(By.className("form-control"))
                .filterBy(attribute("placeholder", "W"));
        width.get(0).setValue(Integer.toString(wid));
    }

    public void setHeight(int hei){
        ElementsCollection  height = $$(By.className("form-control"))
                .filterBy(attribute("placeholder", "H"));
        height.get(0).setValue(Integer.toString(hei));
    }

    public void setWeight(int wei){
        ElementsCollection  weight = $$(By.className("form-control"))
                .filterBy(attribute("placeholder", "KG"));
        weight.get(0).setValue(Integer.toString(wei));
    }

    public void clickSearch(){
        $$(By.className("align-self-end")).findBy(text("Search")).click();
    }

    public void checkPackageVolume(int length, int width, int height){                              //делаем строку результата как на странице результата
        volume = (length * width * height) / 1000000.0; //конвертируем сантиметры в кубические метры
        volumeAsString = String.format(Locale.US,"%.3f", volume);

        $$(By.className("col-6")).filterBy(text("Volume"))
                .shouldHave(CollectionCondition.texts(volumeAsString));
    }

    public void checkPackageWeight(int weight){
        $$(By.className("col-6")).filterBy(text("Weight"))
                .shouldHave(CollectionCondition.texts(String.valueOf(weight)));
    }

    //getDepartureOptionsCity - здесь надо строку вырезать до запятой, т.к. город - это первое слово
    //$$(By.className("line px-0 col-12")).filterBy(text("From"));//.shouldHave(CollectionCondition.texts(cargoDimensions.getWeightAsString()));
}
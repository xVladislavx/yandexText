import AFTestValues.TestValues;
import AgoraFreight.Cargo;
import AgoraFreight.Cookie;
import AgoraFreight.Destination;
import AgoraFreight.Flag;

import AFTestValues.CargoVolumeCalc;
import AFTestValues.CargoDimensions;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AgoraTestNew {
    private Flag flag = new Flag();
    private Destination destination = new Destination();
    private Cargo cargo = new Cargo();
    private CargoVolumeCalc cargoVolumeCalc;
    private CargoDimensions cargoDimensions =  new CargoDimensions();
    private TestValues testValues = new TestValues();
    private Cookie cookie = new Cookie();

    //Сначала заполняем необходимые тестовые значения
    public void initiateValues(){
        testValues.setLength(100);
        testValues.setHeight(200);
        testValues.setWidth(20);
        testValues.setWeight(200);
        testValues.setDepartureOptionsCity("Shanghai, Shanghai, China");
        testValues.setArrivalDropDownLetter("G");
        testValues.setArrivalDropDownCity("Gabrovo, Болгария");
    }
    @Test//(invocationCount = 10)
    public void test() throws InterruptedException{

        this.initiateValues();
        Configuration.startMaximized = true;
        open("https://agorafreight.com/book/wizard");

        cookie.closeCookieInfo();
        //добавить строки поиска города отправки - прибытия
        cargoDimensions.setLength(testValues.getLength());
        cargoDimensions.setHeight(testValues.getHeight());
        cargoDimensions.setWidth(testValues.getWidth());
        cargoDimensions.setWeight(testValues.getWeight());

        flag.clickOnFlag();
        flag.getEnglishFlag();

        destination.findDestinations();
        destination.findArrivalCoutry();Thread.sleep(500);
        destination.arrivalCountry();
        destination.departureOptions(testValues.getDepartureOptionsCity());Thread.sleep(500);
        destination.arrivalDropDown(testValues.getArrivalDropDownLetter(), testValues.getArrivalDropDownCity());

        cargo.setLength(cargoDimensions.getLength());
        cargo.setWidth(cargoDimensions.getWidth());
        cargo.setHeight(cargoDimensions.getHeight());
        cargo.setWeight(cargoDimensions.getWeight());

        //кликнуть и перейти на завершение заказа
        $$(By.className("align-self-end")).findBy(text("Search")).click();
        Thread.sleep(3000);

        cargoVolumeCalc = new CargoVolumeCalc(cargoDimensions.getLength(), cargoDimensions.getWidth(), cargoDimensions.getHeight());
        cargoVolumeCalc.getPackageVolume();

        $$(By.className("col-6")).filterBy(text("Volume")).shouldHave(CollectionCondition.texts(cargoVolumeCalc.getPackageVolume()));

        $$(By.className("col-6")).filterBy(text("Weight")).shouldHave(CollectionCondition.texts(cargoDimensions.getWeightAsString()));

        //getDepartureOptionsCity - здесь надо строку вырезать до запятой, т.к. город - это первое слово
        $$(By.className("line px-0 col-12")).filterBy(text("From"));//.shouldHave(CollectionCondition.texts(cargoDimensions.getWeightAsString()));
    }
}

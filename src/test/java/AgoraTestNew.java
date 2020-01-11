import AgoraFreight.*;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class AgoraTestNew {

    private AgoraPageObject agora = new AgoraPageObject();

    //Сначала заполняем необходимые тестовые значения
    @DataProvider(name = "values")
    public Object[][] initiateValues(){
        return new Object[][] {{100, 200, 20, 200, "Shanghai, Shanghai, China", "G", "Gabrovo, Bulgaria"},};
    }

    @Test(invocationCount = 10, dataProvider = "values")
    public void test(int length, int width, int height, int weight,
                     String departureCity, String arrivalDropDownLetter, String arrivalDropDownCity){
        Configuration.startMaximized = true;
        open("https://agorafreight.com/book/wizard");

        agora.clickOnFlag();
        agora.getEnglishFlag();
        agora.closeCookieInfo();
        agora.findDestinations();
        agora.findArrivalCoutry();
        agora.arrivalCountry();
        agora.departureOptions(departureCity);
        agora.arrivalDropDown(arrivalDropDownLetter, arrivalDropDownCity);
        agora.setLength(length);
        agora.setWidth(width);
        agora.setHeight(height);
        agora.setWeight(weight);
        agora.clickSearch();
        agora.checkPackageVolume(length, width, height);
        agora.checkPackageWeight(weight);
        /*
        //getDepartureOptionsCity - здесь надо строку вырезать до запятой, т.к. город - это первое слово
        $$(By.className("line px-0 col-12")).filterBy(text("From"));//.shouldHave(CollectionCondition.texts(cargoDimensions.getWeightAsString()));
        //добавить города прибытия и отправки
        */
    }
}

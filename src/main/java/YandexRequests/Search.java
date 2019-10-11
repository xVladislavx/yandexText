package YandexRequests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Search {

    public StringBuilder findFirstInstances(String requests) throws InterruptedException {
        String result;
        ElementsCollection requestsCollection;
        SelenideElement firstRequest;
        String value;
        int start;
        int finish;

        $(By.className("input__control")).setValue(requests);

        Thread.sleep(1000);

        requestsCollection = $$(By.className("suggest2-item"));
        //нужно весь список вытащить с виджетами погоды, а потом достать первый  из них


/*
        firstRequest = requestsCollection.get(0);
        start = firstRequest.toString().indexOf("\"val\":\"") + 7;
        finish = firstRequest.toString().indexOf("\"}}");
        value = firstRequest.toString().substring(start, finish);
*/

        return null;
    }
}

package YandexRequests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Search {
    private StringBuilder stringBuilder = new StringBuilder();

    public StringBuilder findFirstInstances(List<String> requests) throws InterruptedException {
        ElementsCollection requestsCollection;
        SelenideElement firstRequest;
        String value;
        int start;
        int finish;

        for(int i = 0; i < requests.size(); i++){
            $(By.className("input__control")).setValue(requests.get(i));

            Thread.sleep(1000);

            requestsCollection = $$(By.className("suggest2-item"));
            firstRequest = requestsCollection.get(0);
            start = firstRequest.toString().indexOf("\"val\":\"") + 7;
            finish = firstRequest.toString().indexOf("\"}}");
            value = firstRequest.toString().substring(start, finish);

            if(i != 2){
                stringBuilder.append(value + ", ");
            }
            else {
                stringBuilder.append(value);
            }
        }
        return stringBuilder;
    }
}

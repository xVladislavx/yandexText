import YandexRequests.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test(invocationCount = 10)
    public void test() throws InterruptedException {
        Requests requests = new Requests();
        StringBuilder result;
        Search search = new Search();

        Configuration.startMaximized = true;
        open("http://yandex.ru");

        //класс Requests отвечает за хранение искомых значений и формирования из них списка
        requests.setRequest1("погода");
        requests.setRequest2("Липецк");
        requests.setRequest3("Лото");

        requests.fillRequestsList();
        //Класс Search принимает заполненный список из класса Requests и формирует в процессе поиска
        //формирует строку, которую выводим в консоль
        result = search.findFirstInstances(requests.getRequestList());

        System.out.println(result);
    }
}

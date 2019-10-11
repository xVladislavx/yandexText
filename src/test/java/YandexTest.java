import YandexRequests.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test(invocationCount = 10)
    public void test() throws InterruptedException {
        StringBuilder result = new StringBuilder();
        Search search = new Search();

        Configuration.startMaximized = true;
        open("http://yandex.ru");

        //класс Requests отвечает за хранение искомых значений и формирования из них списка
        search.findFirstInstances("погода");

        search.findFirstInstances("Липецк");

        search.findFirstInstances("Лото");

        //Класс Search принимает заполненный список из класса Requests и формирует в процессе поиска
        //формирует строку, которую выводим в консоль

        System.out.println(result);
    }
}

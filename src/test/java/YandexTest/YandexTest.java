package YandexTest;

import YandexRequests.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test(enabled = false)
    public void firstTask(){
        Search search = new Search();
        Configuration.startMaximized = true;
        open("http://yandex.ru");
        //Задание 1
        search.findFirstInstances("погода");
        search.findFirstInstances("Липецк");
        search.findFirstInstances("Лото");
    }

    @Test(enabled = false)
    public void secondTask(){
        Pictures pictures = new Pictures();
        open("http://yandex.ru");

        //Задание 2
        pictures.findTab();
    }

    @Test
    public void thirdTask(){
        Search search = new Search();
        open("http://yandex.ru");
        //Задание 2
        search.findShit("Погода погода в воронеже на 10 дней");
    }
}

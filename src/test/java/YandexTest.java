import YandexRequests.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test
    public void firstTask(){
        Search search = new Search();
        Configuration.startMaximized = true;
        open("http://yandex.ru");
        //Задание 1
        search.findFirstInstances("погода");
        search.findFirstInstances("Липецк");
        search.findFirstInstances("Лото");
    }

    @Test
    public void secondTask(){
        Pictures pictures = new Pictures();
        open("http://yandex.ru");

        //Задание 2
        pictures.findTab();
    }
}

package YandexRequests;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Search {

    public void findFirstInstances(String request){
        String result;
        ElementsCollection widgetsCollection;

        //помещаю в поиск нужное слово
        $(By.className("input__control")).setValue(request);
        //убеждаюсь, что drop-down меню появилось
        $(By.className("i-bem")).shouldBe(visible);
        //убеждаюсь, что все элементы меню загрузились
        $(By.className("suggest2__content")).shouldBe(exist);
        //вынимаю все элемнеты, где есть виджет с погодой
        widgetsCollection = $$(By.className("suggest2-item__fact"));
        //получаю первый элемент там, где их больше 0
        if(widgetsCollection.size() > 0){
            result = "По запросу " + request + " получено значение: " + widgetsCollection.get(0).text();
        }
        else {
            result = "Не найдено значений в градусах Цельсия!";
        }

        System.out.println(result);
    }
}

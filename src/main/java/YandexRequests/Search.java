package YandexRequests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

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

    public void findShit(String request){
        ElementsCollection fuck;
        List<String> shit;
        /** ВВОДИМ В ПОИСК СТРОКУ И ЖМЕМ НА ЭНТЕР */
        $(By.className("input__control")).setValue(request).pressEnter();

        /** ВЫВОДИМ РЕЗУЛЬТАТ ПОИСКА НА СТРАНИЦЕ НУЖНОГО ЭЛЕМЕНТА */
        System.out.println($(By.className("weather-forecast__current-temp")).getText());

        /** ЗАПИХИВАЕМ ЭЛЕМЕНТЫ В МАССИВ */
        fuck = $$(By.className("weather-forecast__current-temp")); //Ищем код элемента целиком
        shit = $$(By.className("weather-forecast__current-temp")).texts(); //Ищем только текст в коде элемента

        /** ЗАПИХИВАЕМ ЭЛЕМЕНТЫ В МАССИВ */
        System.out.println($$(By.className("weather-forecast__current-temp")));
        for(SelenideElement dick : fuck){
            //Assert
            Assert.assertEquals("0°", dick.text());
            //Verify
            Verify.verify(dick.text().equals("0°"));
            //if-else
            if(dick.text().equals("0°")){
                System.out.println("FOUND IT");
            }
        }

        for(String string : shit){
            if(string.equals("0°")){
                System.out.println("FOUND IT");
            }
        }
    }
}

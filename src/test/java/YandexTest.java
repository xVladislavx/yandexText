import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexTest {

    @Test
    public void searchingFruitMice(){
        List<String> headers = new ArrayList<String>();
        ElementsCollection elements;
        ElementsCollection responses;
        List<String> links = new ArrayList<String>();
        List<String> textFragments = new ArrayList<String>();
        Map<String, String> textFragmentsMap = new HashMap<String, String>();

        String word = "матч";
        String request = "футбол";

        //открываем яндекс
        open("http://yandex.ru");

        //в поисковую строку помещаем фразу, нажимаем enter
        $(By.name("text")).setValue(request).pressEnter();

        //Находим заголовки ответов на мой запрос
        elements = $$(By.className("organic__url-text"));

        //Добавлем в список обнесенные тегами строки, содержащие названия гиперссылок, извлеченных из объектов,
        //полученных по результатам запроса
        for(int i = 0; i < elements.size(); i++){
            String header = elements.get(i).toString();
            header = header.substring(header.indexOf("\">")+2, header.indexOf("</div>"));
            headers.add(header);
        }

        //формируем коллекцию ElementsCollection по имени класса и атрибутов
        responses = $$(By.className("link"))
                .filterBy(cssClass("organic__url"))
                .filterBy(cssClass("link_cropped_no"))
                .filterBy(attribute("data-counter"));

        //Нужные нам ссылки находятся между начальной и конечной подстроками
        String linkSubStringBeginning = "data-counter=\"[\"rc\",\"";
        String linkSubStringEnd = "\"]\"";

        //Находим подстроку из объектов коллекции, преобразованных в строки,
        //выделяем из них ссылки на страницы, помещаем их в коллекции
        for(int i = 0; i < responses.size(); i++){
            String str = responses.get(i).toString();
            str = str.substring((str.indexOf(linkSubStringBeginning)),
                    str.indexOf(linkSubStringEnd)).substring(linkSubStringBeginning.length());
            links.add(str);
        }

        //Получаем из коллекции ссылки и открываем их в браузере
        //По тегу body выгружаем в строку текст страницы
        //Проверяем наличие искомой подстроки в тексте,
        //в случае необнаружения выводим оповещение
        //иначе, обрезаем ПЕРВЫЙ ФРАГМЕНТ текста, где встречается искомое слово и
        //формируем Мапу, где K - ссылка, полученная из коллекции по индексу, а V - обрезанный текст, там где была
        //найдена подстрока, там где ее нет - оповещение.
        for(int i = 0; i < links.size(); i++){
            String link = links.get(i);
            //String header = headers.get(i);
            open(link);
            String body = $(By.tagName("body")).toString();

            if(body.contains(word)){
                String text = body.substring(body.indexOf(word)-30, body.indexOf(word)+30).trim();
                textFragmentsMap.put(link, text);
                textFragments.add(text);
            }
            else{
                textFragmentsMap.put(link, "ПОДСТРОКА НЕ НАЙДЕНА");
                textFragments.add("ПОДСТРОКА НЕ НАЙДЕНА");
            }

            //System.out.println("Header is: " + header);
            System.out.println("Link is: " + link);
            System.out.println("Value for link is: " + textFragmentsMap.get(link).trim());
            //System.out.println("Value for from index " + i + " is: " + textFragments.get(i));
        }
    }
}

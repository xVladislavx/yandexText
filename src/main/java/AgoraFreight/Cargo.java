package AgoraFreight;

import com.codeborne.selenide.ElementsCollection;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Cargo {

    public void setLength(int len){
        ElementsCollection length = $$(By.className("form-control")).filterBy(attribute("placeholder", "L"));
        length.get(0).setValue(Integer.toString(len));
    }

    public void setWidth(int wid){
        ElementsCollection  width = $$(By.className("form-control")).filterBy(attribute("placeholder", "W"));
        width.get(0).setValue(Integer.toString(wid));
    }

    public void setHeight(int hei){
        ElementsCollection  height = $$(By.className("form-control")).filterBy(attribute("placeholder", "H"));
        height.get(0).setValue(Integer.toString(hei));
    }

    public void setWeight(int wei){
        ElementsCollection  weight = $$(By.className("form-control")).filterBy(attribute("placeholder", "KG"));
        weight.get(0).setValue(Integer.toString(wei));
    }
}

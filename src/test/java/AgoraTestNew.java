import AgoraFreight.Cargo;
import AgoraFreight.Destination;
import AgoraFreight.Flag;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class AgoraTestNew {
    private Flag flag = new Flag();
    private Destination destination = new Destination();
    private Cargo cargo = new Cargo();

    @Test(invocationCount = 10)
    public void test() throws InterruptedException{
        Configuration.startMaximized = true;
        open("https://agorafreight.com/book/wizard");

        flag.clickOnFlag();
        //Thread.sleep(1000);
        flag.getEnglishFlag();
        //Thread.sleep(1000);

        destination.findDestinations();
        //Thread.sleep(1000);
        destination.findArrivalCoutry();
        Thread.sleep(500);
        destination.arrivalCoutry();
        //Thread.sleep(1000);
        destination.departureOptions();
        Thread.sleep(500);
        destination.arrivalDropDown();
        //Thread.sleep(1000);

        cargo.setLength(100);
        //Thread.sleep(1000);
        cargo.setWidth(20);
        //Thread.sleep(1000);
        cargo.setHeight(200);
        //Thread.sleep(1000);
        cargo.setWeight(200);
        //Thread.sleep(1000);
    }
}

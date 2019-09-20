import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Third extends Second{
    @AfterSuite
    public void forth(){
        System.out.println("Inner After Suite");
    }
    @Test
    public void third(){
        System.out.println("~");
    }
}

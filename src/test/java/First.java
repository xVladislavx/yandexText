import org.testng.annotations.*;

public class First {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("First After Suite");
    }
    @Test
    public void one(){
        System.out.println("1");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

/*
    @Test
    public void three(){
        System.out.println("Parent here");
    }*/
}

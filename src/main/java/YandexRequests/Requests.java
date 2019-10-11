package YandexRequests;

import java.util.ArrayList;
import java.util.List;

public class Requests {
    private String request1;
    private String request2;
    private String request3;
    private List<String> requests = new ArrayList<String>();

    public void setRequest1(String text){
        this.request1 = text;
    }
    public String getRequest1(){
        return this.request1;
    }

    public void setRequest2(String text){
        this.request2 = text;
    }
    public String getRequest2(){
        return this.request2;
    }

    public void setRequest3(String text){
        this.request3 = text;
    }
    public String getRequest3(){
        return this.request3;
    }

    public void fillRequestsList(){
        requests.add(getRequest1());
        requests.add(getRequest2());
        requests.add(getRequest3());
    }

    public List<String> getRequestList(){
        return requests;
    }
}

package Mockito3;

public class MyService {
    private ExternalApi api;
    public MyService(ExternalApi api) {
        this.api=api;
    }
    public String fetchData(String data) {
        return api.getData(data);
    }

}
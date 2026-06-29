package Mockito6;

public class MyService{
    private ExternalApi api;
    public MyService(ExternalApi api){
        this.api=api;
    }
    public void processData() {
        api.getData();
        api.saveData();
    }}
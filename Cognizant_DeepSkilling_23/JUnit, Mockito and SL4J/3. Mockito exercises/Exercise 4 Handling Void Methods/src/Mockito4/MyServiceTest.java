package Mockito4;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest{
    @Test
    public void testVoidMethod(){
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).sendData();
        MyService service = new MyService(mockApi);
        service.processData();
        verify(mockApi).sendData();
    }
}
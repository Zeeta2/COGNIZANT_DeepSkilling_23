package Mockito7;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {
    @Test
    public void testVoidMethodException() {
        ExternalApi mockApi=mock(ExternalApi.class);
        doThrow(new RuntimeException("Error"))
                .when(mockApi).sendData();
        MyService service=new MyService(mockApi);
        assertThrows(RuntimeException.class, () -> {
            service.processData();
        });
        verify(mockApi).sendData();
    }}
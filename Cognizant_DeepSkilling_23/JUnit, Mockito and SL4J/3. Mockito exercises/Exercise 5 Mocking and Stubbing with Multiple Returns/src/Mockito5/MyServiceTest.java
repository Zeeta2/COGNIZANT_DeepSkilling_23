package Mockito5;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest{
    @Test
    public void testMultipleReturns(){
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Data")
                .thenReturn("Second Data");
        MyService service = new MyService(mockApi);
        assertEquals("First Data", service.fetchData());
        assertEquals("Second Data", service.fetchData());
    }}
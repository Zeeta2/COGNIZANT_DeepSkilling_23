package Mockito1;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class MyServiceTest {
	@Test
	public void testExternalApi() {
		ExternalApi mockapi=Mockito.mock(ExternalApi.class);
		when(mockapi.getData()).thenReturn("Mock Data");
		MyService s=new MyService(mockapi);
		String res=s.fetchData();
		assertEquals("Mock Data",res);
		
	}
}

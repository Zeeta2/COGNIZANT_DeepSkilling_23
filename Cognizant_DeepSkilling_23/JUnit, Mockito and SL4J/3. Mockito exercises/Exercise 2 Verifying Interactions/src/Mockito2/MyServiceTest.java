package Mockito2;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
	public class MyServiceTest {
		@Test
		public void testVerifyInteraction() {
			ExternalApi mockapi=Mockito.mock(ExternalApi.class);
			MyService s=new MyService(mockapi);
			s.fetchData();
			verify(mockapi).getData();
		}
	}

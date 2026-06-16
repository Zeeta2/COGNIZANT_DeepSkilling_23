package JUnit;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator c;
		@Before
		public void setUp() {
			c=new Calculator();
		}
		@Test
		public void testAdd() {
			int a=2;
			int b=3;
			int res=c.add(a, b);
			assertEquals(5,res);
		}
		@After
		public void tearDown() {
			c=null;
		}
		}

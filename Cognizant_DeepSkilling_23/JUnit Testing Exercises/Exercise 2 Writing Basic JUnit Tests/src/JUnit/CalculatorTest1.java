package JUnit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CalculatorTest1 {
	@Test
	public void testAdd() {
		Calculator c=new Calculator();
		assertEquals(5,c.add(2, 3));
	}
	@Test
	public void testMul() {
		Calculator c=new Calculator();
		assertEquals(6,c.mul(2, 3));
	}
}

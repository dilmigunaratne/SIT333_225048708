package sit333;

import org.junit.Test;
import org.junit.Assert;


public class CalculatorTest {
	
	private Calculator cal = new Calculator();
	
	@Test
	public void testMultiplyCorrect() {
		Assert.assertEquals(cal.multiply(2, 3), 6);
	}
    
    @Test
    public void testMultiplyPositiveNumbers() {
        Assert.assertEquals(20, cal.multiply(4, 5), 20);
    }
    
    @Test
    public void testMultiplyNegativeNumbers() {
        Assert.assertEquals(20, cal.multiply(-4, -5), 20);
    }
    
    @Test
    public void testMultiplyPositiveAndNegativeNumbers() {
        Assert.assertEquals(-15, cal.multiply(-3, 5), -15);
    }
    
    @Test
    public void testMultiplyWithZero() {
        Assert.assertEquals(0, cal.multiply(0, 5), 0);
        Assert.assertEquals(0, cal.multiply(7, 0), 0);
    }

}

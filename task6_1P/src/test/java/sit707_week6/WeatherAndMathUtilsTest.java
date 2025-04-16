package sit707_week6;


import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s225048708";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Dilmi Punsara Gunaratne";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testFalseNumberIsEven() {
	    Assert.assertFalse(WeatherAndMathUtils.isEven(5));
	}

	
    @Test
    public void testCancelWeatherAdvice() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }
    
    @Test
    public void testCancelDueToDangerousWindOnly() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(80.0, 2.0));
    }

    @Test
    public void testCancelDueToDangerousRainOnly() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 7.0));
    }

    @Test
    public void testCancelDueToBothConcerning() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 5.0));
    }
    
    @Test
    public void testAllClear() {
    	Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10,2));
    }
    
    @Test
    public void testWarn_WindOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50, 1));
    }
    
    @Test
    public void testWarn_RainOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20, 5));
    }
    
    @Test
    public void testWeatherAdvice_EdgeValues() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 4.0));
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.0, 5.0));
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 5.0));
    }
    
    
    @Test
    public void testIsEven_PositiveEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(8));
    }

    @Test
    public void testIsEven_PositiveOdd() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(7));
    }
    
    @Test
    public void testIsEven_NegativeEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(-4));
    }

    @Test
    public void testIsEven_NegativeOdd() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(-3));
    }

    @Test
    public void testIsEven_Zero() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }
    
    @Test
    public void testIsPrime_2() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    @Test
    public void testIsPrime_3() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }

    @Test
    public void testIsPrime_17() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(17));
    }

    @Test
    public void testIsPrime_1() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testIsPrime_0() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(0));
    }

    @Test
    public void testIsPrime_Negative() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(-5));
    }

    @Test
    public void testIsPrime_CompositeEven() {
    	Assert.assertFalse(WeatherAndMathUtils.isPrime(20));
    }

    @Test
    public void testIsPrime_CompositeOdd() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(15));
    }
    
    @Test
    public void testWeatherAdvice_NegativeWind() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            WeatherAndMathUtils.weatherAdvice(-1, 2);
        });
    }

    @Test
    public void testWeatherAdvice_NegativeRain() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            WeatherAndMathUtils.weatherAdvice(2, -1);
        });
    }


    
}

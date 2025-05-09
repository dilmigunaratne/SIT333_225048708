// WeatherAndMathUtilsTest.java
package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "S225048708";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Dilmi Punsara Gunaratne";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testWeatherAdvice_Cancel() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(71, 0));
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0, 7));
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50, 5));
    }

    @Test
    public void testWeatherAdvice_Warn() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46, 0));
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0, 5));
    }

    @Test
    public void testWeatherAdvice_AllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(30, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeatherAdvice_NegativeValues() {
        WeatherAndMathUtils.weatherAdvice(-1, 2);
    }

    @Test
    public void testIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
        Assert.assertFalse(WeatherAndMathUtils.isEven(5));
    }

    @Test
    public void testIsPrime() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
        Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0));
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-5));
    }
}

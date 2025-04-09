package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s225048708";
		System.out.println(studentId);
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Dilmi Punsara Gunaratne";
		System.out.println(studentName);
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}
	
	//1B
	@Test
	public void testIncrement1B() {
		DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("1B - June 1 should increment to June 2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}
	
	//2B
	@Test
	public void testIncrement2B() {
		DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("2B - June 2 should increment to June 3 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}
	
	//3B
	@Test
	public void testIncrement3B() {
		DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("3B - June 15 should increment to June 16 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
	}
	
	//4B
	@Test
	public void testIncrement4B() {
		DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("4B - June 30 should increment to July 1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
	}
	
	//5B
	@Test
	public void testIncrement5B() {
	    try {
	        DateUtil date = new DateUtil(31, 6, 1994); // Invalid date (June has 30 days)
	        System.out.println("june31ShouldReturnInvalidDate > " + date);
	        Assert.fail("Expected Invalid Date exception");
	    } catch (RuntimeException e) {
	        System.out.println("Exception: " + e.getMessage()); // Expected exception
	        Assert.assertTrue(e.getMessage().contains("Invalid day: 31"));
	    }
	}
	
	//6B
	@Test
	public void testIncrement6B() {
		DateUtil date = new DateUtil(15, 1, 1994);
		System.out.println("5B - January 15 should increment to January 16 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	//7B
	@Test
	public void testIncrement7B() {
		DateUtil date = new DateUtil(15, 2, 1994);
		System.out.println("7B - Feb 15 should increment to Feb 16 1 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	//8B
	@Test
	public void testIncrement8B() {
		DateUtil date = new DateUtil(15, 11, 1994);
		System.out.println("8B - Nov 15 should increment to Nov 16 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	//9B
	@Test
	public void testIncrement9B() {
		DateUtil date = new DateUtil(15, 12, 1994);
		System.out.println("9B - Dec 15 should increment to Dec 16 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
	}
	
	//10B
	@Test
	public void testIncrement10B() {
		DateUtil date = new DateUtil(15, 6, 1700);
		System.out.println("10B - June 15 should increment to June 16 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1700, date.getYear());
	}
	
	//11B
	@Test
	public void testIncrement11B() {
		DateUtil date = new DateUtil(15, 6, 1701);
		System.out.println("11B - June 15 should increment to June 16 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1701, date.getYear());
	}
	
	//12B
	@Test
	public void testIncrement12B() {
		DateUtil date = new DateUtil(15, 6, 2023);
		System.out.println("12B - June 15 should increment to June 16 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	
	//13B
	@Test
	public void testIncrement13B() {
		DateUtil date = new DateUtil(15, 6, 2024);
		System.out.println("13B - June 15 should increment to June 16 > " + date);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
}

package sit707_tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s225048708";
		System.out.println(studentId);
		assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Dilmi Punsara Gunaratne";
		System.out.println(studentName);
		assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testValidDateTypical() {
	    DateUtil date = new DateUtil(15, 6, 2020);  // Mid of June
	    assertEquals("15/06/2020", date.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDayTooLow() {
	    new DateUtil(0, 3, 2020);  // Invalid day < 1
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDayTooHigh() {
	    new DateUtil(32, 1, 2020);  // Invalid day > 31
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDayInFebNonLeapYear() {
	    new DateUtil(29, 2, 2023);  // Feb 29 in non-leap year
	}

	@Test
	public void testValidLeapYearFeb29() {
	    DateUtil date = new DateUtil(29, 2, 2020);
	    assertEquals("29/02/2020", date.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMonthTooLow() {
	    new DateUtil(10, 0, 2020);  // Invalid month < 1
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMonthTooHigh() {
	    new DateUtil(10, 13, 2020);  // Invalid month > 12
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidYearTooLow() {
	    new DateUtil(10, 5, 1699);  // Year < 1700
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidYearTooHigh() {
	    new DateUtil(10, 5, 2025);  // Year > 2024
	}
	
	@Test
	public void testIncrementFromEndOfMonth() {
	    DateUtil date = new DateUtil(31, 1, 2020); // Jan has 31 days
	    date.increment();
	    assertEquals("01/02/2020", date.toString());
	}

	@Test
	public void testIncrementFromEndOfYear() {
	    DateUtil date = new DateUtil(31, 12, 2023);
	    date.increment();
	    assertEquals("01/01/2024", date.toString());
	}

	@Test
	public void testDecrementFromStartOfMonth() {
	    DateUtil date = new DateUtil(1, 3, 2020); // Leap year
	    date.decrement();
	    assertEquals("29/02/2020", date.toString());
	}

	@Test
	public void testDecrementFromStartOfYear() {
	    DateUtil date = new DateUtil(1, 1, 2020);
	    date.decrement();
	    assertEquals("31/12/2019", date.toString());
	}


}

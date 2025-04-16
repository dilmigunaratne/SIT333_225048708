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
        assertNotNull("Student ID is null", studentId);
        System.out.println("TestStudentIdentity passed - " + studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Dilmi Punsara Gunaratne";
        assertNotNull("Student name is null", studentName);
        System.out.println("TestStudentName passed - " + studentName);
    }

    @Test
    public void testValidDateTypical() {
        DateUtil date = new DateUtil(15, 6, 2020);
        assertEquals("15/06/2020", date.toString());
        System.out.println("TestValidDateTypical passed");
    }

    @Test
    public void testValidLeapYearFeb29() {
        DateUtil date = new DateUtil(29, 2, 2020);
        assertEquals("29/02/2020", date.toString());
        System.out.println("TestValidLeapYearFeb29 passed");
    }

    @Test
    public void testValidDay30For30DayMonth() {
        DateUtil date = new DateUtil(30, 4, 2020);
        assertEquals("30/04/2020", date.toString());
        System.out.println("TestValidDay30For30DayMonth passed");
    }

    @Test
    public void testValidDay31For31DayMonth() {
        DateUtil date = new DateUtil(31, 1, 2020);
        assertEquals("31/01/2020", date.toString());
        System.out.println("TestValidDay31For31DayMonth passed");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayTooLow() {
        new DateUtil(0, 3, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayTooHigh() {
        new DateUtil(32, 1, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDay31In30DayMonth() {
        new DateUtil(31, 4, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayInFebNonLeapYear() {
        new DateUtil(29, 2, 2023);
    }

    @Test
    public void testValid31DayMonth() {
        DateUtil date = new DateUtil(31, 7, 2020);
        assertEquals("31/07/2020", date.toString());
        System.out.println("TestValid31DayMonth passed");
    }

    @Test
    public void testValid30DayMonth() {
        DateUtil date = new DateUtil(30, 6, 2020);
        assertEquals("30/06/2020", date.toString());
        System.out.println("TestValid30DayMonth passed");
    }

    @Test
    public void testValidFebruaryNonLeap() {
        DateUtil date = new DateUtil(28, 2, 2023);
        assertEquals("28/02/2023", date.toString());
        System.out.println("TestValidFebruaryNonLeap passed");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonthTooLow() {
        new DateUtil(10, 0, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonthTooHigh() {
        new DateUtil(10, 13, 2020);
    }

    @Test
    public void testLeapYearValid() {
        DateUtil date = new DateUtil(29, 2, 2000);
        assertEquals("29/02/2000", date.toString());
        System.out.println("TestLeapYearValid passed");
    }

    @Test
    public void testNonLeapYearValid() {
        DateUtil date = new DateUtil(28, 2, 2001);
        assertEquals("28/02/2001", date.toString());
        System.out.println("TestNonLeapYearValid passed");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYearTooLow() {
        new DateUtil(10, 5, 1699);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYearTooHigh() {
        new DateUtil(10, 5, 2025);
    }

    @Test
    public void testIncrementFromEndOfMonth() {
        DateUtil date = new DateUtil(31, 1, 2020);
        date.increment();
        assertEquals("01/02/2020", date.toString());
        System.out.println("TestIncrementFromEndOfMonth passed");
    }

    @Test
    public void testIncrementFromEndOfYear() {
        DateUtil date = new DateUtil(31, 12, 2023);
        date.increment();
        assertEquals("01/01/2024", date.toString());
        System.out.println("TestIncrementFromEndOfYear passed");
    }

    @Test
    public void testDecrementFromStartOfMonth() {
        DateUtil date = new DateUtil(1, 3, 2020);
        date.decrement();
        assertEquals("29/02/2020", date.toString());
        System.out.println("TestDecrementFromStartOfMonth passed");
    }

    @Test
    public void testDecrementFromStartOfYear() {
        DateUtil date = new DateUtil(1, 1, 2020);
        date.decrement();
        assertEquals("31/12/2019", date.toString());
        System.out.println("TestDecrementFromStartOfYear passed");
    }
}

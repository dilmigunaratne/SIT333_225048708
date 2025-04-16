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

    // --- Valid Day Tests (D1, D2, D3, D4) ---

    @Test
    public void testValidDateTypical() { // D1 - 1 to 28
        DateUtil date = new DateUtil(15, 6, 2020);
        assertEquals("15/06/2020", date.toString());
    }

    @Test
    public void testValidLeapYearFeb29() { // D2
        DateUtil date = new DateUtil(29, 2, 2020);
        assertEquals("29/02/2020", date.toString());
    }

    @Test
    public void testValidDay30For30DayMonth() { // D3
        DateUtil date = new DateUtil(30, 4, 2020); // April has 30 days
        assertEquals("30/04/2020", date.toString());
    }

    @Test
    public void testValidDay31For31DayMonth() { // D4
        DateUtil date = new DateUtil(31, 1, 2020); // January has 31 days
        assertEquals("31/01/2020", date.toString());
    }

    // --- Invalid Day Tests ---

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
        new DateUtil(31, 4, 2020); // April has 30 days
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayInFebNonLeapYear() {
        new DateUtil(29, 2, 2023);
    }

    // --- Month Tests (M1, M2, M3) ---

    @Test
    public void testValid31DayMonth() { // M1
        DateUtil date = new DateUtil(31, 7, 2020); // July has 31 days
        assertEquals("31/07/2020", date.toString());
    }

    @Test
    public void testValid30DayMonth() { // M2
        DateUtil date = new DateUtil(30, 6, 2020); // June has 30 days
        assertEquals("30/06/2020", date.toString());
    }

    @Test
    public void testValidFebruaryNonLeap() { // M3 + Y2
        DateUtil date = new DateUtil(28, 2, 2023);
        assertEquals("28/02/2023", date.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonthTooLow() {
        new DateUtil(10, 0, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonthTooHigh() {
        new DateUtil(10, 13, 2020);
    }

    // --- Year Tests (Y1, Y2) ---

    @Test
    public void testLeapYearValid() { // Y1
        DateUtil date = new DateUtil(29, 2, 2000);
        assertEquals("29/02/2000", date.toString());
    }

    @Test
    public void testNonLeapYearValid() { // Y2
        DateUtil date = new DateUtil(28, 2, 2001);
        assertEquals("28/02/2001", date.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYearTooLow() {
        new DateUtil(10, 5, 1699);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYearTooHigh() {
        new DateUtil(10, 5, 2025);
    }

    // --- Increment & Decrement Tests ---

    @Test
    public void testIncrementFromEndOfMonth() {
        DateUtil date = new DateUtil(31, 1, 2020);
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
        DateUtil date = new DateUtil(1, 3, 2020);
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

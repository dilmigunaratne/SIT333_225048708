package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // ✅ Q1: Addition Tests
    @Test
    public void testTrueAdd() {
        Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
    }

    @Test
    public void testAddNumber1Empty() {
        try {
            MathQuestionService.q1Addition("", "2");
            Assert.fail("Expected an IllegalArgumentException for empty number1.");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid numbers provided for addition."));
        }
    }

    @Test
    public void testAddNonNumeric() {
        try {
            MathQuestionService.q1Addition("abc", "2");
            Assert.fail("Expected an IllegalArgumentException for non-numeric input.");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid numbers provided for addition."));
        }
    }

    // ✅ Q2: Subtraction Tests
    @Test
    public void testTrueSubtraction() {
        Assert.assertEquals(MathQuestionService.q2Subtraction("5", "3"), 2, 0);
    }

    @Test
    public void testSubtractionNumber1Empty() {
        try {
            MathQuestionService.q2Subtraction("", "3");
            Assert.fail("Expected an IllegalArgumentException for empty number1.");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid numbers provided for subtraction."));
        }
    }

    @Test
    public void testSubtractionNonNumeric() {
        try {
            MathQuestionService.q2Subtraction("abc", "3");
            Assert.fail("Expected an IllegalArgumentException for non-numeric input.");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid numbers provided for subtraction."));
        }
    }

    // ✅ Q3: Multiplication Tests
    @Test
    public void testTrueMultiplication() {
        Assert.assertEquals(MathQuestionService.q3Multiplication("4", "5"), 20, 0);
    }

    @Test
    public void testMultiplicationNumber1Empty() {
        try {
            MathQuestionService.q3Multiplication("", "5");
            Assert.fail("Expected an IllegalArgumentException for empty number1.");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid numbers provided for multiplication."));
        }
    }

    @Test
    public void testMultiplicationNonNumeric() {
        try {
            MathQuestionService.q3Multiplication("abc", "5");
            Assert.fail("Expected an IllegalArgumentException for non-numeric input.");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid numbers provided for multiplication."));
        }
    }
}

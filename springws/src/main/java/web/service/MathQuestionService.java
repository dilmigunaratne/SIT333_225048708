package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result (Addition).
     * @param number1
     * @param number2
     * @return
     */
    public static double q1Addition(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 + num2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers provided for addition.");
        }
    }

    /**
     * Calculate Q2 result (Subtraction).
     * @param number1
     * @param number2
     * @return
     */
    public static double q2Subtraction(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 - num2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers provided for subtraction.");
        }
    }

    /**
     * Calculate Q3 result (Multiplication).
     * @param num1
     * @param num2
     * @return
     */
    public static double q3Multiplication(String num1, String num2) {
        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            return number1 * number2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers provided for multiplication.");
        }
    }
}

package sit707_week5;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController controller;
    private static List<Double> hourlyTemperatures;

    @BeforeClass
    public static void setUpBeforeClass() {
        controller = WeatherController.getInstance();
        hourlyTemperatures = new ArrayList<>();

        int totalHours = controller.getTotalHours();
        for (int hour = 1; hour <= totalHours; hour++) {
            double temp = controller.getTemperatureForHour(hour);
            hourlyTemperatures.add(temp);
        }
    }

    @AfterClass
    public static void tearDownAfterClass() {
        if (controller != null) {
            controller.close();
        }
    }

    @Test
    public void testStudentIdentity() {
        // Arrange
        String studentId = "S225048708";

        // Act & Assert
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        // Arrange
        String studentName = "Dilmi Punsara Gunaratne";

        // Act & Assert
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        // Arrange
        double expectedMin = hourlyTemperatures.stream()
                .min(Double::compare)
                .orElse(Double.NaN);

        // Act
        double actualMin = controller.getTemperatureMinFromCache();

        // Assert
        assertEquals("Minimum temperature mismatch", expectedMin, actualMin, 0.001);
    }

    @Test
    public void testTemperatureMax() {
        // Arrange
        double expectedMax = hourlyTemperatures.stream()
                .max(Double::compare)
                .orElse(Double.NaN);

        // Act
        double actualMax = controller.getTemperatureMaxFromCache();

        // Assert
        assertEquals("Maximum temperature mismatch", expectedMax, actualMax, 0.001);
    }

    @Test
    public void testTemperatureAverage() {
        // Arrange
        double sum = hourlyTemperatures.stream().mapToDouble(Double::doubleValue).sum();
        double expectedAvg = sum / hourlyTemperatures.size();

        // Act
        double actualAvg = controller.getTemperatureAverageFromCache();

        // Assert
        assertEquals("Average temperature mismatch", expectedAvg, actualAvg, 0.001);
    }

    @Test
    public void testTemperaturePersist() {
        // For 5.3C: Uncomment and use only if persist logic is implemented

        /*
        // Arrange
        WeatherController wController = WeatherController.getInstance();

        // Act
        String persistTime = wController.persistTemperature(10, 19.5);
        String now = new SimpleDateFormat("H:m:s").format(new Date());

        // Assert
        Assert.assertTrue(persistTime.equals(now));

        wController.close();
        */
    }
}

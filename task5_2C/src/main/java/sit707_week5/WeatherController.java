package sit707_week5;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class WeatherController {
    
    public static final int HOURS_PER_DAY = 3;

    private static WeatherController instance;
    private Clock clock;

    // Constructor with Clock param
    private WeatherController(Clock clock) {
        this.clock = (clock == null) ? Clock.systemDefaultZone() : clock;
        System.out.println("Creating new weather controller with Clock.");
        initTemperatures();
    }

    // Default no-arg constructor
    private WeatherController() {
        this.clock = Clock.systemDefaultZone();
        System.out.println("Creating new weather controller with default clock.");
        initTemperatures();
    }

    private void initTemperatures() {
        Random random = new Random();
        for (int i = 0; i < HOURS_PER_DAY; i++) {
            todaysHourlyTemperature[i] = 1 + random.nextInt(30);
        }
        System.out.println(Arrays.toString(todaysHourlyTemperature));
    }

    /**
     * Factory method for single instance WeatherController.
     * @param fixedClock 
     * @return
     */
    public static WeatherController getInstance(Clock fixedClock) {
        if (instance == null) {
            instance = (fixedClock == null) ? new WeatherController() : new WeatherController(fixedClock);
        }
        return instance;
    }

    // Initialise 10 hourly temperature
    private static double[] todaysHourlyTemperature = new double[HOURS_PER_DAY];

    // rest of your methods unchanged...

    public void close() {
        System.out.println("Closing weather controller.");
        instance = null;
        // sleep a while to simulate a delay
        sleep(2 + new Random().nextInt(5));
    }

    public double getTemperatureMinFromCache() {
        double minVal = 1000;
        for (int i = 0; i < todaysHourlyTemperature.length; i++) {
            if (minVal > todaysHourlyTemperature[i]) {
                minVal = todaysHourlyTemperature[i];
            }
        }
        return minVal;
    }

    public double getTemperatureMaxFromCache() {
        double maxVal = -1;
        for (int i = 0; i < todaysHourlyTemperature.length; i++) {
            if (maxVal < todaysHourlyTemperature[i]) {
                maxVal = todaysHourlyTemperature[i];
            }
        }
        return maxVal;
    }

    public double getTemperatureAverageFromCache() {
        double sumVal = 0;
        for (int i = 0; i < todaysHourlyTemperature.length; i++) {
            sumVal += todaysHourlyTemperature[i];
        }
        return sumVal / todaysHourlyTemperature.length;
    }

    public double getTemperatureForHour(int hour) {
        sleep(1 + new Random().nextInt(5));
        if (hour > todaysHourlyTemperature.length) {
            hour = 1 + new Random().nextInt(todaysHourlyTemperature.length);
        }
        return todaysHourlyTemperature[hour - 1];
    }

    public String persistTemperature(int hour, double temperature) {
        LocalTime now = LocalTime.now(clock);
        String savedTime = now.format(DateTimeFormatter.ofPattern("H:m:s"));
        System.out.println("Temperature: " + temperature + " of hour: " + hour + ", saved at " + savedTime);
        return savedTime;
    }

    public int getTotalHours() {
        return todaysHourlyTemperature.length;
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

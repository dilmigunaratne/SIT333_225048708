package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mimosa_registration_load(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/dilmigunaratne/Downloads/chromedriver-mac-arm64/chromedriver");

        // Step 2: Use the chrome driver to open a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);
        sleep(2);

        // Load the webpage in the chromium browser.
        driver.get(url);

        // Step 3: Find and fill in the input fields with personal information.
        WebElement firstNameElement = driver.findElement(By.id("first_name"));
        firstNameElement.sendKeys("Dilmi");

        WebElement lastNameElement = driver.findElement(By.id("last_name"));
        lastNameElement.sendKeys("Gunaratne");

        WebElement phoneNumberElement = driver.findElement(By.id("email"));
        phoneNumberElement.sendKeys("punsara.gunaratne@gmail.com");


        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("dilmi123");


        // Step 4: Locate and click the "Create Account" button to submit the form.
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@type='submit']"));
        createAccountButton.click();

        // Step 5: Capture the screenshot of the browser window.
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Step 6: Save the screenshot in the desired location.
        try {
            FileHandler.copy(screenshotFile, new File("registration_form_submission.png"));
            System.out.println("Screenshot saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 7: Sleep for a few seconds to allow the submission action to take place.
        sleep(5);

        // Step 8: Close the browser
        driver.close();
    }
}

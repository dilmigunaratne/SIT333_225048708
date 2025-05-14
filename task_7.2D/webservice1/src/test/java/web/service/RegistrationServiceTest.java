package web.service;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/dilmigunaratne/Downloads/chromedriver-mac-arm64-2/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("file:/Users/dilmigunaratne/eclipse-workspace/7.1P/pages/register.html");
        sleep(2);
    }
    
    @Before
    public void clearUserCache() {
        RegistrationService.clearUsers(); // Ensure you have this method in RegistrationService
    }


    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    private void sleep(long sec) {
        try { Thread.sleep(sec * 1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    private void register(String fName, String lName, String email, String dob) {
        driver.findElement(By.id("fname")).sendKeys(fName);  // Fist name field
        driver.findElement(By.id("lname")).sendKeys(lName);  // Last name field
        driver.findElement(By.id("email")).sendKeys(email);  // Email field
        ((JavascriptExecutor) driver).executeScript("document.getElementsByName('dob')[0].value = arguments[0];", dob);  // Date of birth field
        driver.findElement(By.cssSelector("[type=submit]")).click();  // Submit button
        sleep(2);  // Wait for a bit to ensure the page processes the request
    }

    @Test
    public void testSuccessfulRegistration() {
        // Using the provided values: fname="dilmi", lname="punsara", email="dilmi123@gmail.com", dob="2000-01-01"
        register("dilmi", "punsara", "dilmi123@gmail.com", "2000-01-01");
        // Assert the expected result after the registration attempt (e.g., success message)
        Assert.assertEquals("success", driver.getTitle());  // Update based on your response logic
    }

    @Test
    public void testDuplicateRegistration() {
        // Register with the same details twice to simulate duplicate registration
        register("dilmi", "punsara", "dilmi123@gmail.com", "2000-01-01");
        //register("dilmi", "punsara", "dilmi123@gmail.com", "2000-01-01"); // Trying duplicate registration
        // Assert failure or message indicating duplicate email
        Assert.assertEquals("fail", driver.getTitle());  // Update based on your response logic
    }

    @Test
    public void testInvalidDOB() {
        // Attempt registration with an invalid DOB
        register("dilmi", "punsara", "dilmi123@gmail.com", "2050-01-01");
        // Assert failure due to invalid DOB
        Assert.assertEquals("fail", driver.getTitle());  // Update based on your response logic
    }

    @Test
    public void testEmptyFields() {
        // Attempt registration with empty fields
        register("", "", "", "");
        // Assert failure when fields are empty
        Assert.assertEquals("fail", driver.getTitle());  // Update based on your response logic
    }
}

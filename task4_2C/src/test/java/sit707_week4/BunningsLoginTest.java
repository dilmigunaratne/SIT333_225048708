package sit707_week4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BunningsLoginTest {

    private WebDriver driver;

    @Before
    public void setup() {
        // Update this path to your local chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/dilmigunaratne/Downloads/chromedriver-mac-arm64-2/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bunnings.com.au/login");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void performLogin(String email, String password) {
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        emailField.clear();
        passwordField.clear();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    // Check login URL
    private boolean isLoginSuccessful() {
        return !driver.getCurrentUrl().contains("/login");
    }

    // Case 1: Valid Email, Valid Password
    @Test
    public void testValidValid() {
        performLogin("dilmipunsara2@gmail.com", "Dilmi@123");
        Assert.assertTrue("Login should be successful", isLoginSuccessful());
    }

    // Case 2: Valid Email, Invalid Password
    @Test
    public void testValidInvalid() {
        performLogin("dilmipunsara2@gmail.com", "wrongPassword");
        Assert.assertFalse("Login should fail", isLoginSuccessful());
    }

    // Case 3: Invalid Email, Valid Password
    @Test
    public void testInvalidValid() {
        performLogin("wrongEmail", "Dilmi@123");
        Assert.assertFalse("Login should fail", isLoginSuccessful());
    }
    
    //Case 4: Invaid Email, Invalid password
    @Test
    public void testInvalidInvalid() {
        performLogin("wrongEmail", "wrongPassword");
        Assert.assertFalse("Login should fail", isLoginSuccessful());
    }
    
    //Case 5: Empty Email, Valid passowrd
    @Test
    public void testEmptyEmail() {
        performLogin("", "Dilmi@123");
        Assert.assertFalse("Login should fail", isLoginSuccessful());
    }

    //Case 6: Valid Email, Empty password
    @Test
    public void testEmptyPassword() {
        performLogin("dilmipunsara2@gmail.com", "");
        Assert.assertFalse("Login should fail", isLoginSuccessful());
    }

    @Test
    public void testStudentInfo() {
        System.out.println("Student Name: Dilmi Gunaratne");
        System.out.println("Student ID: S225048708");
        Assert.assertTrue(true);
    }
}

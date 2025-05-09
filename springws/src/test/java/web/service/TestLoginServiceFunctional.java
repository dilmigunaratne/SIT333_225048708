package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class TestLoginServiceFunctional {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/Users/dilmigunaratne/Downloads/chromedriver-mac-arm64-2/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login");
    }

    @Test
    public void testLoginSuccess() {
        login("dilmi", "dilmi123", "2002-01-01");
        assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testLoginFailureInvalidCredentials() {
        login("dilmi", "wrongPass", "2002-01-01");
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertNotNull(errorMessage);
        assertTrue(errorMessage.getText().contains("Incorrect credentials."));
    }

    @Test
    public void testLoginFailureInvalidDOB() {
        login("dilmi", "dilmi123", "1990-01-01");
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertNotNull(errorMessage);
        assertTrue(errorMessage.getText().contains("Incorrect credentials."));
    }

    private void login(String username, String password, String dob) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("passwd")).sendKeys(password);
        
        // Use JavaScript to set the date input value correctly
        WebElement dobElement = driver.findElement(By.name("dob"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", dobElement, dob);
        
        driver.findElement(By.id("submit")).click();
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

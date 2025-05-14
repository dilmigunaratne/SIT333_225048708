package web.service;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty(
            "webdriver.chrome.driver",
            "/Users/dilmigunaratne/Downloads/chromedriver-mac-arm64-2/chromedriver"
        );
        driver = new ChromeDriver();
        driver.navigate().to("file:/Users/dilmigunaratne/eclipse-workspace/7.1P/pages/login.html");
        sleep(2);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void login(String username, String password, String dob) {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys(username);

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys(password);

        ((JavascriptExecutor) driver).executeScript("document.getElementById('dob').value = arguments[0];", dob);

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.click();
        sleep(2);
    }

    // ----------- Comprehensive Functional Test Cases ------------

    @Test
    public void testLoginSuccess() {
        login("dilmi", "dilmi123", "2002-08-26");
        Assert.assertEquals("success", driver.getTitle());
    }

    @Test
    public void testInvalidUsername() {
        login("wrongUser", "dilmi123", "2002-08-26");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testNullFields() {
        login("", "", "");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testInvalidCharactersInUsername() {
        login("@dilmi#", "dilmi123", "2002-08-26");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testInvalidPasswordLength() {
        login("dilmi", "short", "2002-08-26");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testFutureDOB() {
        login("dilmi", "dilmi123", "2050-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testEmptyFields() {
        login("", "", "");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testWhitespaceOnlyFields() {
        login("  ", "  ", "  ");
        Assert.assertEquals("fail", driver.getTitle());
    }
}

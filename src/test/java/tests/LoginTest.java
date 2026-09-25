package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RegisterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;
public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    protected static final String BASE_URL  = "https://stellarburgers.education-services.ru/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void isLoginViaLoginToAccountButtonSuccessful(){
        loginPage.loginViaLoginToAccountButton("stella.burger@yandex.ru", "stella123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.orderButton));
        loginPage.isOrderButtonDisplayed();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void isLoginViaPersonalAccountButtonSuccessful(){
        loginPage.loginViaPersonalAccountButton("stella.burger@yandex.ru", "stella123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.orderButton));
        loginPage.isOrderButtonDisplayed();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }
    @Test
    public void loginViaRegistrationForm(){
        loginPage.loginViaRegistrationForm("stella.burger@yandex.ru", "stella123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.orderButton));
        loginPage.isOrderButtonDisplayed();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void isLoginViaForgotPasswordFormSuccessful(){
    loginPage.loginViaForgotPasswordForm("stella.burger@yandex.ru", "stella123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.orderButton));
        loginPage.isOrderButtonDisplayed();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }
}

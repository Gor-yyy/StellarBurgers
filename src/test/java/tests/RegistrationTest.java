package tests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;
import static org.junit.Assert.assertTrue;
import org.junit.After;

import java.time.Duration;
import java.util.UUID;

public class RegistrationTest{
    String email = UUID.randomUUID() + "@yandex.ru";
    WebDriver driver;
    RegisterPage registerPage;
    protected static final String BASE_URL  = "https://stellarburgers.education-services.ru/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        registerPage = new RegisterPage(driver);
    }
    @Test
    public void isRegistrationSuccessful(){
        registerPage.registerSuccessfully("Dav", email
                , "password1234");
        registerPage.waitTab();
        assertTrue(registerPage.isLoginButtonDisplayed());

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void isInvalidPasswordErrorDisplayed(){
        registerPage.registerSuccessfully("Dav", "dav.15855@yandex.ru", "123");
        registerPage.getInvalidPasswordErrorText();
    }
}

package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private final String browser;

    protected static final String BASE_URL =
            "https://stellarburgers.education-services.ru/";

    public LoginTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Object[][] browsers() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    @Before
    public void setUp() {
        driver = BrowserFactory.createDriver(browser);
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void isLoginViaLoginToAccountButtonSuccessful() {
        loginPage.loginViaLoginToAccountButton(
                "stella.burger@yandex.ru",
                "stella123"
        );
        loginPage.waitTab();

        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void isLoginViaPersonalAccountButtonSuccessful() {
        loginPage.loginViaPersonalAccountButton(
                "stella.burger@yandex.ru",
                "stella123"
        );
        loginPage.waitTab();

        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void loginViaRegistrationForm() {
        loginPage.loginViaRegistrationForm(
                "stella.burger@yandex.ru",
                "stella123"
        );
        loginPage.waitTab();

        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void isLoginViaForgotPasswordFormSuccessful() {
        loginPage.loginViaForgotPasswordForm(
                "stella.burger@yandex.ru",
                "stella123"
        );
        loginPage.waitTab();

        assertTrue(loginPage.isOrderButtonDisplayed());
    }
}
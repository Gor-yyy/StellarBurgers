package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.CreateUser;
import pages.LoginPage;

import java.util.UUID;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LoginTest {

    String token;
    private CreateUser createUser;
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

        String email = UUID.randomUUID() + "@yandex.ru";
        createUser = new CreateUser(email, "password", "name");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(createUser)
                .when()
                .post("https://stellarburgers.education-services.ru/api/auth/register");

        token = response.path("accessToken");


        driver = BrowserFactory.createDriver(browser);
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {


        if (token != null) {
            given()
                    .header("Authorization", token)
                    .when()
                    .delete("https://stellarburgers.education-services.ru/api/auth/user");
        }


        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void isLoginViaLoginToAccountButtonSuccessful() {
        loginPage.loginViaLoginToAccountButton(
                createUser.getEmail(),
                createUser.getPassword()
        );

        loginPage.waitTab();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void isLoginViaPersonalAccountButtonSuccessful() {
        loginPage.loginViaPersonalAccountButton(
                createUser.getEmail(),
                createUser.getPassword()
        );

        loginPage.waitTab();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void loginViaRegistrationForm() {
        loginPage.loginViaRegistrationForm(
                createUser.getEmail(),
                createUser.getPassword()
        );

        loginPage.waitTab();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }

    @Test
    public void isLoginViaForgotPasswordFormSuccessful() {
        loginPage.loginViaForgotPasswordForm(
                createUser.getEmail(),
                createUser.getPassword()
        );

        loginPage.waitTab();
        assertTrue(loginPage.isOrderButtonDisplayed());
    }
}
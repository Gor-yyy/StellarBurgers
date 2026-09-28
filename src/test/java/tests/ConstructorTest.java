package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CreateUser;
import pages.NavigateToConstructorSection;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    String token;
    CreateUser createUser;
    WebDriver driver;
    NavigateToConstructorSection navigateToConstructorSection;

    protected static final String BASE_URL =
            "https://stellarburgers.education-services.ru/";

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


        String browser = System.getProperty("browser", "chrome");

        driver = BrowserFactory.createDriver(browser);
        driver.get(BASE_URL);

        navigateToConstructorSection =
                new NavigateToConstructorSection(driver);
    }

    @After
    public void tearDown() {


        if (token != null) {
            given()
                    .header("Authorization", token)
                    .when()
                    .delete("https://stellarburgers.education-services.ru/api/auth/user");
        }

        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void isBunsSectionNavigationSuccessful() {
        assertTrue(
                navigateToConstructorSection.isBunsSectionDisplayed()
        );
    }

    @Test
    public void isSaucesSectionNavigationSuccessful() {
        assertTrue(
                navigateToConstructorSection.isSaucesSectionDisplayed()
        );
    }

    @Test
    public void isFillingsSectionNavigationSuccessful() {
        assertTrue(
                navigateToConstructorSection.isFillingsSectionDisplayed()
        );
    }
}
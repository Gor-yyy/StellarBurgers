package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NavigateToConstructorSection;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    WebDriver driver;
    NavigateToConstructorSection navigateToConstructorSection;
    protected static final String BASE_URL  = "https://stellarburgers.education-services.ru/";

    @Before
    public void setUp() {
        driver = BrowserFactory.createDriver("chrome");
        driver.get(BASE_URL);

        navigateToConstructorSection = new NavigateToConstructorSection(driver);
        navigateToConstructorSection.login(
                "stella.burger@yandex.ru",
                "stella123"
        );
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void isBunsSectionNavigationSuccessful(){
        assertTrue(navigateToConstructorSection.isBunsSectionDisplayed());
    }
@Test
    public void isSaucesSectionNavigationSuccessful(){
    assertTrue(navigateToConstructorSection.isSaucesSectionDisplayed());
}

@Test
    public void isFillingsSectionNavigationSuccessful(){
    assertTrue(navigateToConstructorSection.isFillingsSectionDisplayed());
}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigateToConstructorSection {
    WebDriver driver;
    public NavigateToConstructorSection(WebDriver driver){
        this.driver = driver;
    }

    private By loginToAccountButton = By.xpath(".//button[text() ='Войти в аккаунт']");
    private By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    public By loginButton = By.xpath(".//button[text() = 'Войти']");
    private By bunsSection = By.xpath(".//span[text()='Булки']/parent::div");
    private By bunsSection2 = By.xpath(".//h2[text() = 'Булки']");
    private By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");
    private By saucesTab2 = By.xpath(".//h2[text() = 'Соусы']");
    private By fillingsTab = By.xpath(".//span[text() = 'Начинки']");
    private By fillingsTab2 = By.xpath(".//h2[text() = 'Начинки']");

    public void login(String email, String password){
        driver.findElement(loginToAccountButton).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isBunsSectionDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(bunsSection));
        wait.until(ExpectedConditions.elementToBeClickable(bunsSection2));
        return driver.findElement(bunsSection2).isDisplayed();
    }

    public boolean isSaucesSectionDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();
        return driver.findElement(saucesTab2).isDisplayed();
    }

    public boolean isFillingsSectionDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fillingsTab));
        driver.findElement(fillingsTab).click();
        return driver.findElement(fillingsTab2).isDisplayed();
    }

}

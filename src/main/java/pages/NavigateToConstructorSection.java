package pages;

import io.qameta.allure.Step;
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
    private By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");
    private By fillingsTab = By.xpath(".//span[text() = 'Начинки']/parent::div");


@Step("Вход")
    public void login(String email, String password){
        driver.findElement(loginToAccountButton).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Проверить, что раздел 'Булки' выбран")
    public boolean isBunsSectionDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(bunsSection));
        String className = driver.findElement(bunsSection).getAttribute("class");
        return className.contains("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }

    @Step("Проверить, что раздел 'Соусы' выбран")
    public boolean isSaucesSectionDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();
        String className = driver.findElement(saucesTab).getAttribute("class");
        return className.contains("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }

    @Step("Проверить, что раздел 'Начинки' выбран")
    public boolean isFillingsSectionDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fillingsTab));
        driver.findElement(fillingsTab).click();
        String className = driver.findElement(fillingsTab).getAttribute("class");
        return className.contains("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
    }

}

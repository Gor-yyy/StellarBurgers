package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
public WebDriver driver;

public LoginPage(WebDriver driver){
    this.driver = driver;
}
    private By loginToAccountButton = By.xpath(".//button[text() ='Войти в аккаунт']");
    private By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private By loginButton = By.xpath(".//button[text() = 'Войти']");
    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By registerButton = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private By loginFormButton= By.xpath(".//a[text() = 'Войти']");
    private By forgotPasswordButton = By.xpath(".//a[text() = 'Восстановить пароль']");
    public By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    @Step("Войти в аккаунт через кнопку 'Войти в аккаунт'")
    public void loginViaLoginToAccountButton(String email, String password){
    driver.findElement(loginToAccountButton).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}
@Step("Войти через кнопку 'Личный кабинет'")
public void loginViaPersonalAccountButton(String email, String password){
    driver.findElement(personalAccountButton).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}
    @Step("Войти через форму регистрации")
public void loginViaRegistrationForm(String email, String password){
    driver.findElement(loginToAccountButton).click();
    driver.findElement(registerButton).click();
    driver.findElement(loginFormButton).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}
    @Step("Войти через форму восстановления пароля")
public void loginViaForgotPasswordForm(String email, String password){
    driver.findElement(loginToAccountButton).click();
    driver.findElement(forgotPasswordButton).click();
    driver.findElement(loginFormButton).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}
    @Step("Проверить отображение кнопки 'Оформить заказ'")
public boolean isOrderButtonDisplayed(){
    return driver.findElement(orderButton).isDisplayed();
}
@Step("Ожидать кнопку Оформить заказ")
    public void waitTab(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
}

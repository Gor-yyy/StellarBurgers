package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private By loginButton2 = By.xpath(".//a[text() = 'Войти']");
    private By forgotPasswordButton = By.xpath(".//a[text() = 'Восстановить пароль']");
    public By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");

public void loginViaLoginToAccountButton(String email, String password){
    driver.findElement(loginToAccountButton).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}

public void loginViaPersonalAccountButton(String email, String password){
    driver.findElement(personalAccountButton).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}

public void loginViaRegistrationForm(String email, String password){
    driver.findElement(loginToAccountButton).click();
    driver.findElement(registerButton).click();
    driver.findElement(loginButton2).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}
public void loginViaForgotPasswordForm(String email, String password){
    driver.findElement(loginToAccountButton).click();
    driver.findElement(forgotPasswordButton).click();
    driver.findElement(loginButton2).click();
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
}

public boolean isOrderButtonDisplayed(){
    return driver.findElement(orderButton).isDisplayed();
}
}

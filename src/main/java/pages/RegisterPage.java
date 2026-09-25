package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class RegisterPage {
    public WebDriver driver;
public RegisterPage(WebDriver driver){
    this.driver = driver;
}
    private By loginToAccountButton = By.xpath(".//button[text() ='Войти в аккаунт']");
    private By registerButton = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private  By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private By registerButton2 = By.xpath(".//button[text() = 'Зарегистрироваться']");
    public By loginButton = By.xpath(".//button[text() = 'Войти']");
    private By ErrorText = By.xpath(".//p[text() = 'Некорректный пароль']");

    public void registerSuccessfully(String name, String email, String password){
        driver.findElement(loginToAccountButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton). click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registerButton2).click();
    }
    public boolean isLoginButtonDisplayed(){
        return driver.findElement(loginButton).isDisplayed();
    }

    public boolean getInvalidPasswordErrorText(){
return driver.findElement(ErrorText).isDisplayed();
    }
}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {

        if (browser.equals("yandex")) {
            ChromeOptions options = new ChromeOptions();

            String userHome = System.getProperty("user.home");

            options.setBinary(
                    userHome + "\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"
            );

            return new ChromeDriver(options);
        }

        return new ChromeDriver();
    }
}
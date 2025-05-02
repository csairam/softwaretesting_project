package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailInputLocator = By.id("login_field");
    private By passwordInputLocator = By.id("password");
    private By loginButtonLocator = By.name("commit");
    private By forgottenPasswordLinkLocator = By.linkText("Forgot password?");
    private By logoutLinkLocator = By.xpath("//summary[@aria-label='View profile and more']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public void clickForgottenPasswordLink() {
        driver.findElement(forgottenPasswordLinkLocator).click();
    }

    public boolean checkForgotPwdLink() {
        return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink() {
        try {
            WebElement profileIcon = wait.until(ExpectedConditions.presenceOfElementLocated(logoutLinkLocator));
            return profileIcon.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl() {
        return driver.getCurrentUrl();
    }
}

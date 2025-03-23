package login.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class LoginPage {
    private WebDriver driver;
    private String url = "https://automationexercise.com/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /// /// Locators //////
    private By EmailAddress = By.xpath("//input[@data-qa='login-email']");
    private By Password = By.xpath("//input[@data-qa='login-password']");
    private By LoginButton = By.xpath("//button[@data-qa='login-button']");
    private By LoginText = By.xpath("//h2[text()='Login to your account']");
    private By ErrorMessage = By.xpath("//p[@style='color: red;']");

    /// /// Action Methods /////
    @Step("Navigate to Login Page")
    public void navigateToLoginPage() {
        driver.get(url);
    }

    @Step("Entering the Email Address {email}")
    public LoginPage enterEmailAddress(String email) {
        //driver.findElement(EmailAddress).sendKeys(email);
        ElementActions.sendText(driver, EmailAddress, email);  //by utilities
        return this;
    }

    @Step("Entering the Password {password}")
    public LoginPage enterPassword(String password) {
        //driver.findElement(Password).sendKeys(password);
        ElementActions.sendText(driver, Password, password);   //by utilities
        return this;
    }

    @Step("Clicking on Login Button")
    public LoginPage clickOnLoginButton() {
        //driver.findElement(LoginButton).click();
        ElementActions.click(driver, LoginButton);//by utilities
        return this;
    }

    /// // Validations //////
    @Step("Verify 'Login to your account' is visible")
    public LoginPage validateLoginTextVisibility() {
        String ActualLoginText = driver.findElement(LoginText).getText();
        Assert.assertEquals(ActualLoginText, "Login to your account");
        return this;
    }

    @Step("Verify error 'Your email or password is incorrect!' is visible")
    public void validateErrorMessageVisibility() {
        String ActualErrorMessage = driver.findElement(ErrorMessage).getText();
        Assert.assertEquals(ActualErrorMessage, "Your email or password is incorrect!");
    }

}
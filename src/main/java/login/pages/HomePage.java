package login.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import skeleton.MainMenu;

public class HomePage {
    private WebDriver driver;
    private String url = "https://automationexercise.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /// // Locators //////

    /// // Action methods////
    @Step("Navigate to the Home Page")
    public HomePage navigateToHomePage() {
        driver.navigate().to(url);
        return this;
    }

    /// // Validations //////
    @Step("Verify that home page is visible successfully")
    public void validateThatWeAreInHomePage() {
        Assert.assertEquals(url, "https://automationexercise.com/");
    }


}

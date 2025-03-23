package skeleton;
import io.qameta.allure.Step;
import login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class MainMenu {
    private WebDriver driver;
    private String url = "https://automationexercise.com/";
    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }
    /// // Locators ///////
    private By SignUporLoginButton = By.partialLinkText("Signup");
    private By HomeButton = By.partialLinkText("Home");
    private By ProductsButton = By.partialLinkText("Products");
    private By CartButton = By.partialLinkText("Cart");
    private By TestCasesButton = By.partialLinkText("Test Cases");
    private By ApiTestingButton = By.partialLinkText("API Testing");
    private By  VideoTutorialsButton = By.partialLinkText("Video Tutorials");
    private By  ContactUsButton = By.partialLinkText("Contact us");
    private By LogoutButton = By.linkText("Logout");

    /// // Action Methods //////
    @Step("Clicking on Sign up or Login Button")
    public void clickOnSignUpLoginButton(){
       // driver.findElement(SignUporLoginButton).click();
        ElementActions.click(driver,SignUporLoginButton); //by utilities
    }
    @Step("Clicking on Logout Button")
    public void clickOnLogoutButton(){
        ElementActions.click(driver,LogoutButton);
    }




}
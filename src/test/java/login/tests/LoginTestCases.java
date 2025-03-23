package login.tests;

import io.qameta.allure.*;
import login.pages.HomePage;
import login.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import skeleton.MainMenu;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.PropertiesReader;

@Epic("Access Management")
@Feature("User Login Functionality")
@Story("User Login - Success and Failure Scenarios")
public class LoginTestCases {
    private WebDriver driver;
    private JsonFileManager testData;

    @Test(description = "Successful Login with Valid Credentials")
    @Description("As a user, I want to log in using valid credentials so that I can access my account.")
    @Severity(SeverityLevel.CRITICAL)
    public void happyLoginScenario() {
        new HomePage(driver)
                .navigateToHomePage()
                .validateThatWeAreInHomePage();
        new MainMenu(driver)
                .clickOnSignUpLoginButton();
        new LoginPage(driver)
                .validateLoginTextVisibility()
                .enterEmailAddress(testData.getTestData("email"))
                .enterPassword(testData.getTestData("password"))
                .clickOnLoginButton();
    }

    @Test(description = "End to End Login Scenario")
    @Description("As a user, I want to log in using valid credentials so that I can access my account, and then log out to securely end my session.")
    @Severity(SeverityLevel.CRITICAL)
    public void e2eLoginScenario() {
        new HomePage(driver)
                .navigateToHomePage()
                .validateThatWeAreInHomePage();
        new MainMenu(driver)
                .clickOnSignUpLoginButton();
        new LoginPage(driver)
                .validateLoginTextVisibility()
                .enterEmailAddress(testData.getTestData("email"))
                .enterPassword(testData.getTestData("password"))
                .clickOnLoginButton();
        new MainMenu(driver)
                .clickOnLogoutButton();
    }

    @Test(description = "Unsuccessful Login with Invalid Credentials")
    @Description("User should not be able to access the account with invalid credentials.The system must prevent unauthorized access and display an appropriate error message when incorrect login details are entered.")
    @Severity(SeverityLevel.CRITICAL)
    public void negativeLoginScenario() {
        new HomePage(driver)
                .navigateToHomePage()
                .validateThatWeAreInHomePage();
        new MainMenu(driver)
                .clickOnSignUpLoginButton();
        new LoginPage(driver)
                .validateLoginTextVisibility()
                .enterEmailAddress(testData.getTestData("invalidEmail"))
                .enterPassword(testData.getTestData("wrongPassword"))
                .clickOnLoginButton()
                .validateErrorMessageVisibility();
    }


    /////////// Configurations ///////////

    @BeforeSuite
    public void beforeSuite() {
        PropertiesReader.loadProperties();
    }

    @BeforeClass(description = "Getting Test Data")
    public void DataFileParsing() {
        // as we need to do this only one time (Parsing the file only one time)
        testData = new JsonFileManager("src/test/resources/TestData/TestData.json");

    }

    @BeforeMethod
    public void setUp() {
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver = DriverFactory.initDriver("Chrome",true,20,true); //by utilities
        //driver = DriverFactory.initDriver("chrome"); //by utilities
        driver = DriverFactory.initDriver();  //by properties
    }

    @AfterMethod(description = "Closing Driver")
    public void tearDown() {
        driver.quit();
    }
}

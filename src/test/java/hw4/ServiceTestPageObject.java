package hw4;

import base.SelenideTestBase;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckboxConditions.WATER;
import static enums.CheckboxConditions.WIND;
import static enums.Color.YELLOW;
import static enums.Metal.SELEN;
import static enums.Users.PITER_CHALOVSKII;


public class ServiceTestPageObject extends SelenideTestBase {

    private WebDriver driver;
    private hw4.ServicePage homePage;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        //homePage = PageFactory.initElements(driver, hw4.ServicePage.class);
        homePage = page(hw4.ServicePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void testServicePageObject() {


//1 	Open test site by URL
        homePage.open();

//2	    Assert Browser title
        homePage.checkTitle();

//3 	Perform login
        homePage.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

//4	    Assert User name in the left-top side of screen that user is logged
        homePage.checkProfileName(PITER_CHALOVSKII.profileName);

//5	    Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkButtons();

//6	    Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkLeftSectionButtons();

//7	    Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();

//8	    Check interface on Different elements page, it contains all needed elements
        homePage.checkDifferentElements();

//9	    Assert that there is Right Section
        homePage.checkRightSection();

//10	Assert that there is Left Section
        homePage.checkLeftSection();

//11	Select checkboxes
        homePage.selectCheckboxes();

//12	Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        homePage.checkLogs(WATER);
        homePage.checkLogs(WIND);

//13	Select radio
        homePage.selectRadio();

//14	Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        homePage.checkRadio(SELEN);

//15	Select in dropdown
        homePage.selectDropdown(YELLOW);

//16	Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        homePage.chechDropdown(YELLOW);

//17	Unselect and assert checkboxes
        homePage.selectCheckboxes();

//18	Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        homePage.checkLogs(WATER);
        homePage.checkLogs(WIND);
    }
}

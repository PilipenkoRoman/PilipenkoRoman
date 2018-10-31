package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHALOVSKII;

public class Homework03 {

    private WebDriver driver;
    private hw3.HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, hw3.HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void testPageObject() {

        //1 Navigate
        homePage.open(driver);

        //2  Assert Browser title
        homePage.checkTitle(driver);

        //3 Login
        homePage.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert username
        homePage.checkProfileName(PITER_CHALOVSKII.profileName);

        //5 Assert Browser title
        homePage.checkTitle(driver);

        //6 Menu buttons are displayed and have proper texts
        homePage.checkButtons(driver);

        //7 Assert that there are 4 images
        homePage.checkImages(driver);

        //8 Assert that there are 4 texts
        homePage.checkTexts(driver);

        //9 Assert a text of the main header
        homePage.checkHeader(driver);

        //10 Assert that there is the iframe
        homePage.checkIframe(driver);

        //11 Switch to the iframe and check that there is Epam logo
        homePage.checkLogo(driver);

        //12  Switch to original window back
        homePage.switchToDefaultWindow(driver);

        //13  Assert a text of the sub header
        homePage.checkSubHeaderText(driver);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkLink(driver);

        //15  Assert that there is Left Section
        homePage.checkLeftSection(driver);

        //16 Assert that there is Footer
        homePage.checkFooter(driver);

    }

}

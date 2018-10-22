package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

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
    public void simpleTest() {

        //2 Navigate
        homePage.open(driver);

        //3 Assert Title
        homePage.checkTitle(driver);

        //4 Login
        homePage.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //5 Check main title
        homePage.checkTitle(driver);

        //6 Menu buttons are displayed and have proper texts
        homePage.checkButtons(driver);

        //7
        homePage.checkImages(driver);

        //8
        homePage.checkTexts(driver);

        //9

        //10

        //11

        //12
        homePage.switchToDefaultWindow(driver);

        //13
        homePage.checkSubHeaderText(driver);

        //14
        homePage.checkLink(driver);

        //15

        //16

        //17

    }

}

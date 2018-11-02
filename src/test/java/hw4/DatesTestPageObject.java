package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;

public class DatesTestPageObject {

    private DatesPage homePageSelenide;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(hw4.DatesPage.class);
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        Configuration.browser = "CHROME";
    }

    @Test
    public void testDatesPageObject() {

//        1	Open test site by URL
        homePageSelenide.openPage();

//        2	Assert Browser title
        homePageSelenide.checkTitle();

//        3	Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

//        4	Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkProfileName();

//        5	Open through the header menu Service -> Dates Page
        homePageSelenide.openDatesPage();

//        assertEquals(getWebDriver().findElements(cssSelector("header .nav > li")).stream()
//                        .map(WebElement::getText).collect(Collectors.toList()),
//                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
//        homePageSelenide.findDate();

//        6	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        homePageSelenide.setRange0to100();

//        7	Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        homePageSelenide.check0to100();

//        8	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        homePageSelenide.setRange0to0();

//        9	Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        homePageSelenide.check0to0();

//        10	Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        homePageSelenide.setRange100to100();

//        11	Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        homePageSelenide.check100to100();

//        12	Using drag-and-drop set Range sliders.
        homePageSelenide.setRange30to70();

//        13	Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        homePageSelenide.check30to70();

//        //   setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        //2 Navigate
//        homePageSelenide.openPage();
//
//        //3 Assert Title
//        homePageSelenide.checkTitle();
//
//        //4 Login
//        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);
//
//        //5 Check main title
//        homePageSelenide.checkMainText();
//
//
//        //1
//
//        //2 Navigate
//        open("https://epam.github.io/JDI/");
//
//        //3 Assert Title
//        assertEquals(getWebDriver().getTitle(), "Home Page");
//
//        //4 Login
//        $(".profile-photo").click();
//        $("[id = 'Name']").sendKeys("epam");
//        $("[id = 'Password']").sendKeys("1234");
//        $("[type = 'submit']").click();
//
//
//        SelenideElement mainTitle = $("h3.main-title");
//
//
//        mainTitle.shouldBe(visible);
//        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
//

    }
}

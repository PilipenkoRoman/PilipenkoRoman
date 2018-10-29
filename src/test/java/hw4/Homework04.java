//package hw4;
//
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.SelenideElement;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import javax.swing.*;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import static enums.Users.PITER_CHALOVSKII;
//import static java.lang.System.setProperty;
//import static org.openqa.selenium.By.cssSelector;
//import static org.testng.Assert.assertEquals;
//
//public class Homework04 {
//
//    private HomePageSelenide homePageSelenide;
//
//    @BeforeSuite
//    public void beforeSuite() {
//        Configuration.browser = "chrome";
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//    }
//
//    @BeforeClass
//    public void beforeClass() {
//        homePageSelenide = page(hw4.HomePageSelenide.class);
////        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
////        Configuration.browser = "CHROME";
//    }
//
//    @Test
//    public void simpleTest() {
//
////        1	Open test site by URL
//        homePageSelenide.openPage();
//
////        2	Assert Browser title
//        homePageSelenide.checkTitle();
//
////        3	Perform login
//        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);
//
////        4	Assert User name in the left-top side of screen that user is loggined
//        homePageSelenide.checkProfileName();
//
////        5	Open through the header menu Service -> Dates Page
//        homePageSelenide.openDatesPage();
//
////        assertEquals(getWebDriver().findElements(cssSelector("header .nav > li")).stream()
////                        .map(WebElement::getText).collect(Collectors.toList()),
////                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
////        homePageSelenide.findDate();
//
////        6	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
//        homePageSelenide.setRange0to100();
//
////        7	Assert that for "From" and "To" sliders there are logs rows with corresponding values
////        homePageSelenide.check0to100();
//
////        8	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
//        homePageSelenide.setRange0to0();
//
////        9	Assert that for "From" and "To" sliders there are logs rows with corresponding values
////        homePageSelenide.check0to0();
//
////        10	Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
//        homePageSelenide.setRange100to100();
//
////        11	Assert that for "From" and "To" sliders there are logs rows with corresponding values
////        homePageSelenide.check100to100();
//
////        12	Using drag-and-drop set Range sliders.
//        homePageSelenide.setRange30to70();
//
////        13	Assert that for "From" and "To" sliders there are logs rows with corresponding values
////        homePageSelenide.check30to70();
//
////        //   setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
////        //2 Navigate
////        homePageSelenide.openPage();
////
////        //3 Assert Title
////        homePageSelenide.checkTitle();
////
////        //4 Login
////        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);
////
////        //5 Check main title
////        homePageSelenide.checkMainText();
////
////
////        //1
////
////        //2 Navigate
////        open("https://epam.github.io/JDI/");
////
////        //3 Assert Title
////        assertEquals(getWebDriver().getTitle(), "Home Page");
////
////        //4 Login
////        $(".profile-photo").click();
////        $("[id = 'Name']").sendKeys("epam");
////        $("[id = 'Password']").sendKeys("1234");
////        $("[type = 'submit']").click();
////
////
////        SelenideElement mainTitle = $("h3.main-title");
////
////
////        mainTitle.shouldBe(visible);
////        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
////
//
//    }
//}

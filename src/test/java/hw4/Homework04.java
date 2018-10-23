package hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class Homework04 {

    private HomePageSelenide homePageSelenide;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(hw4.HomePageSelenide.class);
    }

    @Test
    public void simpleTest() {
     //   setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

//        1	Open test site by URL
       openPage("https://epam.github.io/JDI/");


//        2	Assert Browser title
//        3	Perform login
//        4	Assert User name in the left-top side of screen that user is loggined
//        5	Open through the header menu Service -> Dates Page
//        6	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
//        7	Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        8	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
//        9	Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        10	Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
//        11	Assert that for "From" and "To" sliders there are logs rows with corresponding values
//        12	Using drag-and-drop set Range sliders.
//        13	Assert that for "From" and "To" sliders there are logs rows with corresponding values



        //1

        //2 Navigate
        open("https://epam.github.io/JDI/");

        //3 Assert Title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4 Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $("[type = 'submit']").click();


        SelenideElement mainTitle = $("h3.main-title");


        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
    }
}

package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHALOVSKII;

public class DatesTestPageObject {

    private DatesPage homePageSelenide;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        startMaximized = true;
    }

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(hw4.DatesPage.class);
    }

    @Test
    public void testDatesPageObject() {

//        1	Open test site by URL
        homePageSelenide.openPage();

//        2	Assert Browser title
        homePageSelenide.checkTitle();

//        3	Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

//        4	Assert User name in the left-top side of screen that user is logged
        homePageSelenide.checkProfileName();

//        5	Open through the header menu Service -> Dates Page
        homePageSelenide.openDatesPage();

//        6	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        homePageSelenide.setRange(0, 100);

        //  7	Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRange(0, 100);

//        8	Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        homePageSelenide.setRange(0, 0);

//        9	Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRange(0, 0);

//        10	Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most right position.
        homePageSelenide.setRange(100, 100);

//        11	Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRange(100, 100);

//        12	Using drag-and-drop set Range sliders.
        homePageSelenide.setRange(30, 70);

//        13	Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homePageSelenide.checkRange(30, 70);
    }
}

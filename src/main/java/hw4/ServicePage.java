package hw4;

import base.SelenideTestBase;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ServicePage extends SelenideTestBase {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "#Name")
    private SelenideElement login;

    @FindBy(css = "#Password")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

//    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li")
//    private List<SelenideElement> menuButtons;

//    /html/body/header/div/nav/ul
    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li")
    private List<SelenideElement> menuButtons;

    @FindBy(css = ".epam-logo")
    private List<SelenideElement> logo;

    @FindBy(css = ".benefits .icons-benefit")
    private List<SelenideElement> icons;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> texts;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainHeader;

    @FindBy(css = "p.main-txt")
    private SelenideElement mainText;


    @FindBy(css = "iframe")
    private List<SelenideElement> iframe;

    @FindBy(css = "h3:not(.main-title)")
    private SelenideElement link;


//    @FindBy(css = "[name=navigation-sidebar]")
//    private List<WebElement> leftSection;

//    @FindBy(css = "footer")
//    private List<WebElement> footer;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")
    private SelenideElement serviceMenu;

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(3) > a")
    private List<SelenideElement> leftMenuButtons;


    @FindBy(css = "li.dropdown.open > ul > li [href='different-elements.html']")
    private SelenideElement differentElementsPage;


    //================================methods===================================

    public void open() {
        //driver.navigate().to("https://epam.github.io/JDI/index.html");
        Selenide.open("https://epam.github.io/JDI/index.html");
    }


    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

//    assertEquals(driver.findElements(cssSelector(String.valueOf("header .nav > li"))).
//
//    stream().
//
//    map(WebElement::getText).
//
//    collect(Collectors.toList()),
//            Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS"));
//    assertEquals
//    Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Tables With Pages", "Different Elements");


    public void openDifferentElementsPage() {
        serviceMenu.click();
        differentElementsPage.click();
    }


    //================================checks===================================

    public void checkProfileName(String profileName) {
        assertEquals(profileButton.getText(), profileName);
    }

    public void checkTitle(WebDriver driver) {
        assertEquals(getWebDriver().getTitle(), "Home Page");

    }

    public void checkButtons() {
        serviceMenu.click();
        assertTrue(menuButtons.stream().map(SelenideElement::getText).collect(Collectors.toList()).containsAll(
                Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLES WITH PAGES", "DIFFERENT ELEMENTS")));
//

        //        assertEquals(menuButtons.stream()
//                        .map(WebElement::getText).collect(Collectors.toList()),
//                Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Tables With Pages", "Different Elements"));
    }

    public void checkLeftSectionButtons() {
        assertTrue(leftMenuButtons.stream().map(SelenideElement::getText).collect(Collectors.toList()).containsAll(
                Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLES WITH PAGES", "DIFFERENT ELEMENTS")));

    }
}


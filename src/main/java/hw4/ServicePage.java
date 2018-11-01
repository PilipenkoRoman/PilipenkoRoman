package hw4;

import base.SelenideTestBase;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.CheckboxConditions;
import enums.Color;
import enums.Metal;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
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

    @FindBy(css = "header .dropdown-menu > li")
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

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")
    private SelenideElement serviceMenu;

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(3) > a")
    private SelenideElement leftMenuServiceButton;

    @FindBy(css = "li.dropdown.open > ul > li [href='different-elements.html']")
    private SelenideElement differentElementsPage;

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(3) > ul > li")
    private List<SelenideElement> leftMenuElements;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > .checkbox-row .label-checkbox")
    private List<SelenideElement> checkboxElements;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > .checkbox-row .label-radio")
    private List<SelenideElement> radioElements;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > div.colors > select")
    private SelenideElement dropdownElement;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > button")
    private SelenideElement firstButton;

    @FindBy(css = "body > div > div.uui-main-container.page-inside > main > div.main-content > div > input")
    private SelenideElement secondButton;

    @FindBy(css = "#mCSB_1")
    private List<SelenideElement> leftSection;

    @FindBy(css = "body > div > div.uui-side-bar.right-fix-panel.mCustomScrollbar._mCS_2.mCS_no_scrollbar")
    private SelenideElement rightSection;


    @FindBy(css = "#mCSB_2_container > section:nth-child(1) > div.info-panel-body.info-panel-body-log > div")
    private SelenideElement elementsLogWindow;


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

    public void openDifferentElementsPage() {
        serviceMenu.click();
        differentElementsPage.click();
    }

    public void selectCheckboxes() {
        checkboxElements.get(0).click();
        checkboxElements.get(2).click();
    }

    public void selectRadio() {
        radioElements.get(3).click();
    }

    public void selectDropdown(Color colorName) {
        dropdownElement.selectOption(colorName.colorType);
    }
    //================================checks===================================

    public void checkProfileName(String profileName) {
        assertEquals(profileButton.getText(), profileName);
    }

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");

    }

    public void checkButtons() {
        serviceMenu.click();
        assertTrue(menuButtons.stream().map(SelenideElement::getText).collect(Collectors.toList()).containsAll(
                Arrays.asList(
                        "SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS")));
    }

    public void checkLeftSectionButtons() {
        leftMenuServiceButton.click();
        List<String> list = leftMenuElements.stream().map(SelenideElement::getText).collect(Collectors.toList());
        assertTrue(list.containsAll(
                Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements")));
    }

    public void checkDifferentElements() {
        assertTrue(checkboxElements.stream().allMatch(SelenideElement::isDisplayed));
        assertTrue(radioElements.stream().allMatch(SelenideElement::isDisplayed));
        assertTrue(dropdownElement.isDisplayed());
        assertTrue(firstButton.isDisplayed());
        assertTrue(secondButton.isDisplayed());
    }

    public void checkLeftSection() {
        assertTrue(leftSection.
                stream().
                anyMatch(SelenideElement::isDisplayed));
    }

    public void checkRightSection() {
        assertTrue(rightSection.isDisplayed());
    }

    public void checkLogs(CheckboxConditions checkcon) {
        elementsLogWindow.shouldHave(text(checkcon.elementName));
        elementsLogWindow.shouldHave(text(checkcon.elementName));
    }

    public void checkRadio(Metal metalName) {
        elementsLogWindow.shouldHave(text(metalName.metalType));
    }

    public void chechDropdown(Color color) {
        elementsLogWindow.shouldHave(text(color.colorType));

    }

}



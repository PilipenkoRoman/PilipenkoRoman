package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "#Name")
    private WebElement login;

    @FindBy(css = "#Password")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = "header .nav > li")
    private WebElement menuButtons;

    @FindBy(css = ".epam-logo")
    private WebElement logo;

    @FindBy(css = ".benefits .icons-benefit")
    private WebElement icons;

    @FindBy(css = ".benefit-txt")
    private WebElement texts;

    @FindBy(css = "h3.main-title")
    private WebElement mainHeader;

    @FindBy(css = "p.main-txt")
    private WebElement mainText;


    @FindBy(css = "iframe")
    private WebElement iframe;


    //================================methods===================================

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void checkProfileName(String profileName) {
        assertEquals(profileButton.getText(), profileName);
    }

    public void switchToDefaultWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //================================checks===================================


    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkButtons(WebDriver driver) {
        assertEquals(driver.findElements(cssSelector(String.valueOf(menuButtons))).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
    }

    public void checkImages(WebDriver driver) {
        assertEquals(driver.findElements(cssSelector(String.valueOf(icons))).stream()
                        .filter(WebElement::isDisplayed).count(),
                4);
    }

    public void checkTexts(WebDriver driver) {
        assertEquals(driver.findElements(cssSelector(String.valueOf(texts))).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable",
                        "To be multiplatform",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));
    }

    public void checkHeader(WebDriver driver) {
        assertEquals(driver.findElement(cssSelector(String.valueOf(mainHeader))).getText(),
                "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(cssSelector(String.valueOf(mainText))).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
                        "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                        "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkIframe(WebDriver driver) {
        assertTrue(driver.findElements(By.id(String.valueOf(iframe))).stream().anyMatch(WebElement::isDisplayed));
    }

    public void checkLogo(WebDriver driver) {
        driver.switchTo().frame(0);
        assertTrue(driver.findElements(By.cssSelector(String.valueOf(logo))).stream().anyMatch(WebElement::isDisplayed));
    }

    public void checkSubHeaderText(WebDriver driver) {
        WebElement subHeader = driver.findElement(cssSelector("h3:not(.main-title)"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void checkLink(WebDriver driver) {
        WebElement subHeader = driver.findElement(cssSelector("h3:not(.main-title)"));
        List<WebElement> subHeaderLink = subHeader.findElements(By.linkText("JDI GITHUB"));
        assertTrue(!subHeaderLink.isEmpty());
        assertEquals(subHeaderLink.get(0).getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSection(WebDriver driver) {
        assertTrue(driver.findElements(By.cssSelector("[name=navigation-sidebar]")).stream().anyMatch(WebElement::isDisplayed));
    }

    public void checkFooter(WebDriver driver) {
        assertTrue(driver.findElements(By.cssSelector("footer")).stream().anyMatch(WebElement::isDisplayed));
    }
}




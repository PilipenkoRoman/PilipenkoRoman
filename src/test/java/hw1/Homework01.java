package hw1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.System.setOut;
import static java.lang.System.setProperty;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework01 {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "CHROME";
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
//        homePageSelenide = page(hw4.HomePageSelenide.class);
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        Configuration.browser = "CHROME";
    }


    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Login
        driver.findElement(cssSelector(".profile-photo")).click();
        driver.findElement(cssSelector("#Name")).sendKeys("epam");
        driver.findElement(cssSelector("#Password")).sendKeys("1234");
        driver.findElement(cssSelector(".login [type = 'submit']")).click();

        //3.5
        driver.findElement(cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")).click();
        driver.findElement(cssSelector("li.dropdown.open > ul > li [href='dates.html']")).click();


//        body > div > div.uui-main-container.page-inside > main > div.main-content > div > form > div:nth-child(4) > div:nth-child(2) > div > div
//        body > div > div.uui-main-container.page-inside > main > div.main-content > div > form > div:nth-child(4) > div:nth-child(2) > div > a:nth-child(1)
//        body > div > div.uui-main-container.page-inside > main > div.main-content > div > form > div:nth-child(4) > div:nth-child(2) > div > a:nth-child(1) > span
//
//        body > div > div.uui-main-container.page-inside > main > div.main-content > div > form > div:nth-child(4) > div:nth-child(2) > div > a:nth-child(1)
//
//        body > div > div.uui-main-container.page-inside > main > div.main-content > div > form > div:nth-child(4) > div:nth-child(2) > div > a.ui-slider-handle.ui-state-default.ui-corner-all.ui-state-hover
///html / body / div / div[2] / main / div[2] / div / form / div[4] / div[2] / div / a[1]


//
//        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement right =webElementList.get(1);
//        WebElement left = webElementList.get(0);
//        Actions builder = new Actions(driver);
//        builder.dragAndDropBy(left,Integer.MIN_VALUE,0).perform();
//        builder.dragAndDropBy(right,0,0).perform();
//       // System.out.println(driver.findElement(cssSelector("div.info-panel-body.info-panel-body-log > div > ul")).getText());
//        builder.build();

  //      ElementsCollection selenideElements = $$(xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        ArrayList<SelenideElement> selList = new ArrayList<SelenideElement>();
//       Actions builder=new Actions()
//        selList.add(selenideElements.get(0));

//        selList.add(selenideElements.get(1));

      //  SelenideElement rightSlider = selenideElements.get(1);
        //SelenideElement leftSlider = selenideElements.get(0);
       // actions().dragAndDropBy(leftSlider, Integer.MIN_VALUE, 0).perform();

       // actions().dragAndDropBy(selenideElements.first(), -100, 0).perform();

//        SelenideElement slider = (SelenideElement) driver.findElement(cssSelector("body > div > div.uui-main-container.page-inside > main > div.main-content > div > form > div:nth-child(4) > div:nth-child(2) > div > a:nth-child(1) > span"));
//        Actions move = new Actions(driver);

//        WebElement drag = driver.findElement(cssSelector(".ui-slider-handle ui-state-default ui-corner-all ui-state-hover"));
//        WebElement drop = driver.findElement(By.xpath(".//*[@id=’box104']"));
//     SelenideElement drag = (SelenideElement) driver.findElement(cssSelector(".ui-slider-handle ui-state-default ui-corner-all ui-state-hover"));
//        SelenideElement drop = (SelenideElement) driver.findElement(By.xpath(".//*[@id=’box104']"));

        // dragAndDropBy(WebElement source, int xOffset, int yOffset)

//        builder.clickAndHold(left).moveByOffset(0,0).perform();
//       builder.clickAndHold(left).moveByOffset(76,0).release().perform();
//   assertEquals(driver.findElement(cssSelector("div.info-panel-body.info-panel-body-log > div > ul")));


//        builder.dragAndDropBy(right,-100,0).perform();




        try

    {
        Thread.sleep(5000
        );
    } catch(
    InterruptedException e)

    {
        e.printStackTrace();
    }


//    //4 Name is displayed and equals to expected result
//    assertEquals(driver.findElement(cssSelector(".profile-photo")).
//
//    getText(), "PITER CHAILOVSKII");
//
//    //5 Browser title equals "Home Page"
//    assertEquals(driver.getTitle(), "Home Page");
//
//    //6 Menu buttons are displayed and have proper texts
//    assertEquals(driver.findElements(cssSelector("header .nav > li")).
//
//    stream()
//                        .
//
//    map(WebElement::getText).
//
//    collect(Collectors.toList()),
//            Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS"));
//
//    //7 Assert that there are 4 images on the Index Page and they are displayed	4 images
//    assertEquals(driver.findElements(cssSelector(".benefits .icons-benefit")).
//
//    stream()
//                        .
//
//    filter(WebElement::isDisplayed).
//
//    count(),
//                4);
//
//    //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
//    assertEquals(driver.findElements(cssSelector(".benefit-txt")).
//
//    stream()
//                        .
//
//    map(WebElement::getText).
//
//    collect(Collectors.toList()),
//            Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
//            "To be flexible and\ncustomizable",
//            "To be multiplatform",
//            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));
//
//    //9 Assert a text of the main header	"EPAM FRAMEWORK WISHES…" and "LOREM IPSUM..."
//    assertEquals(driver.findElement(cssSelector("h3.main-title")).
//
//    getText(),
//                "EPAM FRAMEWORK WISHES…");
//
//    assertEquals(driver.findElement(cssSelector("p.main-txt")).
//
//    getText(),
//                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "+
//                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "+
//                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS "+
//                        "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN "+
//                        "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
//
//    //10 Assert that there is the iframe in the center of page		The iframe exists
//    assertTrue(driver.findElements(By.id("iframe")).
//
//    stream().
//
//    anyMatch(WebElement::isDisplayed));
//
//    //11 The logo exists
//        driver.switchTo().
//
//    frame(0);
//
//    assertTrue(driver.findElements(By.cssSelector(".epam-logo")).
//
//    stream().
//
//    anyMatch(WebElement::isDisplayed));
//
//    //12 Switch to original window back		Driver has focus on the original window
//        driver.switchTo().
//
//    defaultContent();
//
//    //13 Text is displayed and equals to expected result
//    // Assert a text of the sub header	JDI GITHUB
//    WebElement subHeader = driver.findElement(cssSelector("h3:not(.main-title)"));
//
//    assertTrue(subHeader.isDisplayed());
//
//    assertEquals(subHeader.getText(), "JDI GITHUB");
//
//    //14 Assert that JDI GITHUB is a link and has a proper URL	https://github.com/epam/JDI
//    List<WebElement> subHeaderLink = subHeader.findElements(By.linkText("JDI GITHUB"));
//
//    assertTrue(!subHeaderLink.isEmpty());
//
//    assertEquals(subHeaderLink.get(0).
//
//    getAttribute("href"), "https://github.com/epam/JDI");
//
//    //15 Assert that there is Left Section
//    assertTrue(driver.findElements(By.cssSelector("[name=navigation-sidebar]")).
//
//    stream().
//
//    anyMatch(WebElement::isDisplayed));
//
//    //16 Assert that there is Footer
//    assertTrue(driver.findElements(By.cssSelector("footer")).
//
//    stream().
//
//    anyMatch(WebElement::isDisplayed));

    //17 Close Browser
       driver.quit();
}
}

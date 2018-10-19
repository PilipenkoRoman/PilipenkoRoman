package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.System.setProperty;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework01 {


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


        //4 Name is displayed and equals to expected result
        assertEquals(driver.findElement(cssSelector(".profile-photo")).getText(), "PITER CHAILOVSKII");


        //5 Browser title equals "Home Page"
        assertEquals(driver.getTitle(), "Home Page");


        //6 Menu buttons are displayed and have proper texts
        assertEquals(driver.findElements(cssSelector("header .nav > li")).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));


//

        //7 Assert that there are 4 images on the Index Page and they are displayed	4 images	Images are displayed
        assertEquals(driver.findElements(cssSelector(".benefits .icons-benefit")).stream()
                        .filter(WebElement::isDisplayed).count(),
                4);


        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text	4 texts below of each image	Texts are displayed and equal to expected
        assertEquals(driver.findElements(cssSelector(".benefit-txt")).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable",
                        "To be multiplatform",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));


        //9 Assert a text of the main header	"EPAM FRAMEWORK WISHES…" and "LOREM IPSUM..."	Text is displayed and equals to expected result
        assertEquals(driver.findElement(cssSelector("h3.main-title")).getText(),
                "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(cssSelector("p.main-txt")).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
                        "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                        "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");


        //10 Assert that there is the iframe in the center of page		The iframe exists
        assertTrue(driver.findElements(By.id("iframe")).stream().anyMatch(WebElement::isDisplayed));


        //11 The logo exists
        driver.switchTo().frame(0);
        assertTrue(driver.findElements(By.cssSelector(".epam-logo")).stream().anyMatch(WebElement::isDisplayed));


        //12 Switch to original window back		Driver has focus on the original window
        driver.switchTo().defaultContent();


        //13 Text is displayed and equals to expected result
        // Assert a text of the sub header	JDI GITHUB	Text is displayed and equals to expected result
        WebElement subHeader = driver.findElement(cssSelector("h3:not(.main-title)"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");



        //14 Assert that JDI GITHUB is a link and has a proper URL	https://github.com/epam/JDI	Link is displayed and has proper value
        List<WebElement> subHeaderLink = subHeader.findElements(By.linkText("JDI GITHUB"));
        assertTrue(!subHeaderLink.isEmpty());
        assertEquals(subHeaderLink.get(0).getAttribute("href"), "https://github.com/epam/JDI");


        //15 Assert that there is Left Section		Left section is displayed
        assertTrue(driver.findElements(By.cssSelector("[name=navigation-sidebar]")).stream().anyMatch(WebElement::isDisplayed));


        //16 Assert that there is Footer		Footer is displayed
        assertTrue(driver.findElements(By.cssSelector("footer")).stream().anyMatch(WebElement::isDisplayed));


        //17 Close Browser		Browser is closed
        driver.quit();
    }
}

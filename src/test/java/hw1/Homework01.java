package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.System.setProperty;
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

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert Title
        assertEquals(driver.getTitle(), "Home Page");

        //4 Login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        assertEquals(driver.findElement(By.cssSelector(".profile-photo")).getText(), "PITER CHAILOVSKII");
        assertEquals(driver.getTitle(), "Home Page");

        //6
        assertEquals(driver.findElements(By.cssSelector("header .nav > li")).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));




        //driver.findElement(By.linkText("Home"));


        //7
        // WebElement element = driver.findElement (By.cssSelector("div.benefit-icon").
        List<WebElement> elements = driver.findElements(By.cssSelector(".benefit"));
        assertEquals(4, elements.size());
        for (WebElement webel : elements
        ) {
            assertTrue(webel.isDisplayed());
        }


        //8 Texts are displayed and equal to expected
       List<WebElement> textElements = driver.findElements(By.cssSelector(".benefit-txt"));
//        assertEquals(4, elements.size());

//          assertEquals(textElements.get(0).getText(), "To include good practices and ideas from successful EPAM project");
//          assertEquals(textElements.get(1).getText(), "To be flexible and<br>customizable");
          assertEquals(textElements.get(2).getText(), "To be multiplatform");
//          assertEquals(textElements.get(3).getText(), "Already have good base<br>(about 20 internal and<br>some external projects),<br>wish to get more…");


        //9 Text is displayed and equals to expected result
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainSubTitle = driver.findElement(By.cssSelector("p.main-txt"));
        assertEquals(mainSubTitle.getText(),"LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 The iframe exists
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        //11 The logo exists
        assertTrue(driver.findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12


//        textElements.forEach(webelTxt -> assertEquals(webelTxt.getText(), ("To be multiplatform"||"")));
//        assertEquals(driver.findElements(By.cssSelector(");
        driver.close();
    }
}

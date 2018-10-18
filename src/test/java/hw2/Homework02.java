package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;

public class Homework02 {

    @DataProvider(name = "correctData", parallel = true)
    public Object[][] correctData() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        List<WebElement> textElements = driver.findElements(cssSelector(".benefit-txt"));

        return new Object[][]{
                {textElements.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM project"},
                {textElements.get(1).getText(), "To be flexible and\ncustomizable"},
                {textElements.get(2).getText(), "To be multiplatform"},
                {textElements.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @Test(dataProvider = "correctData", threadPoolSize = 4)
    public void dataProviderTest(String actual, String expected) {
        assertEquals(actual, expected);
    }


    //
//   @DataProvider(name = "test1")
//   @DataProvider(name = "test2")
//   @DataProvider(name = "test3")
//   @DataProvider(name = "test4")
    // @Test(dataProvider = "dp1" ,threadPoolSize=3,invocationCount=1)

//    public static WebDriver driver = new ChromeDriver();

//    @DataProvider(name="dp",parallel = true)
//    public Object[][] dp() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.navigate().to("https://epam.github.io/JDI/index.html");
//        List<WebElement> textElements = driver.findElements(cssSelector(".benefit-txt"));
////        return new Object[][]{
////                new Object[]{textElements.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM project"},
////                new Object[]{textElements.get(1).getText(), "To be flexible and\ncustomizable"},
////                new Object[]{textElements.get(2).getText(), "To be multiplatform"},
////                new Object[]{textElements.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}};
//
//  return new Object[][]{
//          new Object[] {"To include good practices\nand ideas from successful\nEPAM project",},
//          new Object[] {"To be flexible and\ncustomizable"},
//          new Object[] {"To be multiplatform"},
//          new Object[] {"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}};}
//
//
//  @Test(dataProvider = "dp")
//    public void
//
//
////    return Arrays.asList(
////            "To include good practices\nand ideas from successful\nEPAM project",
////            "To be flexible and\ncustomizable",
////            "To be multiplatform",
////            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
////
////    //open BR
////
////}
////
////    //@DataProvider(parallel = true)
////    public void indexPage4text() {
////
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
////        driver.navigate().to("https://epam.github.io/JDI/index.html");
//////
//////        assertEquals(driver.findElements(cssSelector(".benefit-txt")).stream()
//////                        .map(WebElement::getText).collect(Collectors.toList()),
//////                Arrays.asList(
//////                        "To include good practices\nand ideas from successful\nEPAM project",
//////                        "To be flexible and\ncustomizable",
//////                        "To be multiplatform",
//////                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));
//////

}




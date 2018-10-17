package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;

public class Homework02 {
//
//   @DataProvider(name = "test1")
//   @DataProvider(name = "test2")
//   @DataProvider(name = "test3")
//   @DataProvider(name = "test4")
    // @Test(dataProvider = "dp1" ,threadPoolSize=3,invocationCount=1)

    public static WebDriver driver = new ChromeDriver();

    public void simpleTest() {

        //open BR

    }

    //@DataProvider(parallel = true)
    public void indexPage4text() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        assertEquals(driver.findElements(cssSelector(".benefit-txt")).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList(
                        "To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable",
                        "To be multiplatform",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));


    }

}
}

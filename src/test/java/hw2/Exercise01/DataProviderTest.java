package hw2.Exercise01;

import DataProviders.DataProviders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.openqa.selenium.By.cssSelector;

public class DataProviderTest {



    @Test(dataProvider = "correctData",dataProviderClass = DataProviders.class)
    public void dataProviderTest(String actual, String expected) {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        List<WebElement> textElements = driver.findElements(cssSelector(".benefit-txt"));
        driver.close();
            }
}




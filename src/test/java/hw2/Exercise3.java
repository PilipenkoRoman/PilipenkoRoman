package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class Exercise3 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void simpleTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }




//    @AfterSuite
//    @AfterClass
//    @BeforeClass
//            @BeforeSuite
//
//System.out.println(driver.getTitle());
//driver.manage().window().maximize();
//System.out.println(System.currentTimeMillis());


}}

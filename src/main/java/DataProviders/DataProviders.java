package DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(parallel = true)
    public Object[][]simpleDataProvider(){
        return new Object[][]{
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] correctData() {

        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }


//    @DataProvider(parallel = true)
//    public Object[][] correctData() {
//        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.navigate().to("https://epam.github.io/JDI/index.html");
//        List<WebElement> textElements = driver.findElements(cssSelector(".benefit-txt"));
//
//        return new Object[][]{
//                {textElements.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM project"},
//                {textElements.get(1).getText(), "To be flexible and\ncustomizable"},
//                {textElements.get(2).getText(), "To be multiplatform"},
//                {textElements.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
//        };
//    }

}

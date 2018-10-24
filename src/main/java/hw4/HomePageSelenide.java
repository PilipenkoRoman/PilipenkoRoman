//package hw4;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.SelenideElement;
//import cucumber.api.java.eo.Se;
//import io.qameta.allure.Step;
//import org.openqa.selenium.support.FindBy;
//
//import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import static org.openqa.selenium.By.cssSelector;
//import static org.openqa.selenium.By.xpath;
//import static org.testng.Assert.assertEquals;
//
//public class HomePageSelenide {
//
//    @FindBy(css = ".profile-photo")
//    private SelenideElement profileButton;
//
//    @FindBy(css = "[id = 'Name']")
//    private SelenideElement login;
//
//    @FindBy(css = "[id = 'Password']")
//    private SelenideElement password;
//
//    @FindBy(css = "[type = 'submit']")
//    private SelenideElement submit;
//
//    @FindBy(css = "h3.main-title")
//    private SelenideElement mainTitle;
//
////    @FindBy(xpath = "//span[contains(.,'PITER CHAILOVSKII')]")
////    private SelenideElement profileName;
//
//    @FindBy(css = ".profile-photo span")
//    private SelenideElement profileName;
//
//    //@FindBy(xpath = "\"header .nav > li\"")
//    @FindBy(xpath = "//span[contains(.,'Support')]")
//    private SelenideElement serviceMenu;
//
//    @FindBy(xpath = "//span[contains(.,'Dates')]")
//    private SelenideElement datesMenu;
//
//    @FindBy(xpath = "//label[contains(.,'Range2')]")
//    private SelenideElement range;
//
//    @FindBy(css = "ui-slider-range ui-widget-header ui-corner-all span")
//    private SelenideElement leftSlider;
//
//    @FindBy(css = ".profile-photo span")
//    private SelenideElement rightSlider;
//
//    @FindBy(css = ".sidebar-menu .menu-title ui span")
//
//
//    //================================methods===================================
//
//    @Step("Open JDI Test Application - Home Page")
//    public void openPage() {
//        open("https://epam.github.io/JDI");
//    }
//
//    @Step
//    public void login(String name, String passwd) {
//        profileButton.click();
//        login.sendKeys(name);
//        password.sendKeys(passwd);
//        submit.click();
//    }
//
//    @Step
//    public void findDate() {
//        serviceMenu.click();
//        datesMenu.click();
//    }
//
//    @Step
//    public void setRange(){
//
//
//
//        $(xpath("//label[contains(.,'Range2')]")).click();
//
//    }
//
//    //================================checks===================================
//
//    @Step
//    public void checkTitle() {
//        assertEquals(getWebDriver().getTitle(), "Home Page");
//    }
//
////    @Step
////    public void checkMainText() {
////        //mainTitle.shouldBe(visible);
////        //mainTitle.shouldHave(text("EPA FRAMEWORK WISHES..."));
////    }
//
//    @Step
//    public void checkProfileName() {
//        profileName.shouldHave(Condition.text("Piter Chailovskii"));
//    }
//}
package hw4;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".profile-photo span")
    private SelenideElement profileName;


    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")
    private SelenideElement serviceMenu;

    @FindBy(css = "li.dropdown.open > ul > li [href='dates.html']")
    private SelenideElement datesPage;

    @FindBy(css = "div.info-panel-body.info-panel-body-log > div > ul")
    public SelenideElement logsWindow;

    @FindBy(css = ".ui-slider-handle")
    private List<SelenideElement> sliders;

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;


    //================================methods===================================


    public void openPage() {
        open("https://epam.github.io/JDI");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void openDatesPage() {
        serviceMenu.click();
        datesPage.click();
    }

    private double getStep() {
        return (double) slider.getSize().getWidth() / 100;
    }

    private void moveSlider(SelenideElement slider, double to) {
        double curPos = Double.parseDouble(slider.text());
        double shift = (to - curPos > 0) ?
                (to - curPos) * getStep() :
                (to - curPos - 1) * getStep();
        actions().dragAndDropBy(slider.toWebElement(), (int) shift, 0).build().perform();
    }


    public void setRange(double leftSlider, double rightSlider) {
        if (sliders.get(0).getLocation().getX() == sliders.get(1).getLocation().getX()) {
            moveSlider(sliders.get(0), leftSlider);
            moveSlider(sliders.get(1), rightSlider);}
        moveSlider(sliders.get(1), rightSlider);
        moveSlider(sliders.get(0), leftSlider);
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkRange(int from, int to) {
        logsWindow.shouldHave(text(String.valueOf(from)));
        logsWindow.shouldHave(text(String.valueOf(to)));

    }

    public void checkProfileName() {
        profileName.shouldHave(text("Piter Chailovskii"));
    }


}
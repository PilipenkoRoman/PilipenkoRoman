package hw4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Open JDI Test Application - Home Page")
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
//        List<WebElement> listWeb = new ArrayList<>(getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']")));
//        WebElement leftSlider = listWeb.get(0);
//        WebElement rightSlider = listWeb.get(1);
//        Actions builder = new Actions(getWebDriver());
     }

//    public void setRange(int left,int right){
//        List<WebElement> webElementList = getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement rightSlider =webElementList.get(1);
//        WebElement leftSlider = webElementList.get(0);
//        left<leftSlider.get ? left=-left};
//        Actions builder = new Actions(getWebDriver());
//        builder.dragAndDropBy(left,74,0).perform();
//        builder.dragAndDropBy(right,0,0).perform();
//    }

    //

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

    //
////      if (leftSli.getLocation().getX() == rightSli.getLocation().getX() &&
////            rightSli.getLocation().getX() == 1156) {
//
    public void setRange(double leftSlider, double rightSlider) {
//        SelenideElement leftSli = sliders.get(0);
//        SelenideElement rightSli = sliders.get(1);
        if (sliders.get(0).getLocation().getX() == sliders.get(1).getLocation().getX()){
            moveSlider(sliders.get(0), leftSlider);
            moveSlider(sliders.get(1), rightSlider);}
        moveSlider(sliders.get(1), rightSlider);
        moveSlider(sliders.get(0), leftSlider);
    }

//    private double getStep() {
//        return (double) slider.getSize().getWidth() / 100;
//    }
//
//
//    public void setRange(double from, double to) {
//        // (leftPos<(leftSlider.getLocation().getX()/3.75))?leftPos=-leftPos:
//        if (sliders.get(0).getLocation().getX() != sliders.get(1).getLocation().getX()) {
//            moveSlider(sliders.get(0), from);
//            moveSlider(sliders.get(1), to);
//        }
//        moveSlider(sliders.get(1), to);
//        moveSlider(sliders.get(0), from);
//   }
//
//    private void moveSlider(SelenideElement slider, double to) {
//        double curPos = Double.parseDouble(slider.text());
//        double shift = (to - curPos - 1) * getStep();
//        actions().dragAndDropBy(slider.toWebElement(), (int) shift, 0).perform();
//    }


    public void setRange0to100() {
//        List<WebElement> webElementList =getSliders();
//        WebElement leftSlider = webElementList.get(0);
//        WebElement rightSlider =webElementList.get(1);
//        getSliders();
////        Actions builder = new Actions(getWebDriver());
//        System.out.println(rightSlider.getLocation().getX());
//        System.out.println(leftSlider.getLocation().getX());
//        builder.dragAndDropBy(leftSlider, -10000, 0).perform();
//        System.out.println(leftSlider.getLocation().getX());
//
//        System.out.println(rightSlider.getLocation().getX());
//        builder.dragAndDropBy(rightSlider, 10000, 0).perform();
//        System.out.println(rightSlider.getLocation().getX());
//        System.out.println("right");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
////                builder.build();
//    }
//
//    public void setRange0to0() {
////        getSliders();
//        Actions builder = new Actions(getWebDriver());
//        System.out.println("asd");
//        System.out.println(leftSlider.getLocation().getX());
//        builder.dragAndDropBy(leftSlider, -1000, 0).perform();
//        builder.dragAndDropBy(rightSlider, -2000, 0).perform();
//        System.out.println(leftSlider.getLocation().getX());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        builder.build();
//        builder.dragAndDropBy(left,1000,0).perform();
//        builder.dragAndDropBy(right,1000,0).perform();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }}
    }

//    public void setRange100to100() {
//        //    getSliders();
////        Actions builder = new Actions(getWebDriver());
//        builder.dragAndDropBy(rightSlider, 2000, 0).perform();
//        builder.dragAndDropBy(leftSlider, 1000, 0).perform();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        builder.build();
//        //        builder.build();
//    }
//
//    public void setRange30to70() {
////        List<WebElement> webElementList = getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
////        WebElement left = webElementList.get(0);
////        WebElement right = webElementList.get(1);
////        Actions builder = new Actions(getWebDriver());
//        System.out.println(rightSlider.getLocation().getX());
//        builder.dragAndDropBy(rightSlider, rightSlider.getLocation().getX() - 650, 0).perform();
//        builder.dragAndDropBy(leftSlider, -111, 0).perform();
////        builder.build();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    //        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement right =webElementList.get(1);
//        WebElement left = webElementList.get(0);
//       Actions builder = new Actions(getWebDriver());
//        builder.dragAndDropBy(left,Integer.MIN_VALUE,0).perform();
//        builder.dragAndDropBy(right,0,0).perform();

//       builder.build();


//    public ArrayList<SelenideElement> getSliders() {
//        ElementsCollection selenideElements = $$(xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        ArrayList<SelenideElement> selList = new ArrayList<SelenideElement>();
//        selList.add(selenideElements.get(0));

//        selList.add(selenideElements.get(1));

//    return selList;

//    }


    //    @Step
//    public void findDate() {
//        serviceMenu.click();
//        datesMenu.click();
//    }

//
//    public  getSliders
//    ElementsCollection selenideElements=$$(xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//    SelenideElement leftSlider=selenideElements.get(0);
//    SelenideElement rightSlider=selenideElements.get(1);
//
//

//            5
//        driver.findElement(cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")).click();
//                driver.findElement(cssSelector("li.dropdown.open > ul > li [href='dates.html']")).click();


    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    //
    public void checkRange(int from, int to) {

        logsWindow.shouldHave(text(String.valueOf(to)));
        logsWindow.shouldHave(text(String.valueOf(from)));

    }
//
//    public void check0to0() {
//        $(logsWindow).shouldHave(text(TO_0.s));
//        $(logsWindow).shouldHave(text(FROM_0.s));
//    }
//
//    public void check100to100() {
//        $(logsWindow).shouldHave(text(FROM_100.s));
//        $(logsWindow).shouldHave(text(TO_100.s));
//    }
//
//    public void check30to70() {
//        $(logsWindow).shouldHave(text(TO_70.s));
//        $(logsWindow).shouldHave(text(FROM_30.s));
//    }

    public void checkProfileName() {
        profileName.shouldHave(text("Piter Chailovskii"));
    }


//
//        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement left = webElementList.get(0);
//        WebElement right = webElementList.get(1);
//    }


    //    @Step
//    public void checkMainText() {
//        //mainTitle.shouldBe(visible);
//        //mainTitle.shouldHave(text("EPA FRAMEWORK WISHES..."));
//    }


}
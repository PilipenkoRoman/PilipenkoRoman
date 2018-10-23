package hw4;

import static com.codeborne.selenide.Selenide.open;

public class HomePageSelenide {

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }


}

package enums;

public enum Users {

    PITER_CHALOVSKII("epam", "1234");

    public String login;
    public String password;
    public String profileName;

    Users(String login, String password) {
        this.login = login;
        this.password = password;
        this.profileName = profileName;
    }
}



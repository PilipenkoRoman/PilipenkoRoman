package enums;

public enum Color {


    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String colorType;

    Color(String colorType) {
        this.colorType = colorType;
    }

}

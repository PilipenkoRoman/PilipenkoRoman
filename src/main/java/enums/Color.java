package enums;

public enum Color {


RED("Colors: value changed to Red"),
GREEN("Colors: value changed to Green"),
BLUE("Colors: value changed to Blue"),
YELLOW("Colors: value changed to Yellow");

    public String colorType ;

    Color(String colorType) {
        this.colorType = colorType;
    }

}

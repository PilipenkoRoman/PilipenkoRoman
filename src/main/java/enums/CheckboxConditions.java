package enums;

public enum CheckboxConditions {

        WATER("Water: condition changed to "),
        EARTH("Earth: condition changed to "),
        WIND("Wind: condition changed to "),
        FIRE("Fire: condition changed to ");

    public String elementName ;

        CheckboxConditions(String elementName) {
            this.elementName = elementName;
        }
    }





package enums;

public enum CheckboxConditions {

        WATER("Water: condition changed to "),
        EARTH("Earth: condition changed to "),
        WIND("Wind: condition changed to "),
        FIRE("Fire: condition changed to "),
        TO_70("Range 2(To):70 link clicked"),
        TO_100("Range 2(To):100 link clicked");

    public String elementName ;

        CheckboxConditions(String elementName) {
            this.elementName = elementName;
        }
    }





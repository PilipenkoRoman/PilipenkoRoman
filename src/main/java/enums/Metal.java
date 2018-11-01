package enums;

public enum Metal {

        GOLD("metal: value changed to Gold"),
        SILVER("metal: value changed to Silver"),
        BRONZE("metal: value changed to Bronze"),
        SELEN("metal: value changed to Selen");

        public String metalType ;

        Metal(String metalType) {
            this.metalType = metalType;
        }
}

package name.hanyi.unitsconversion;

public enum Unit {
    INCH("inch"),
    CM("cm"),
    POUND("pound"),
    KILOGRAM("kilogram");

    private final String name;

    Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

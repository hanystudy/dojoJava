package name.hanyi.unitsconversion;

public enum Ratio {
    RATIO_POUND_TO_KILO(0.45359237D),
    RATIO_INCH_TO_CM(2.54D);

    private final double ratio;

    Ratio(double ratio) {
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }
}

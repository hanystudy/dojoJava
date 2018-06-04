package name.hanyi.unitsconversion;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnitsConversion {
    public static final int PRECISION = 8;
    public static final double RATIO_POUND_TO_KILO = 0.45359237D;
    public static final double RATIO_INCH_TO_CM = 2.54D;
    private String sourceUnit;
    private String targetUnit;

    public BigDecimal get(double number) {
        return BigDecimal.valueOf(calculate(number))
                .setScale(PRECISION, RoundingMode.HALF_UP);
    }

    private double calculate(double number) {
        if (this.sourceUnit.equals("inch") && this.targetUnit.equals("cm")) {
            return number * RATIO_INCH_TO_CM;
        }
        return number * RATIO_POUND_TO_KILO;
    }

    public void setUnits(String sourceUnit, String targetUnit) {
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }
}

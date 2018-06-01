package name.hanyi.unitsconversion;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnitsConversion {
    public static final int PRECISION = 8;
    public static final double RATIO_POUND_TO_KILO = 0.45359237D;

    public Double get(double number) {
        return BigDecimal.valueOf(number * RATIO_POUND_TO_KILO)
                .setScale(PRECISION, RoundingMode.HALF_UP)
                .doubleValue();
    }
}

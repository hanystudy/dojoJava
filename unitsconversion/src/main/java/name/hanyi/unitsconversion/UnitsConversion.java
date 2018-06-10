package name.hanyi.unitsconversion;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnitsConversion {
    public static final int PRECISION = 8;
    private UnitsTable unitsTable;
    private String sourceUnit;
    private String targetUnit;

    public UnitsConversion() {
        this.unitsTable = new UnitsTable();
    }

    public BigDecimal get(double number) {
        return BigDecimal.valueOf(calculate(number))
                .setScale(PRECISION, RoundingMode.HALF_UP);
    }

    private double calculate(double number) {
        if (this.unitsTable.validUnit(this.sourceUnit, this.targetUnit)) {
            UnitsRatio unitsRatio = unitsTable.getUnitRatio(this.sourceUnit);
            return unitsRatio.getRatio(this.targetUnit) * number / unitsRatio.getRatio(this.sourceUnit);
        }
        throw new RuntimeException();
    }

    public void setUnits(String sourceUnit, String targetUnit) {
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }
}

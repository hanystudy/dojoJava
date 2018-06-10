package name.hanyi.unitsconversion;

import java.util.HashMap;
import java.util.Map;

import static name.hanyi.unitsconversion.Ratio.RATIO_INCH_TO_CM;
import static name.hanyi.unitsconversion.Ratio.RATIO_POUND_TO_KILO;
import static name.hanyi.unitsconversion.Unit.*;

public class UnitsTable {
    public static final double FIXED_RATIO = 1.0D;
    private Map<String, UnitsRatio> unitsTableMap;

    public UnitsTable() {
        unitsTableMap = new HashMap<>();
        addUnitRatio(INCH.getName(), FIXED_RATIO, CM.getName(), RATIO_INCH_TO_CM.getRatio());
        addUnitRatio(POUND.getName(), FIXED_RATIO, KILOGRAM.getName(), RATIO_POUND_TO_KILO.getRatio());
    }

    private void addUnitRatio(String unit1, double ratio1, String unit2, double ratio2) {
        UnitsRatio unitsRatio = new UnitsRatio(unit1, ratio1, unit2, ratio2);
        unitsTableMap.put(unit1, unitsRatio);
        unitsTableMap.put(unit2, unitsRatio);
    }

    public boolean validUnit(String sourceUnit, String targetUnit) {
        UnitsRatio unitsRatio = this.unitsTableMap.get(sourceUnit);
        return unitsRatio != null && unitsRatio.containRatio(sourceUnit) && unitsRatio.containRatio(targetUnit);
    }

    public UnitsRatio getUnitRatio(String sourceUnit) {
        return unitsTableMap.get(sourceUnit);
    }
}

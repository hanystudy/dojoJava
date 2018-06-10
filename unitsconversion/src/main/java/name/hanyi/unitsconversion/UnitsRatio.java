package name.hanyi.unitsconversion;

import java.util.HashMap;
import java.util.Map;

public class UnitsRatio {
    private Map<String, Double> unitRatioMap;

    public UnitsRatio(String unitName1, double unit1, String unitName2, double unit2) {
        unitRatioMap = new HashMap<>();
        unitRatioMap.put(unitName1, unit1);
        unitRatioMap.put(unitName2, unit2);
    }

    public boolean containRatio(String unitName) {
        return this.unitRatioMap.containsKey(unitName);
    }

    public double getRatio(String unitName) {
        return this.unitRatioMap.get(unitName);
    }
}

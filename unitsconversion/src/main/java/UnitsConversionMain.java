import name.hanyi.unitsconversion.UnitsConversion;

public class UnitsConversionMain {

    static UnitsConversion unitsConversion = new UnitsConversion();

    public static void main(String[] args) {
        unitsConversion.setUnits("cm", "inch");
        System.out.println(unitsConversion.get(1D));
    }
}

public class RationalCalculator {

    public static RationalNumber add(RationalNumber r1, RationalNumber r2) {
        int slashIdx1 = r1.getNumber().indexOf('/');
        int slashIdx2 = r2.getNumber().indexOf('/');
        int num1 = Integer.parseInt(r1.getNumber().substring(0, slashIdx1));
        int num2 = Integer.parseInt(r2.getNumber().substring(0, slashIdx2));
        int den1 = Integer.parseInt(r1.getNumber().substring(slashIdx1 + 1));
        int den2 = Integer.parseInt(r2.getNumber().substring(slashIdx2 + 1));
        int newDen = den1 * den2;
        int newNum = den2 * num1 + den1 * num2;
        return new RationalNumber(newNum + "/" + newDen);
    }

    public RationalNumber subtract(RationalNumber r1, RationalNumber r2) {
        int slashIdx1 = r1.getNumber().indexOf('/');
        int slashIdx2 = r2.getNumber().indexOf('/');
        int num1 = Integer.parseInt(r1.getNumber().substring(0, slashIdx1));
        int num2 = Integer.parseInt(r2.getNumber().substring(0, slashIdx2));
        int den1 = Integer.parseInt(r1.getNumber().substring(slashIdx1 + 1));
        int den2 = Integer.parseInt(r2.getNumber().substring(slashIdx2 + 1));
        int newDen = den1 * den2;
        int newNum = den2 * num1 - den1 * num2;
        String result = newNum + "/" + newDen;
        System.out.println(result);
        return new RationalNumber(result);
    }
}

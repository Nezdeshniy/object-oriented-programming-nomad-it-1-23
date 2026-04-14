public class Main {
    public static void main(String[] args) {
        RationalNumber r1 = new RationalNumber("1/2");
        RationalNumber r2 = new RationalNumber("2/3");
        RationalCalculator calculator = new RationalCalculator();
        RationalNumber sum = calculator.add(r1, r2);
        RationalNumber diff = calculator.subtract(r1, r2);
        System.out.println(sum);
        System.out.println(diff);
    }
}

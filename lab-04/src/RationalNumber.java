public class RationalNumber {
    public static Integer count = 0;

    private String number;

    public RationalNumber(String number) {
        count++;
        validate(number);
        if (!number.contains("/")) {
            number += "/1";
        }
        this.number = number;
    }

    // Accepted formats: "3", "-3", "3/4", "-3/4", "3/-4", "-3/-4"
    private static void validate(String number) {
        if (number == null || number.isEmpty()) {
            throw new ArithmeticException("Rational number must not be null or empty");
        }
        if (!number.matches("-?\d+(/(-?\d+))?")) {
            throw new ArithmeticException("Invalid format for rational number: \"" + number + "\"");
        }
        int slashIdx = number.indexOf('/');
        if (slashIdx != -1) {
            int denominator = Integer.parseInt(number.substring(slashIdx + 1));
            if (denominator == 0) {
                throw new ArithmeticException("Denominator must not be zero");
            }
        }
    }

    @Override
    public String toString() { return number; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
}

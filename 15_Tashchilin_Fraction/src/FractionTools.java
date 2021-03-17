public class FractionTools {
    private FractionTools() {
    }

    /**
     *
     * @param number1
     * @param number2
     * @return Return the greatest common divider
     */
    public static int findGCD(int number1, int number2) {
        if (number2 == 0) return number1;
        return findGCD(number2, number1 % number2);
    }

    /**
     *
     * @param number1
     * @param number2
     * @return Return the least common denominator
     */
    public static int findLCD(int number1, int number2) {
        return (number1 * number2) / findGCD(number1, number2);
    }

    /**
     *
     * @param fr1 first fraction
     * @param fr2 second fraction
     * @return Return a new fraction as a sum of two fractions
     */
    public static Fraction sum(Fraction fr1, Fraction fr2) {
        fr1.reduce();
        fr2.reduce();
        if (fr1.getDenominator() == fr2.getDenominator()) {
            return new Fraction(fr1.getNumerator() + fr2.getNumerator(), fr1.getDenominator());
        } else {
            int lcd = findLCD(fr1.getDenominator(), fr2.getDenominator());
            return new Fraction(lcd / fr1.getDenominator() * fr1.getNumerator() + lcd / fr2.getDenominator() * fr2.getNumerator(), lcd);
        }
    }

    /**
     *
     * @param fr1 first fraction
     * @param fr2 second fraction
     * @return Return a new fraction as a difference between two fractions
     */
    public static Fraction diff(Fraction fr1, Fraction fr2) {
        fr1.reduce();
        fr2.reduce();
        if (fr1.getDenominator() == fr2.getDenominator()) {
            return new Fraction(fr1.getNumerator() - fr2.getNumerator(), fr1.getDenominator());
        } else {
            int lcd = findLCD(fr1.getDenominator(), fr2.getDenominator());
            return new Fraction(lcd / fr1.getDenominator() * fr1.getNumerator() - lcd / fr2.getDenominator() * fr2.getNumerator(), lcd);
        }
    }

    /**
     *
     * @param fr1 first fraction
     * @param fr2 second fraction
     * @return Return a new fraction as a multiplication of two fractions
     */
    public static Fraction multiplication(Fraction fr1, Fraction fr2) {
        return new Fraction(fr1.getNumerator() * fr2.getNumerator(), fr1.getDenominator() * fr2.getDenominator());
    }

    /**
     *
     * @param fr1 first fraction
     * @param fr2 second fraction
     * @return Return a new fraction as a division of two fractions
     */
    public static Fraction division(Fraction fr1, Fraction fr2) {
        return new Fraction(fr1.getNumerator() * fr2.getDenominator(), fr1.getDenominator() * fr2.getNumerator());
    }
}

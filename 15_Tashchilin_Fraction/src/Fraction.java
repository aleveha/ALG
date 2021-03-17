public class Fraction {
    private int numerator;
    private int denominator;

    // constructors
    /**
     *
     * @param numerator
     * @param denominator
     */
    public Fraction (int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    /**
     *
     * @param fraction
     */
    public Fraction (String fraction) {
        if (fraction.contains("/")) {
            this.numerator = Integer.parseInt(fraction.split("/")[0]);
            this.denominator = Integer.parseInt(fraction.split("/")[1]);
        } else {
            this.numerator = Integer.parseInt(fraction);
            this.denominator = 1;
        }
    }

    //setters
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // getters
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    @Override
    public String toString() {
        return String.format("%d%s", this.numerator, this.denominator == 1 ? "" : "/" + this.denominator);
    }

    //actions with fraction
    public void reduce() {
        int greatestCommonDivisor = FractionTools.findGCD(this.numerator, this.denominator);
        this.numerator /= greatestCommonDivisor;
        this.denominator /= greatestCommonDivisor;
    }
}

public class Expression {
    private Fraction fr1;
    private Fraction fr2;
    private char operator;

    //constructor
    public Expression(Fraction fr1, Fraction fr2, char operator) {
        this.fr1 = fr1;
        this.fr2 = fr2;
        this.operator = operator;
    }

    //getters
    public Fraction getFr1() {
        return new Fraction(fr1.getNumerator(), fr1.getDenominator());
    }
    public Fraction getFr2() {
        return new Fraction(fr2.getNumerator(), fr2.getDenominator());
    }
    public char getOperator() {
        return operator;
    }

    //methods
    public Fraction calculate() {
        return switch (getOperator()) {
            case '+' -> FractionTools.sum(getFr1(), getFr2());
            case '-' -> FractionTools.diff(getFr1(), getFr2());
            case '*' -> FractionTools.multiplication(getFr1(), getFr2());
            case '/' -> FractionTools.division(getFr1(), getFr2());
            default -> new Fraction(1, 1);
        };
    }
}

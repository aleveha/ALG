import java.util.Scanner;

public class FractionApp {
    public static void main(String[] args) {
        Fraction fr1 = new Fraction(5, 36);
        Fraction fr2 = new Fraction("3/7");

        check(fr1);
        check(fr2);
        check(fr1, fr2);

        System.out.println(new Expression(fr1, fr2, '+').calculate().toString());
    }

    public static void check(Fraction fr) {
        //get numerator
        System.out.println("Get numerator");
        System.out.println(fr.getNumerator());
        System.out.println();

        //get denominator
        System.out.println("Get denominator");
        System.out.println(fr.getDenominator());
        System.out.println();

        //get fraction as a string
        System.out.println("Get fraction as string");
        System.out.println(fr.toString());
        System.out.println();

        //reduce fraction
        System.out.println("Reduce fraction");
        fr.reduce();
        System.out.println(fr.toString());
        System.out.println();
    }

    public static void check(Fraction fr1, Fraction fr2) {
        //get sum of two fractions
        System.out.println("Get sum of two fractions");
        System.out.println(FractionTools.sum(fr1, fr2));
        System.out.println();

        //get difference of two fractions
        System.out.println("Get difference of two fractions");
        System.out.println(FractionTools.diff(fr1, fr2));
        System.out.println();

        //get multiplication of two fractions
        System.out.println("Get multiplication of two fractions");
        System.out.println(FractionTools.multiplication(fr1, fr2));
        System.out.println();

        //get division of two fractions
        System.out.println("Get division of two fractions");
        System.out.println(FractionTools.division(fr1, fr2));
        System.out.println();
    }
}

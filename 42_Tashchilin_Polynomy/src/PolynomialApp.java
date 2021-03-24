public class PolynomialApp {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new double[]{1, 2, 3, 4, 5});
        Polynomial p2 = new Polynomial(new double[]{4, 3, 3, 2, 2, 1});
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p1 + p2 = " + PolynomialTools.sum(p1, p2));
        System.out.println("p1 - p2 = " + PolynomialTools.difference(p1, p2));
    }
}

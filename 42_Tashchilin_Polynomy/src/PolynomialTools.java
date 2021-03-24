public class PolynomialTools {
    public static Polynomial sum(Polynomial p1, Polynomial p2) {
        return doSumOrDiff(p1, p2, '+');
    }

    public static Polynomial difference(Polynomial p1, Polynomial p2) {
        return doSumOrDiff(p1, p2, '-');
    }

    private static Polynomial doSumOrDiff(Polynomial p1, Polynomial p2, char separator) {
        Polynomial minPol = Math.min(p1.getDegree(), p2.getDegree()) == p1.getDegree() ? p1 : p2;
        Polynomial maxPol = Math.max(p1.getDegree(), p2.getDegree()) == p1.getDegree() ? p1 : p2;
        double[] ans = new double[maxPol.getDegree() + 1];

        for (int i = 0; i < ans.length; i++) {
            if (i < minPol.getDegree() + 1) {
                if (separator == '+') ans[i] = p1.getCoefficients()[i] + p2.getCoefficients()[i];
                else ans[i] = p1.getCoefficients()[i] - p2.getCoefficients()[i];
            } else {
                ans[i] = p2.getCoefficients()[i];
            }
        }
        return new Polynomial(ans);
    }
}

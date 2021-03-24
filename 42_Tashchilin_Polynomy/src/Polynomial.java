import java.text.DecimalFormat;
import java.util.Arrays;

public class Polynomial {
    // data
    private double[] coefficients;

    // constructors
    public Polynomial(double[] coefficients) {
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }
    public Polynomial(double coefficient) {
        this.coefficients = new double[] {coefficient};
    }
    public Polynomial(double firstCoefficients, double secondCoefficients) {
        this.coefficients = new double[] {firstCoefficients, secondCoefficients};
    }
    public Polynomial(double firstCoefficients, double secondCoefficients, double thirdCoefficient) {
        this.coefficients = new double[] {firstCoefficients, secondCoefficients, thirdCoefficient};
    }

    //getters
    public double[] getCoefficients() {
        return coefficients;
    }

    //methods
    public int getDegree() {
        return coefficients.length - 1;
    }
    public double getSpecificCoefficient(int index) {
        return coefficients[index];
    }
    public double getValue(double x) {
        return getValue(x, 0);
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < coefficients.length; i++) {
            String df = new DecimalFormat("##########.##########").format(coefficients[i]);
            ans.append(String.format(
                    "%sx^%d%s",
                    df.equals("1") ? "" : df,
                    i,
                    i == coefficients.length - 1 ? "" : " + "
            ));
        }
        return ans.toString();
    }
    public Polynomial getDerivative() {
        double[] derivative = new double[coefficients.length-1];
        for(int i = 1; i < coefficients.length; i++) {
            derivative[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(derivative);
    }

    private double getValue(double x, int aIndex) {
        if (aIndex == coefficients.length - 2) {
            return coefficients[aIndex] + (x * coefficients[aIndex + 1]);
        } else {
            return coefficients[aIndex] + (x * getValue(x, aIndex + 1));
        }
    }
}

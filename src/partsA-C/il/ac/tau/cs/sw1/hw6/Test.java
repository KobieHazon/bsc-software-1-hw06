package il.ac.tau.cs.sw1.hw6;

public class Test {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();

        printError(p1.getDegree() == 0, "the degree of p1 is 0");
        printError(p1.computePolynomial(3) == 0.0, "the value of p1 with x=3 is 0.0");

        double[] coefficients = new double[] {1.0, 2.0, 3.0};
        Polynomial p2 = new Polynomial(coefficients);

        printError(p2.computePolynomial(3) == 34.0, "the value of p2 with x=3 is 34.0");
        printError(p2.getCoefficient(1) == 2.0, "the coefficient of x is 2.0");

        Polynomial p3 = p2.multiply(2.0);

        printError(p2.getCoefficient(1) == 2.0, "the coefficient of x is 2.0");
        printError(p3.getCoefficient(1) == 4.0, "the coefficient of x is 4.0");

        Polynomial p4 = p2.adds(p3);
        printError(p4.getDegree() == 2, "the degree of p4 is 2");

        Polynomial p5 = p4.getFirstDerivation();
        printError(p5.getDegree() == 1, "the degree of p5 is 1");
    }

    public static void printError(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException("[ERROR] " + message);
        }
    }
}

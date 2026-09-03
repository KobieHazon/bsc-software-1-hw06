package il.ac.tau.cs.sw1.hw6;

import java.util.Arrays;

public class Polynomial {
    private double[] coefficients;

    public Polynomial() {
        this.coefficients = new double[] {0.0};
    }

    public Polynomial(double[] coefficients) {
        this.coefficients = Arrays.copyOf(coefficients, Math.max(1, coefficients.length));
        trimZero();
    }

    private void trimZero() {
        int maxDegree = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            if (this.coefficients[i] != 0.0) {
                maxDegree = i;
            }
        }
        this.coefficients = Arrays.copyOf(this.coefficients, maxDegree + 1);
    }

    public Polynomial adds(Polynomial polynomial) {
        int degree = Math.max(this.getDegree(), polynomial.getDegree());
        double[] result = new double[degree + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.getCoefficient(i) + polynomial.getCoefficient(i);
        }
        return new Polynomial(result);
    }

    public Polynomial multiply(double a) {
        if (a == 0.0) {
            return new Polynomial();
        }

        double[] result = new double[this.getDegree() + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.getCoefficient(i) * a;
        }
        return new Polynomial(result);
    }

    public int getDegree() {
        return this.coefficients.length - 1;
    }

    public double getCoefficient(int n) {
        if (n > this.getDegree()) {
            return 0.0;
        }
        return this.coefficients[n];
    }

    public void setCoefficient(int n, double c) {
        if (n > this.getDegree()) {
            this.coefficients = Arrays.copyOf(this.coefficients, n + 1);
        }
        this.coefficients[n] = c;
        trimZero();
    }

    public Polynomial getFirstDerivation() {
        if (this.getDegree() == 0) {
            return new Polynomial();
        }

        double[] result = new double[this.getDegree()];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.getCoefficient(i + 1) * (i + 1);
        }
        return new Polynomial(result);
    }

    public double computePolynomial(double x) {
        double result = 0.0;
        for (int i = this.getDegree(); i >= 0; i--) {
            result = result * x + this.getCoefficient(i);
        }
        return result;
    }

    public boolean isARoot(double x) {
        return this.computePolynomial(x) == 0.0;
    }
}

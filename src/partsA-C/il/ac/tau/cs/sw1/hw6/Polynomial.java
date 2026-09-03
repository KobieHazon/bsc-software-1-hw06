package il.ac.tau.cs.sw1.hw6;

public class Polynomial {
	
	private double[] coeffiecents;
	
	/*
	 * Creates the zero-polynomial with p(x) = 0 for all x.
	 */
	public Polynomial()
	{
		this.coeffiecents = new double[1];
		this.coeffiecents[0] = 0;
	} 
	
	private void trimZero() {
		int maxDegree = 0;
		for (int i = 0; i < this.coeffiecents.length; i++) {
			if (this.coeffiecents[i] != 0) {
				maxDegree = i;
			}
		}
		if (maxDegree != this.coeffiecents.length-1) {
			this.coeffiecents = java.util.Arrays.copyOfRange(this.coeffiecents, 0, maxDegree+1);
		}
	}
	
	/*
	 * Creates a new polynomial with the given coefficients.
	 */
	public Polynomial(double[] coefficients) 
	{
		this.coeffiecents = new double[coefficients.length];
		for (int i = 0; i < this.coeffiecents.length; i++) {
			this.coeffiecents[i] = coefficients[i];
		}
		this.trimZero();
	}
	/*
	 * Adds this polynomial to the given one
	 *  and returns the sum as a new polynomial.
	 */
	public Polynomial adds(Polynomial polynomial)
	{
		double[] coefficients;
		if (polynomial.getDegree() > this.getDegree()) {
			coefficients = new double[polynomial.getDegree() + 1];
			for (int i = 0; i < coefficients.length; i++) {
				if (i <= this.getDegree()) {
					coefficients[i] = this.getCoefficient(i);
				}
				coefficients[i] += polynomial.getCoefficient(i);
			}
		}
		else {
			coefficients = new double[this.getDegree() + 1];
			for (int i = 0; i < coefficients.length; i++) {
				if (i <= polynomial.getDegree()) {
					coefficients[i] = polynomial.getCoefficient(i);
				}
				coefficients[i] += this.getCoefficient(i);
			}
		}
		return new Polynomial(coefficients);
		
	}
	/*
	 * Multiplies a to this polynomial and returns 
	 * the result as a new polynomial.
	 * For example, if p = 2+3*x+4*x^2 and a = 2, then the result should be:
	 *  p' = 4+6*x+8*x^2
	 */
	public Polynomial multiply(double a)
	{
		if (a == 0) {
			return new Polynomial();
		}
		double[] co = new double[this.getDegree()+1];
		for (int i = 0; i < co.length; i++) {
			co[i] = this.getCoefficient(i)*a;
		}
		return new Polynomial(co);
		
	}
	/*
	 * Returns the degree (the largest exponent) of this polynomial.
	 */
	public int getDegree()
	{
		return this.coeffiecents.length-1;
	}
	/*
	 * Returns the coefficient of the variable x 
	 * with degree n in this polynomial.
	 */
	public double getCoefficient(int n)
	{
		if (n > this.getDegree()) {
			return 0;
		}
		return this.coeffiecents[n];
	}
	
	/*
	 * set the coefficient of the variable x 
	 * with degree n to c in this polynomial.
	 * If the degree of this polynomial < n, it means that that the coefficient of the variable x 
	 * with degree n was 0, and now it will change to c. 
	 */
	public void setCoefficient(int n, double c)
	{
		if (n <= this.getDegree()) {
			this.coeffiecents[n] = c;
		}
		else {
			double[] co = new double[n];
			for (int i = 0; i <= this.getDegree(); i++) {
				co[i] = this.getCoefficient(i);
			}
			co[n] = c;
			this.coeffiecents = co;
		}
		if (n == this.getDegree() && c == 0) {
			this.trimZero();
		}
	}
	
	/*
	 * Returns the first derivation of this polynomial.
	 *  The first derivation of a polynomial a0x0 + ...  + anxn is defined as 1 * a1x0 + ... + n anxn-1.
	
	 */
	public Polynomial getFirstDerivation()
	{
		double[] co = new double[this.getDegree()];
		for (int i = 0; i < co.length; i++) {
			co[i] = this.getCoefficient(i+1)*(i+1);
		}
		return new Polynomial(co);
	}
	
	/*
	 * given an assignment for the variable x,
	 * compute the polynomial value
	 */
	public double computePolynomial(double x)
	{
		double res = 0;
		for (int i = 0; i <= this.getDegree(); i++) {
			res += this.getCoefficient(i)*Math.pow(x, i);
		}
		return res;
	}
	
	/*
	 * given an assignment for the variable x,
	 * return true iff x is a root of this polynomial
	 */
	public boolean isARoot(double x)
	{
		return this.computePolynomial(x) == 0;
	}
	
}

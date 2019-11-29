package edu.wit.cs.comp1050;

@SuppressWarnings("serial")
public class ScientificCalculator extends BasicCalculator{
	public ScientificCalculator() {}

	/**
	 * This method returns log 10 of given number
	 * @param num
	 * @return log(num)
	 */
	public double log(double num) {
		return Math.log10(num);
	}
	
	/**
	 * This method takes the square root of a number
	 * @param num
	 * @return sqrt(num)
	 */
	public double sqrt(double num) {
		return Math.sqrt(num);
	}
	
	/**
	 * This method takes the sine of a given angle
	 * @param angle
	 * @return sin(angle)
	 */
	public double sin(double angle) {
		return Math.sin(angle);
	}
	
	/**
	 * This method takes the cosine of a given angle
	 * @param angle
	 * @return cos(angle)
	 */
	public double cos(double angle) {
		return Math.cos(angle);
	}
	
	/**
	 * This method finds e^x
	 * @param power
	 * @return e^x
	 */
	public double exp(double power) {
		return Math.exp(power);
	}
	
	/**
	 * This method finds base^power
	 * @param base
	 * @param power
	 * @return base^power
	 */
	public double pow(double base, double power) {
		return Math.pow(base, power);
	}
	
	public String solve(boolean scientific) {
		if(!scientific) {
			return super.solve();
		}
		return "Solution";
	}
}

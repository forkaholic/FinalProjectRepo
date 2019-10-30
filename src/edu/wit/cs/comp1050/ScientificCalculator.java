package edu.wit.cs.comp1050;

@SuppressWarnings("serial")
public class ScientificCalculator extends BasicCalculator{
	public ScientificCalculator() {}
	/*
	 * Title: Base-2 and Base-N logarithm calculation in Java
	 * Author: giannis
	 * Date: January 9, 2010
	 * Availability: https://www.giannistsakiris.com/2010/01/09/base-2-and-base-n-logarithm-calculation-in-java/ 
	 */
	public double log(double num, double base) {
		return Math.log10(num) / Math.log10(base);
	}
}

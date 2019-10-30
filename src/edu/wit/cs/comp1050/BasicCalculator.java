package edu.wit.cs.comp1050;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class BasicCalculator extends ArrayList<Calculation> {
	public BasicCalculator() {}
	
	/**
	 * This class adds two numbers together.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return sum
	 */
	public double add(double num1, double num2) {
		return num1 + num2;	
	}
	
	/**
	 * This class subtracts the second number from the first.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return difference
	 */
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	/**
	 * This class multiplies two numbers together.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return product
	 */
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	/**
	 * This class divides the first number by the second, but checks if the second is zero before dividing. This class also must be return type Double instead of primitive type double, as the primitive cannot be returned as null.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return either quotient or null
	 */
	public Double divide(double num1, double num2) {
		return (num2 != 0) ? (num1 / num2) : null;
	}
	
	public void start() {
		
	}
}

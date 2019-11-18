package edu.wit.cs.comp1050;
import java.util.ArrayList;
//Late as Always
@SuppressWarnings("serial")
public class BasicCalculator {
	
	private ArrayList<String> array; 
	
	public BasicCalculator() {
		array = new ArrayList<>(10);
	}
	
	/**
	 * This method adds two numbers together.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return sum
	 */
	public double add(double num1, double num2) {
		return num1 + num2;	
	}
	
	/**
	 * This method subtracts the second number from the first.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return difference
	 */
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	/**
	 * This method multiplies two numbers together.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return product
	 */
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	/**
	 * This method divides the first number by the second, but checks if the second is zero before dividing. This class also must be return type Double instead of primitive type double, as the primitive cannot be returned as null.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return either quotient or null
	 */
	public Double divide(double num1, double num2) {
		return (num2 != 0) ? (num1 / num2) : null;
	}
	
	/**
	 * This method saves the result of the previous calculation.
	 * @param num lastResult
	 */
	public void setResult(String calc) {
		this.array.add(calc);
	}
	
	/**
	 * This method sets lastResult as the previous calculation's value.
	 * @return lastResult
	 */
	public String getResult() {
		return this.array.size() != 0 ? this.array.get(this.array.size()) : null;
	}
	 
	/**
	  * This method solves any given calculation unless is violates a rule given by the functions or is missing parenthesis.
	  * @return solution
	  */
	public String solve() {
		return "solution";
	}
	
	/**
	 * This method returns a clone of the calculations array
	 * @return size
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> getArr() {
		ArrayList<String> clone = (ArrayList<String>) array.clone();
		return clone;
	}
	
	/**
	 * This method removes the first String in the array
	 */
	public void removeFirst() {
		array.remove(0);
	}
}

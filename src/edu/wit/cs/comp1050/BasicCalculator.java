package edu.wit.cs.comp1050;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
	public static double add(double num1, double num2) {
		return num1 + num2;	
	}
	
	/**
	 * This method subtracts the second number from the first.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return difference
	 */
	public static double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	/**
	 * This method multiplies two numbers together.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return product
	 */
	public static double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	/**
	 * This method divides the first number by the second, but checks if the second is zero before dividing. This class also must be return type Double instead of primitive type double, as the primitive cannot be returned as null.
	 * @param num1 left hand number
	 * @param num2 right hand number
	 * @return either quotient or null
	 */
	public static Double divide(double num1, double num2) {
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
		return this.array.size() != 0 ? this.array.get(this.array.size() - 1) : null;
	}
	 
	/**
	  * This method solves any given calculation unless is violates a rule given by the functions or has unbalanced parenthesis.
	  * @return solution
	  */
	public String solve() {
		try {	
			String[] strings = this.getResult().split(" ");
			Stack<String> operands = new Stack<>();
			//Stack for all symbols
			Stack<String> operators = new Stack<>();
			for(int i = 0; i < strings.length; i++) {
				if(strings[i].equals("+") || strings[i].equals("-")){
					operators.push(strings[i]);
				}
				else if(strings[i].equals("*") || strings[i].equals("/")) {
					i++;
					operands.push(strings[i]);
					if(strings[i - 1].equals("*")) {
						//Removes and multiplies the two most recent numbers found and pushes the result to the stack (order doesn't matter for multiplication)
						Double d2 = Double.parseDouble(operands.pop());
						Double d1 = Double.parseDouble(operands.pop());
						operands.push(Double.toString(multiply(d1, d2)));
					}
					else {
						Double d2 = Double.parseDouble(operands.pop());
						Double d1 = Double.parseDouble(operands.pop());
						Double d = divide(d1, d2);
						if(d == null) {
							return "Error - Divided by 0.";
						}
						operands.push(Double.toString(d));
					}
					System.out.println(operands.peek());
				}
				else {
					operands.push(strings[i]);
				}
			}

			Stack<String> newOperators = new Stack<>();
			Stack<String> newOperands = new Stack<>();
			while(!operators.isEmpty()) {
				//Reverses the order so that operations are done from left to right
				newOperators.push(operators.pop());
			}
			while(!operands.isEmpty()) {
				//Reverses order
				newOperands.push(operands.pop());
			}
			while(!newOperators.isEmpty()) {
				String op = newOperators.pop();
				Double d1 = Double.parseDouble(newOperands.pop());
				Double d2 = Double.parseDouble(newOperands.pop());
				if(op.equals("+")) {
					newOperands.push(Double.toString(add(d1, d2)));
				}
				else {
					newOperands.push(Double.toString(subtract(d1, d2)));
				}
			}
			String d = newOperands.pop();
			//Separates double answers from ints
			//Prevents negatives from being registered as integers as all - < 0
			if(Math.abs(Double.parseDouble(d) - Integer.parseInt(d.substring(0,d.indexOf(".")))) > 0) {
				return d;
			}
			return d.substring(0, d.indexOf("."));
		} catch(Exception e) {return "Error - Invalid equation.";} 
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

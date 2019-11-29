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
		return this.array.size() != 0 ? this.array.get(this.array.size() - 1) : null;
	}
	 
	/**
	  * This method solves any given calculation unless is violates a rule given by the functions or has unbalanced parenthesis.
	  * @return solution
	  */
	public String solve() {
		try {
			String temp = this.getResult();
			StringBuilder tEquation = new StringBuilder();
			for(int i = 0; i < temp.length(); i++) {
				char c = temp.charAt(i);
				if(c == '+' || c == '-' || c == '*' || c == '/') {
					tEquation.append(" ");
					tEquation.append(c);
					tEquation.append(" ");
				}
				else {
					tEquation.append(c);
				}
			}
			
			String[] strings = tEquation.toString().split(" ");
			if(strings.length == 1) {
				try {
					return Double.toString(Double.parseDouble(strings[0]));
				} catch(Exception e) {return "Error - No numbers entered.";}
			}
			//Stack for all numbers
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
				}
				else {
					operands.push(strings[i]);
					System.out.println(strings[0]);
				}
				
			}
			
			while(!operators.isEmpty()) {
				String op = operators.pop();
				Double d2 = Double.parseDouble(operands.pop());
				Double d1 = Double.parseDouble(operands.pop());
				if(op.equals("+")) {
					operands.push(Double.toString(add(d1, d2)));
				}
				else {
					operands.push(Double.toString(subtract(d1, d2)));
				}
			}
			return operands.pop();
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

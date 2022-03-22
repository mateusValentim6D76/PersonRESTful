package br.com.erudio.restwithspringboot.math;

public class SimpleMath {

	private Double sumNumber(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}

	public Double sum(Double n1, Double n2) {
		return sumNumber(n1, n2);
	}

	private Double subNumber(Double firstNumber, Double secondNumber) {
		return firstNumber - secondNumber ;
	}
	
	public Double subtraction(Double n1, Double n2) {
		return subNumber(n1, n2);
	}
	
	private Double multi (Double firstNumber, Double secondNumber) {
		return firstNumber * secondNumber;
	}
	
	public Double multiplication(Double n1, Double n2) {
		return multi(n1, n2);
	}
	
	private Double divi (Double firstNumber, Double secondNumber) {
		return firstNumber / secondNumber;
	}
	
	public Double division(Double n1, Double n2 ) {
		return divi(n1, n2);
	}
	
	private Double sqrt (Double number) {
		return (Double) Math.sqrt(number);
	}
	
	public Double squareRoot(Double n) {
		return sqrt(n);
	}
	
	private Double avg (Double firstNumber, Double secondNumber) {
		return (firstNumber + secondNumber) / 2;
	}
	
	public Double average(Double n1, Double n2) {
		return avg(n1, n2);
	}
}

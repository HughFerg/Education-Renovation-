package Perceptrons;

public class Perceptron {
	double weight = 1;
	double value = 0; // weights * inputs
	String inputName;
	
	public Perceptron (String inputName, double weight, double value)
	{
		this.inputName = inputName;
		this.weight = weight;
		this.value = value;
	}
	
	void setWeight(double t) { // default weight of 1
		weight = t;
	}

	void setName(String name)
	{
		inputName = name;
	}

	void setValue(double inputValue)
	{
		value = inputValue;
	}
}

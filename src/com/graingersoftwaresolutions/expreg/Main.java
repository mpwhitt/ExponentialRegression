package com.graingersoftwaresolutions.expreg;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Enter some weights and prices to use for an example
		String[] weights = {"318","371","435","460","517","582","627","662","685","658","702","780","805"};
		String[] prices = {"175.48","172.08","170.04","158.44","143.36","139.12","141.64","138.79","150.00",
				"142.00","133.63","126.00","129.00"};
		//Create 2 array lists
		ArrayList<String> weightArray = new ArrayList<String>();
		ArrayList<String> priceArray = new ArrayList<String>();
		//Fill the arrayLists with the string arrays
		for (int i = 0; i < weights.length; i ++){
			weightArray.add(weights[i]);
			priceArray.add(prices[i]);
		}
		
		//Create the expReg object
		ExpReg expReg = new ExpReg();
		expReg.doTheWork(weightArray, priceArray);
		//Get the r and a values from the ExpReg class to use in the final equation.
	    double r = expReg.getR();
	    double a = expReg.getA();
	    
	    //Ask for weight input
	    System.out.println("Enter weight.");
	    
	    //Create scanner to read weight input.
	    Scanner scanner = new Scanner(System.in);
	    String weight = scanner.nextLine();
	    
	    //Calculate the price based on this weight and the previous arrays.  
	    double calfPriceAvg = a * Math.pow(r,Double.valueOf(weight));
	    
	    //Get the total price of this animal since the calfPriceAvg is cwt (price per hundred pounds);
	    double total = (calfPriceAvg / 100.0) * Integer.parseInt(weight);
	    
	    DecimalFormat formatter = new DecimalFormat("#0.00");
	    
	    System.out.println("An animal of this weight should bring $" + formatter.format(calfPriceAvg) + " cwt or $" +
	    		formatter.format(total) + " total.");
	    
	}
	
	
	
}

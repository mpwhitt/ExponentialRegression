package com.graingersoftwaresolutions.expreg;

import java.util.ArrayList;

public class ExpReg {
	
	/**
	 * @param args
	 * This is a class that uses exponential regression to calculate an estimated value of an animal when passed certain parameters.
	 * In this case, 2 arrays are passed:  weightArray and priceArray.  These 2 arrays represent similar animals in the same
	 * category.
	 * 
	 * In order to find the exponential curve, (y = Ar^x), you need to find the linear regression of the values (x, log(y)), 
	 * where the x values are the weights and the y values are the prices.  
	 * 
	 * To find linear regression, you need the slope and y-intercept.
	 * 
	 * To find the slope:    (n = number of points)    Slope = n * Sum(xy) - Sum(x) * Sum(y)
	 * 												   _____________________________________
	 * 													    n * Sum(x^2) - (Sum(x))^2
	 * 
	 * 
	 * To find the y-intercept: ( m = slope )                Sum(y) - m * Sum(x)
	 *                                                       ___________________
	 *                                                                n
	 *                          
	 * Once the slope and y intercept are found, you can
	 * 
	 * */

	double bigA;
	double rValue;
	
	protected double doTheWork(ArrayList<String> weightArray, ArrayList<String> priceArray){
		double slope = 0;
		rValue = 0;
		ArrayList<String> logArray = getLogYArray(priceArray);
		double n = weightArray.size();
		double a = getSumXTimesY(weightArray, logArray);
		double b = getSumX(weightArray);
		double c = getSumY(logArray);
		double d = getSumXSquared(weightArray);
		double e = getSquaredSumX(weightArray);
		
		slope = ((n*a) - (b*c)) / ((n*d) - e);
		double bValue = (getSumY(logArray) - slope * (getSumX(weightArray))) / n;
		
		bigA = Math.pow(10, bValue);
		rValue = Math.pow(10, slope);
		return slope;
	}

	protected ArrayList<String> getLogYArray(ArrayList<String> priceArray){
		ArrayList<String> logArray = new ArrayList<String>();
		for (int i = 0; i < priceArray.size(); i ++){
			double doubleTemp = Double.valueOf(priceArray.get(i));
			doubleTemp = Math.log10(doubleTemp);
			logArray.add(String.valueOf(doubleTemp));
		}
		return logArray;
	}
	
	protected double getSumXTimesY(ArrayList<String> weightArray, ArrayList<String> priceArray){
		double sumXTimesY = 0;
		for (int i = 0; i < weightArray.size(); i ++){
			sumXTimesY += Double.valueOf(weightArray.get(i)) * Double.valueOf(priceArray.get(i));
		}
		return sumXTimesY;
	}
	
	protected double getSumX(ArrayList<String> weightArray){
		double sumX = 0;
		for (int i = 0; i < weightArray.size(); i ++){
			sumX += Double.valueOf(weightArray.get(i));
		}
		return sumX;
	}
	
	protected double getSumY(ArrayList<String> logPriceArray){
		double sumY = 0;
		for (int i = 0; i < logPriceArray.size(); i ++){
			sumY += Double.valueOf(logPriceArray.get(i));
		}
		return sumY;
		
	}
	
	protected double getSquaredSumX(ArrayList<String> weightArray){
		double squaredSumX = 0;
		double sum = 0;
		for (int i = 0; i < weightArray.size(); i ++){
			sum += Double.valueOf(weightArray.get(i));
		}
		squaredSumX = sum * sum;
		return squaredSumX;
	}
	
	protected double getSumXSquared(ArrayList<String> weightArray){
		double sumXSquared = 0;
		for (int i = 0; i < weightArray.size(); i ++){
			sumXSquared += Math.pow(Double.valueOf(weightArray.get(i)), 2);
		}
		return sumXSquared;
	}
	
	
	
	protected double getA(){
		return bigA;
	}
	protected double getR(){
		return rValue;
	}


}

package com.promineotech;

import java.util.Random;

public class TestDemo {
	/**
	 * 
	 * @param a
	 * @param b
	 * @return sum of both numbers if they are positive. Otherwise it will throw exception
	 */
	public int addPositive(int a, int b) {
		if ((a > 0) && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}

	}
	/**
	 * 
	 * @return random number between 1 and 10
	 */
	int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
    
	/**
	 * 
	 * @return multiplies the random number provided by getRandomInt by itself
	 */
    public int randomNumberSquared() {
        int number = getRandomInt();
        return number * number;
    }

    /**
     * 
     * @return takes random number and doubles it. 
     */

    public int doubleRandomNumber() {
    	int number = getRandomInt();
    		return number * 2;
   
    }
	
}
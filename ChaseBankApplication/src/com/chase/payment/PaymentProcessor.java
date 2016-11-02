package com.chase.payment;

import java.util.Random;

public class PaymentProcessor {
	
	public String ping() {
		return "ALIVE";
	}
	
	public String processPayment(CreditCardPayment creditCardPayment) {
    	// Generate a random number for the confirmation code
		/*
    	int max = 9999999;
    	int min = 0;
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(max - min + 1) + min;
    	*/
		int confirmationNumber = 200;
		String confirmationMessage = "Chase Received Your Payment! Confirmation Number = " + confirmationNumber + ".\n";
    	System.out.println(confirmationMessage);
    	return String.valueOf(confirmationNumber);		
	}
}
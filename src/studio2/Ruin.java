package studio2;

import java.util.Scanner;


public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("How much money do you want to start with?");
		double startAmount = in.nextDouble();
		System.out.println("What do you want your win probability to be?");
		double winChance = in.nextDouble();
		System.out.println("How much money do you want to leave with today?");
		double winLimit = in.nextDouble();
		System.out.println("How many days do you want to simulate?");
		int totalSimulations = in.nextInt();
		boolean win; 
		int plays = 0;
		double amount = startAmount;
		int losses = 0; 
		double ruinRate = 0;
		double expectedRuinRate;
		double a = (1-winChance)/(winChance);
		String day;
		
		if(winChance==0.5) {
			expectedRuinRate = 1-(startAmount/winLimit);
		}
		else {
			expectedRuinRate = (Math.pow(a,startAmount)-Math.pow(a,winLimit))/(1-Math.pow(a,winLimit));
		}
		
		
		for(int i = 0; i < totalSimulations; i++){
			plays = 0;
		while(amount>0&&amount<winLimit) {
			win = Math.random()<winChance;
			if(win) {
				amount++;
				//System.out.println("You won this round!");
			}
			else {
				amount--;
				//System.out.println("You lost this round!");
			}
			//System.out.println("startAmount Remaining:" + startAmount);
			plays++;
			 
		}
		
		if(amount==winLimit) 
		{
			day = "WIN";
			
		}
		else 
		{
			day = "LOSE";
			losses++;
		}
		
		System.out.println("Simulation "+(i+1) + ": " +plays+" "+day);
		
		
		
		
		amount = startAmount;
		
		}
		//System.out.println(losses);
		ruinRate = ((double)losses)/totalSimulations;
		ruinRate = Math.round(ruinRate*100)/100;
		System.out.println("Losses: "+losses+" Simulations: "+totalSimulations);
		System.out.println("Ruin rate from Simulation: " +ruinRate+" Expected Ruin Rate: "+expectedRuinRate);
	}
}







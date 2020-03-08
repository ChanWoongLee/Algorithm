package practice;

import java.util.Scanner;

public class NumberCycle {

	public static void main(String[] args) {
		Scanner name = new Scanner(System.in);
		int number = name.nextInt();
		int coin = 1;
		while(true) {
			int ten = number/10;
			int one = number%10;
			int newNumber = ten+one;
			int realNumber = one*10 + newNumber%10;
			if(realNumber==number) { 
				System.out.println(coin);
				break;
			}
			coin++;
		}
	
	}
}

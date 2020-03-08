package practice;

import java.util.Scanner;

public class HoneyHouse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 1;
		for (int i = 1; i < 1752176; i++) { 
			sum = sum + 6*i;
			if(N==1) {
				System.out.println("1");
				break;
			}
			if(N>(sum-6*i) && N<=sum){
				System.out.println(i+1);
				break;
			}
		}
	}
}

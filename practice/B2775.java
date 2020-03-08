package practice;

import java.util.Scanner;

public class B2775 {
	static int[][] house = new int[15][15];
	static int value =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int a = sc.nextInt();

		for (int i = 1; i <= 14; i++) {
			house[0][i]=i;
		}
		
		for (int i = 1; i <= a; i++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			System.out.println(houseF(b,c));
		}
	}
	
	public static int houseF(int a, int b) {
		if(a==0)
			return b;
		//if(house[a][b]!=0)
		//	return house[a][b];
		
		for(int i = 1; i<=b; i++)  
			house[a][b] += houseF(a-1,i);
		return house[a][b];
		
	}
}

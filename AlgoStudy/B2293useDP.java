package AlgoStudy;

import java.util.Scanner;

public class B2293useDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[N];
		int[] money = new int[k+1];
		
		for(int i = 0; i < N; i++) {
			int coinPrice = sc.nextInt();
			coin[i]=coinPrice;
			money[coinPrice]=1;
		}
		
		for(int i = 0; i <= k; i++) {
			for(int j = 0; j < N; j++) {
				if (i-coin[j]>0) {
					money[i]=money[i-coin[j]]+money[i];
				}
			}
		}
		System.out.println(money[k]);
	}
}

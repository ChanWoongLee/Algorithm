package AlgoStudy;

import java.util.Scanner;

public class B2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = N; i > 0; i--) {
			for (int j = N-i; j >0; j--) {
				System.out.print("  ");
			}
			for (int j = i; j > 0 ; j--) {
				System.out.print("£ª");
			}
			System.out.println();
		}
	}
}

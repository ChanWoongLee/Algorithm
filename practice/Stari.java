package practice;

import java.util.Scanner;

public class Stari {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		
		for (int i = 0; i < height; i++) {
			for (int j = height-1-i; j <=0 ; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <=(2*i+1) ; j++) {
				System.out.print("¡Ù");
			}
			System.out.println();
		}
	}
}

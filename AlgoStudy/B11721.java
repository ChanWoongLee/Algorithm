package AlgoStudy;

import java.util.Scanner;

public class B11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		char[] charArray = new char[line.length()];
		charArray=line.toCharArray();
		int N=9;
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
			if (i==N) {
				System.out.println();
				N+=10;
			}
		}
		System.out.print(" ");
	}
}

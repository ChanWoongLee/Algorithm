package AlgoStudy;

import java.util.Scanner;

public class B11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result=0;
		String NumLine =  sc.next();
		for (int i = 0; i < NumLine.length(); i++) {
			result+=Character.getNumericValue(NumLine.charAt(i));
		}
		System.out.println(result);
	}
}
	
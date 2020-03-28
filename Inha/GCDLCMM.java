package Samsung;

import java.util.Scanner;

public class GCDLCMM {
	private static int GreatestCommonDivisor(int a, int b) {
		if (b == 0)
			return a;
		return GreatestCommonDivisor(b, a % b);
	}
	private static int LeastCommonMultiple(int a, int b) {
		return (a * b) / GreatestCommonDivisor(a, b);
	}

	public static void main(String[] args) {
		int a, b;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		if (a < b) {
			int temp = b;
			b = a;
			a = temp;
		}
		scan.close();
		System.out.println(GreatestCommonDivisor(a, b));
		System.out.println(LeastCommonMultiple(a, b));
	}
}
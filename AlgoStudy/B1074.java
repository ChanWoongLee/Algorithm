package AlgoStudy;

import java.util.Scanner;

public class B1074 {
	static long[][] display;
	static int N, R, C;
	static int count = 0;
	public static void divide(int startX, int startY, int length) {
		if (length == 1 && ((startX == R) && (startY == C))) {
			System.out.println(count);
			System.exit(0);
		}
		else if(length == 1){
			count++;
			return;
		}
			divide(startX, startY, length / 2);
			divide(startX, startY + length / 2, length / 2);
			divide(startX + length / 2, startY, length / 2);
			divide(startX + length / 2, startY + length / 2, length / 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		divide(0, 0, (int)Math.pow(2, N));

	}

}

package AlgoStudy;

import java.math.BigInteger;
import java.util.Scanner;

public class B10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger result =BigInteger.valueOf(1);
		for(int i = 1; i <= N; i++) {
			result.multiply(BigInteger.valueOf(i));
		}
		System.out.println(result);
	}
}

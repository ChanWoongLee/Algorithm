package Inha.forpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GCDLCM {
	private static int GreatestCommonDivisor(int a, int b) {
		if (b == 0)
			return a;
		return GreatestCommonDivisor(b, a % b);
	}

	private static int LeastCommonMultiple(int a, int b) {
		return (a * b) / GreatestCommonDivisor(a, b);
	}

	public static void main(String[] args) throws IOException {
		int a, b;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		if (a < b) {
			int temp = b;
			b = a;
			a = temp;
		}
		System.out.println(GreatestCommonDivisor(a, b));
		System.out.println(LeastCommonMultiple(a, b));
	}
}
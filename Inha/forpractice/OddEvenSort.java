package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(bf.readLine());
		}
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < (n / 2); j++) {
					if (num[2 * j] > num[2 * j + 1]) {
						temp = num[2 * j];
						num[2 * j] = num[2 * j + 1];
						num[2 * j + 1] = temp;
					}
				}
			} else {
				if (n % 2 == 0) {
					for (int j = 1; j < (n / 2); j++) {
						if (num[2 * j - 1] > num[2 * j]) {
							temp = num[2 * j - 1];
							num[2 * j - 1] = num[2 * j];
							num[2 * j] = temp;
						}
					}
				} else {
					for (int j = 1; j <= (n / 2); j++) {
						if (num[2 * j - 1] > num[2 * j]) {
							temp = num[2 * j - 1];
							num[2 * j - 1] = num[2 * j];
							num[2 * j] = temp;
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(num[i]);
		}
	}

}

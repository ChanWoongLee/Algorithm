package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Insertion {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		// st = new StringTokenizer(bf.readLine());
		// for (int i = 0; i < n; i++) {
		// num[i] = Integer.parseInt(st.nextToken());
		// } 1 3 5 6 한줄 유형
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			int temp = num[i];
			for (int j = i - 1; j >= 0; j--) {
				if (num[j] > temp)
					num[j + 1] = num[j];
				else {
					num[j + 1] = temp;
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(num[i] + " ");
		}
	}

}

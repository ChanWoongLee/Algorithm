package SummerCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javafx.scene.SceneAntialiasing;

public class B7453 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		int[] AC = new int[n * n];
		int[] BD = new int[n * n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AC[i * n + j] = A[i] + C[j];
				BD[i * n + j] = B[i] + D[j];
			}
		}
		Arrays.sort(AC);
		Arrays.sort(BD);
		int start = 0;
		int end = n * n - 1;
		long result = 0;
		while (true) {
			if (start >= n * n || end < 0)
				break;
			int startCnt = 0;
			int endCnt = 0;
			int ACvalue = AC[start];
			int BDvalue = BD[end];
			int sum = ACvalue + BDvalue;
			if (sum == 0) {
				while (start < AC.length && AC[start] == ACvalue) {
					start++;
					startCnt++;
				}
				while (end >= 0 && BD[end] == BDvalue) {
					end--;
					endCnt++;
				}
				result += startCnt * endCnt;
			} else if (sum < 0)
				start++;
			else
				end--;
		}
		System.out.println(result);
	}

}

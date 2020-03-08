package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2817 {
	static int[] num;
	static int goal;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			goal = Integer.parseInt(st.nextToken());
			num = new int[size];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			recur(0,0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	static public void recur(int n, int sum) {
		if (sum == goal) {
			result++;
			return;
		}
		if (n == num.length)
			return;

		recur(n + 1, sum + num[n]);
		recur(n + 1, sum);
	}
}

package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B10165 {
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][N];
		st = new StringTokenizer(bf.readLine());
		int line = Integer.parseInt(st.nextToken());
		arr = new ArrayList();
		for (int i = 1; i <= line; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (dp[start][end] == 0) {
				visit(dp, start, end, i);
			}
			else {
				arr.add(i);
			}
		}
		for (int i = 1; i <= line; i++) {
			if (!arr.contains(i))
				System.out.print(i + " ");
		}
	}

	static void visit(int[][] dp, int start, int end, int line) {
		int length = 0;
		if (start > end)
			length = 10 - (start - end);
		else
			length = end - start;
		int init_s = start;
		int init_e = end;
		boolean find = false;
		for (int i = length; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (dp[start][end] != 0 && !find) {
					System.out.println(start+ " "+ end + " line: "+ line + " »èÁ¦:"+ dp[start][end]);
					arr.add(dp[start][end]);
					find = true;
				}
				dp[start][end] = line;
				start = next(start);
			}
			start = init_s;
			end = back(end);
		}
	}

	static int back(int n) {
		n = n - 1;
		if (n == -1)
			return 9;
		return n;
	}

	static int next(int n) {
		n = n + 1;
		if (n == 10)
			return 0;
		return n;
	}
}

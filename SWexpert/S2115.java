package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2115 {
	// 4 : 5분 ~ 4 : 10분 문제해석
	// 5: 4 분 디버깅 + 실수 = 1시간컷
	static int N, M, C;
	static int[][] map;
	static int[][] worker;
	static boolean[] get;
	static int result;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			worker = new int[2][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			recur(0, 0);
			System.out.println("#" + t + " " + result);
		}

	}

	static int select(int[] num) {
		max = 0;
		for (int i = 1; i <= M - 1; i++) {
			int sum = 0;
			get = new boolean[M];
			recur2(0, 0, i, num);
		}
		return max;
	}

	static void recur2(int index, int cnt, int num, int[] ar) {
		if (cnt == num) {
			int sum = 0;
			int square_sum = 0;
			for (int j = 0; j < M; j++) {
				if (get[j]) {
					sum += ar[j];
					square_sum += ar[j] * ar[j];
				}
			}
			if (sum <= C)
				max = max < square_sum ? square_sum : max;
			return;
		}
		if (index == M)
			return;

		get[index] = true;
		recur2(index + 1, cnt + 1, num, ar);
		get[index] = false;
		recur2(index + 1, cnt, num, ar);
	}

	static void solve() {
		int[] A = worker[0];
		int[] B = worker[1];
		int sum = 0;
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		if (sum > C)
			res += select(A);
		else {
			for (int i : A)
				res += i * i;
		}

		sum = 0;
		for (int i = 0; i < B.length; i++) {
			sum += B[i];
		}
		if (sum > C) {
			res += select(B);
		} else {
			for (int i : B)
				res += i * i;
		}
		result = result < res ? res : result;
	}

	static void recur(int index, int cnt) {
		if (cnt == 2) {
			solve();
			return;
		}
		if (index == N * N)
			return;
		int r = index / N;
		int c = index % N;
		if (c + M - 1 >= N) {
			recur(index + 1, cnt);
			return;
		}
		for (int i = 0; i < M; i++)
			worker[cnt][i] = map[r][c++];

		recur(index + M, cnt + 1);
		recur(index + 1, cnt);
	}
}

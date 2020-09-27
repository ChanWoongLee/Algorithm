package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S2112another {
	// 6 :35Ω√¿€
	static int D, W, K, result;
	static int map[][];
	static int[] continum;
	static int[] maxcontinum;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			D = Integer.parseInt(st.nextToken());// N
			W = Integer.parseInt(st.nextToken());// W
			K = Integer.parseInt(st.nextToken());// N
			result = K;
			map = new int[D][W];
			continum = new int[W];
			maxcontinum = new int[W];
			Arrays.fill(continum, 1);
			Arrays.fill(maxcontinum, 1);
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
			System.out.println("#" + test_case + " " + result);
		}
	}
	static void dfs(int numinject, int depth) {
		
	}

}

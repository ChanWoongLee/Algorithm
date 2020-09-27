package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S2112 {
	// 6 :35시작
	static int D, W, K, result;
	static int map[][];
	static ArrayList<Integer> ar = new ArrayList();
	static ArrayList<Integer> pannel_A = new ArrayList();
	static boolean finish;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = -1;
			finish = false;
			ar.clear();
			pannel_A.clear();
			st = new StringTokenizer(bf.readLine());
			D = Integer.parseInt(st.nextToken());// N
			W = Integer.parseInt(st.nextToken());// W
			K = Integer.parseInt(st.nextToken());// N
			map = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i <= K; i++) {
				johab(0, 0, i); // i개의 판을 고르겠다.
				if (result != -1)
					break;
			}
			// 위에서 못찾았으면 답은 K 임
			if (result == -1)
				result = K;
			System.out.println("#" + test_case + " " + result);
		}
	}

	static void johab(int index, int cnt, int num) {
		if (finish)
			return;
		if (cnt == num) {
			for (int i = 0; i <= num; i++) {
				selectA(0, 0, num, i); // num개 판 중에서 A로 바꿀 판을 i개 선택!!!
			}
			return;
		}
		if (index == D) // 의미 중요
			return;

		ar.add(index);
		johab(index + 1, cnt + 1, num);
		ar.remove(ar.size() - 1);
		johab(index + 1, cnt, num);
	}

	static void selectA(int index, int cnt, int num, int i) {

		if (finish)
			return;
		if (cnt == i) {
			if (solve()) {
				result = ar.size();
				finish = true;
			}
			return;
		}
		if (index == num)
			return;

		pannel_A.add(index);
		selectA(index + 1, cnt + 1, num, i);
		pannel_A.remove(0);
		selectA(index + 1, cnt, num, i);
	}

	static boolean solve() {
		int[][] cmap = new int[D][W];
		for (int i = 0; i < D; i++)
			cmap[i] = Arrays.copyOf(map[i], W);

		for (int i = 0; i < ar.size(); i++) {
			if (pannel_A.contains(i)) {// 0 으로 바꾸기
				for (int width = 0; width < W; width++) {
					cmap[ar.get(i)][width] = 0;
				}
			} else {// 1로 바꾸기
				for (int width = 0; width < W; width++) {
					cmap[ar.get(i)][width] = 1;
				}
			}
		}

		for (int j = 0; j < W; j++) {
			for (int i = 0; i <= D - K; i++) {
				int target = cmap[i][j];
				boolean pass = true;
				for (int k = 1; k < K; k++) {
					if (cmap[i + k][j] != target) {
						pass = false;
						break;
					}
				}
				if (pass)
					break;
				if (i == D - K)
					return false;
			}
		}
		return true;

	}
}

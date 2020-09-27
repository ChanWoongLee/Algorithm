package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7 시 38분
public class B17825_re {
	static int[] dice = new int[10];
	static int[] temp = new int[10];
	static int[][] rule = new int[41][6];
	static int[][] input = { { 5, 21, 22, 23, 24, 30 }, { 21, 22, 23, 24, 30, 31 }, { 22, 23, 24, 30, 31, 20 },
			{ 23, 24, 30, 31, 20, 32 }, { 24, 30, 31, 20, 32, 32 }, { 10, 25, 26, 24, 30, 31 },
			{ 25, 26, 24, 30, 31, 20 }, { 26, 24, 30, 31, 20, 32 }, { 27, 28, 29, 24, 30, 31 },
			{ 28, 29, 24, 30, 31, 20 }, { 29, 24, 30, 31, 20, 32 }, { 30, 31, 20, 32, 32, 32 },
			{ 31, 20, 32, 32, 32, 32 }, { 15, 27, 28, 29, 24, 30 } };
	static int[] map = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 13, 16, 19, 25,
			22, 24, 28, 27, 26, 30, 35, 0 };
	static int result = 0;

	// 13 - 21
	// 26 - 24
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < input.length; i++) {
			for (int j = 1; j < 6; j++) {
				rule[input[i][0]][j] = input[i][j];
			}
		}
		recur(0);
		System.out.println(result);
	}

	static int game() {
		int res = 0;
		// temp 는 dice에 따라 움직일 말의 번호가 적혀있음요
		int[] player = new int[4];
		for (int i = 0; i < 10; i++) {
			int jump = dice[i];
			int p = temp[i];

			if (player[p] == 32)
				return -1;

			if (rule[player[p]][jump] == 0) {// 특수한경우가 아닐때
				if (player[p] + jump >= 21) {
					player[p] = 32;
					continue;
				} else {
					player[p] += jump;
					for (int same = 0; same < 4; same++) {
						if (same != p && player[same] == player[p])
							return -1;
					}
					res += map[player[p]];
//					System.out.println(map[player[p]]);
				}
			} else {// 특수한 경우
				if (rule[player[p]][jump] == 32) {
					player[p] = 32;
					continue;
				}
				player[p] = rule[player[p]][jump];
				for (int same = 0; same < 4; same++) {
					if (same != p && player[same] == player[p])
						return -1;
				}
				res += map[player[p]];
//				System.out.println(map[player[p]]);
			}
		}

		return res;
	}

	static void recur(int index) {
		if (index == 10) {
//			for (int ii : temp) {
//				System.out.print(ii + " ");
//			}
//			System.out.println();
			int res = game();
//			System.out.println(res);
			if (res != -1)
				result = res > result ? res : result;
			return;
		}
		for (int i = 0; i < 4; i++) {
			temp[index] = i;
			recur(index + 1);
		}
	}
}

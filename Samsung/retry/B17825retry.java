package Samsung.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import AlgoStudy.codeForce1;

public class B17825retry {
	static int[][] map = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, -1 },
			{ 10, 13, 16, 19, 25, 30, 35, 40, -1 }, { 20, 22, 24, 25, 30, 35, 40, -1 },
			{ 30, 28, 27, 26, 25, 30, 35, 40, -1 } };
	static int[] value = new int[10];
	static int[] user = new int[4];
	static int[] userState = new int[4];
	static int res = 0;
	static int[] move = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < value.length; i++) {
			value[i] = Integer.valueOf(st.nextToken());
		}
		game(0);
		System.out.println(res);
	}

	static void game(int cnt) {
		if (cnt == 10) {
			int result = 0;
			user = new int[4];
			userState = new int[4];
			for (int i = 0; i < 10; i++) {
				int dice = value[i];
				int u = move[i];

				if (map[userState[u]][user[u]] == -1)
					return;
				// 이미 도착에 있으면 안되는 경우의 수임
				if (userState[u] == 0 && user[u] + dice >= 21) {
					user[u] = 21;
					continue;
				} else if (userState[u] == 2 && user[u] + dice >= 7) {
					user[u] = 7;
					continue;
				} else if (userState[u] == 1 && user[u] + dice >= 8) {
					user[u] = 8;
					continue;
				} else if (userState[u] == 3 && user[u] + dice >= 8) {
					user[u] = 8;
					continue;
				}
				// 도착을 초과나 도착오면 도착으로 이동
				if (userState[u] == 0 && user[u] + dice == 5) {
					userState[u] = 1;
					user[u] = 0;
					result += map[1][0];
				} else if (userState[u] == 0 && user[u] + dice == 10) {
					userState[u] = 2;
					user[u] = 0;
					result += map[2][0];
				} else if (userState[u] == 0 && user[u] + dice == 15) {
					userState[u] = 3;
					user[u] = 0;
					result += map[3][0];
				} // 특수 경로로 이동
				else {
					user[u] += dice;
					result += map[userState[u]][user[u]];
				}
				// 그냥 경로 이동

				for (int person = 0; person < 4; person++) {
					if (person == u)
						continue;
					if (map[userState[person]][user[person]] == -1)
						continue;
					if (map[userState[u]][user[u]] == 40 && map[userState[person]][user[person]] == 40)
						return;
					if (map[userState[u]][user[u]] == 35 && map[userState[person]][user[person]] == 35)
						return;
					if (map[userState[u]][user[u]] == 25 && map[userState[person]][user[person]] == 25)
						return;
					if (map[userState[u]][user[u]] == 30 && map[userState[person]][user[person]] == 30 &&  user[u]!=0&& user[person]!=0)
						return;
					if (user[u] == user[person] && userState[person] == userState[u])
						return;
				}
				// 중복검사 중복시 바로 컸@
			}
			res = result > res ? result : res;
			return;
		}

		for (int i = 0; i < 4; i++) {
			move[cnt] = i;
			game(cnt + 1);
		}
	}

}

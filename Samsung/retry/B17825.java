package Samsung;

import java.io.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import AlgoStudy.codeForce1;

public class B17825 {
	// 3 : 7 시작
	// stop 이 10-> 20 30

	static int[][] map = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
			{ 10, 13, 16, 19, 25, 30, 35, 40 }, { 20, 22, 24, 25, 30, 35, 40 }, { 30, 28, 27, 26, 25, 30, 35, 40 } };
	static boolean[] visit;
	static int[] move = new int[10];
	static int res = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < move.length; i++) {
			move[i] = Integer.valueOf(st.nextToken());
		}
		visit = new boolean[41];
		int[] user = new int[4];
		int[] userState = new int[4];
		dfs(0, 0, user, userState, 0);
		System.out.println(res);
	}

	static void dfs(int index, int result, int[] u, int[] us, int beforenum) {
		if (index == 10) {
			for (int k = 0; k < 4; k++) {
				System.out.print(u[k] + ", " + us[k] + "  ");
			}
			System.out.println(index);
			res = res < result ? result : res;
			return;
		}

		int temp = 0;
		for (int i = 0; i < 4; i++) {
			if (u[i] != 0 || us[i] != 0) {
				temp++;
			}
		}
		temp = temp == 4 ? 3 : temp;
		visit[beforenum] = false;
		int[] user = Arrays.copyOf(u, u.length);
		int[] userState = Arrays.copyOf(us, us.length);

		for (int i = 0; i <= temp; i++) {
			for (int k = 0; k < 4; k++) {
				System.out.print(user[k] + ", " + userState[k] + "  ");
			}
			System.out.println(index);
			//
			int beforestate = userState[i];
			int beforeuser = user[i];
			int beforeResult = result;
			if ((beforestate == 0 && user[i] > 20) || (beforestate == 1 && user[i] > 7)
					|| (beforestate == 2 && user[i] > 6) || (beforestate == 3 && user[i] > 7))
				continue;
			// 만약 이미 끝까지 온상황이면 continue

			//
			if (beforestate == 0 && user[i] + move[index] > 20) {
				user[i] = 21;
			} else if (beforestate == 1 && user[i] + move[index] > 7) {
				user[i] = 8;
			} else if (beforestate == 2 && user[i] + move[index] > 6) {
				user[i] = 7;
			} else if (beforestate == 3 && user[i] + move[index] > 7) {
				user[i] = 8;
			}
			// 만약 더해질 값이 상태에 따라 맵을 초과하면 도착칸에 머물기
			else {
				if (visit[user[i] + move[index]])
					continue;
				user[i] += move[index];
				beforenum = user[i];
				visit[user[i]] = true;
				result += map[beforestate][user[i]];
			}
			// 초과하지 않고 가는칸에 말이 없으면 이동하고 이동한칸의 점수를 더한다.

			//
			if (beforestate == 0) {
				if (user[i] == 5) {
					user[i] = 0;
					userState[i] = 1;
				}
				if (user[i] == 10) {
					userState[i] = 2;
					user[i] = 0;
				}
				if (user[i] == 15) {
					userState[i] = 3;
					user[i] = 0;
				}
			}
			// state에 따른 map이동
			dfs(index + 1, result, user, userState, beforenum);
			visit[user[i]] = false;
			result = beforeResult;
			user[i] = beforeuser;
			userState[i] = beforestate;
		}
	}
}

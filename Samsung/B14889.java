package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {

	// 9시 10분 시작
	static int[][] map;
	static boolean[] btr;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		btr = new boolean[N];
		dfs(0, 0);
		System.out.println(result);
	}

	static void dfs(int index, int cnt) {
		if (cnt == map.length / 2) {
			check();
			return;
		}
		
		if (index == map.length)
			return;



		btr[index] = true;
		dfs(index + 1, cnt + 1);
		btr[index] = false;
		dfs(index + 1, cnt);
	}

	static void check() {
		int[] team = new int[map.length / 2];
		int[] team2 = new int[map.length / 2];
		int index = 0;
		int index2 = 0;
		for (int i = 0; i < map.length; i++) {
			if (btr[i] == true) {
				team[index] = i;
				index++;
			} else {
				team2[index2] = i;
				index2++;
			}
		}
		int teampoint = 0;
		int teampoint2 = 0;
		for (int i = 0; i < team.length - 1; i++) {
			for (int j = i + 1; j < team.length; j++) {
				teampoint += map[team[i]][team[j]];
				teampoint += map[team[j]][team[i]];
				teampoint2 += map[team2[i]][team2[j]];
				teampoint2 += map[team2[j]][team2[i]];
			}
		}
		int diff = Math.abs(teampoint - teampoint2);
		result = result > diff ? diff : result;
	}
}

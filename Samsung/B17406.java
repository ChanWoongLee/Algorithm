package Samsung;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B17406 {
	static int[][] map;
	static int[][] rotate;
	static boolean[] visit;
	static int[] temp;
	static int result = Integer.MAX_VALUE;
	static int[] dr = { 0, 1, 0, -1 };// 오른쪽 아래 왼쪽 위
	static int[] dc = { 1, 0, -1, 0 };
	// 10 시 35 분시작

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rotate = new int[num][3];
		visit = new boolean[num];
		temp = new int[num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				rotate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(result);
	}

	static void dfs(int index, int cnt) {
		if (cnt == visit.length) {
			int res = 0;
			int[][] newmap = new int[map.length][map[0].length];
			for (int i = 0; i < map.length; i++) {
				newmap[i] = Arrays.copyOf(map[i], map[0].length);
			}
			for (int tempOrder = 0; tempOrder < temp.length; tempOrder++) {
				oper(newmap, temp[tempOrder]);
			}
			int value = Integer.MAX_VALUE;
			for (int i = 0; i < newmap.length; i++) {
				int temp = 0;
				for (int j = 0; j < newmap[0].length; j++) {
					temp += newmap[i][j];
				}
				value = value > temp ? temp : value;
			}
			result = value < result ? value : result;
			return;
		}

		for (int i = 0; i < visit.length; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				temp[cnt] = i;
				dfs(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

	static void oper(int[][] m, int num) {
		int r = rotate[num][0] - 1;
		int c = rotate[num][1] - 1;
		int s = rotate[num][2];
		int startR = r - s;
		int startC = c - s;
		int endR = r + s;
		int endC = c + s;

		for (int cnt = 0; cnt < s; cnt++) {
			LinkedList<Integer> save = new LinkedList<>();
			save.add(m[startR][startC]);
			for (int i = 0; i < 4; i++) {
				for (int turn = 0; turn < (s - cnt) * 2; turn++) {
					int nextR = startR + dr[i];
					int nextC = startC + dc[i];
					save.add(m[nextR][nextC]);
					int value = save.pollFirst();
					m[nextR][nextC] = value;
					startR = nextR;
					startC = nextC;
				}
			}
			startR += 1;
			startC += 1;
		}

	}
}

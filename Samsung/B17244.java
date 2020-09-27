package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B17244 {
	// 1시 20 분 시작!!!
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[] visit;
	static int[] temp;
	static ArrayList<Object> ar;
	static Object start = null;
	static Object end = null;
	static int answer = Integer.MAX_VALUE;

	// 내 생각을 조심하자!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111
	// 항상 최적이 최적이 아님을
	// 모든 경우의수를 세는 쪽으로 가자@@@@@@@@@@@@@@@@@@@@@@@@@
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		map = new int[N][M];
		int object = 3;

		ar = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				if (str[j].equals("S")) {
					start = new Object(i, j, 1, 0);
					map[i][j] = 1;
				} else if (str[j].equals("E")) {
					map[i][j] = 2;
					end = new Object(i, j, 2, 0);
				} else if (str[j].equals("X")) {
					ar.add(new Object(i, j, object, 0));
					map[i][j] = object++;
				} else if (str[j].equals("#"))
					map[i][j] = -1;
				else
					map[i][j] = 0;
			}
		}
		visit = new boolean[object - 3];
		temp = new int[object - 3];
		recur(0);
		System.out.println(answer);
	}

	static void recur(int index) {
		if (index == visit.length) {
			int res = bfs();
			if (res == -1)
				return;
			answer = res < answer ? res : answer;
			return;
		}
		for (int i = 0; i < visit.length; i++) {
			if (visit[i])
				continue;
			temp[index] = i;
			visit[i] = true;
			recur(index + 1);
			visit[i] = false;
		}
	}

	static int bfs() {
		ArrayList<Object> target = new ArrayList<>();
		for (int i = 0; i < ar.size(); i++) {
			target.add(ar.get(temp[i]));
		}
		target.add(end);
		boolean[][] visit = new boolean[N][M];
		visit[start.r][start.c] = true;
		Queue<Object> q = new LinkedList<Object>();
		q.add(start);
		int index = 0;
		int result = 0;
		while (!q.isEmpty()) {
			Object now = q.poll();
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
					continue;
				if (map[nextR][nextC] == -1 || visit[nextR][nextC])
					continue;
				if (map[nextR][nextC] == target.get(index).num) {
					result += now.cnt + 1;
					visit = new boolean[N][M];
					visit[nextR][nextC] = true;
					q = new LinkedList<Object>();
					q.add(new Object(nextR, nextC, map[nextR][nextC], 0));
					index++;
					if (result >= answer)
						return -1;
					break;
				}
				visit[nextR][nextC] = true;
				q.add(new Object(nextR, nextC, now.num, now.cnt + 1));
			}
			if (index == target.size())
				return result;
		}
		return result;
	}
}

class Object {
	int r, c, num, cnt;

	public Object(int r, int c, int num, int cnt) {
		this.r = r;
		this.c = c;
		this.num = num;
		this.cnt = cnt;
	}
}

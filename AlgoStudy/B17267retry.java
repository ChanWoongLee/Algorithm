package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17267retry {
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] realvisit;
	static int[] dr = { -1, 1, 0, 0 };// 위 아래 오른쪽 왼쪽
	static int[] dc = { 0, 0, 1, -1 };
	static int mapR;
	static int mapC;

	// 1:25 시작
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		mapR = map.length;
		mapC = map[0].length;
		st = new StringTokenizer(bf.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visit = new boolean[map.length][map[0].length];
		realvisit = new boolean[mapR][mapC];
		int nowX = 0, nowY = 0;
		for (int i = 0; i < map.length; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 2) {
					nowX = i;
					nowY = j;
				}
			}
		}
		PriorityQueue<male> q = new PriorityQueue();
		visit[nowX][nowY] = true;
		q.add(new male(nowX, nowY, L, R));
		while (!q.isEmpty()) {
			male now = q.poll();
			if (now.r == 3 && now.c == 3) {
			}
			for (int i = 0; i < 4; i++) {
				int mx = now.r + dr[i];
				int my = now.c + dc[i];
				if (mx < 0 || mx >= map.length || my < 0 || my >= map[0].length || map[mx][my] == 1)
					continue;
				if (visit[mx][my] == true)
					continue;
				if (i == 2 && now.R != 0) {
					visit[mx][my] = true;
					q.add(new male(mx, my, now.L, now.R - 1));
				} else if (i == 3 && now.L != 0) {
					visit[mx][my] = true;
					q.add(new male(mx, my, now.L - 1, now.R));
				} else if (i == 0 || i == 1) {
					visit[mx][my] = true;
					q.add(new male(mx, my, now.L, now.R));
				}
			}
		}
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (visit[i][j] == true)
					count++;
			}
		}
		System.out.println(count);
	}

}

class male implements Comparable<male> {
	int r, c, L, R;

	public male(int r, int c, int L, int R) {
		this.r = r;
		this.c = c;
		this.L = L;
		this.R = R;
	}

	public int compareTo(male arg0) {
		return -((this.R + this.L) - (arg0.R + arg0.L));
	}
}

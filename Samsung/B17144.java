package Samsung;

import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17144 {
	// 9 시 33 분
	static int R, C, T;
	static int[][] map;
	static robot[] r = new robot[2];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int index = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					r[index] = new robot(i, j);
					index++;
				}
			}
		}

		while (T-- > 0) {
			int[][] temp = new int[R][C];
			temp[r[0].r][r[0].c] = -1;
			temp[r[1].r][r[1].c] = -1;
			for(int i =0; i<R; i++) {
				for(int j = 0; j< C; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}				System.out.println();

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0 && map[i][j] != -1) {
						spread(i, j, temp);
					}
				}
			} // map은 깎여있고 temp는 쌓여있음
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == -1)
						continue;
					map[i][j] += temp[i][j];
				}
			}
			// 먼지 퍼지기 끝
			for(int i =0; i<R; i++) {
				for(int j = 0; j< C; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}				System.out.println();

			clean();
			// 청소

			for(int i =0; i<R; i++) {
				for(int j = 0; j< C; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}				System.out.println();

		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result + 2);
	}

	static void clean() {
		Queue<Integer> q = new LinkedList();
		int nowR = r[0].r + dr[1];
		int nowC = r[0].c + dc[1];
		q.add(map[nowR][nowC]);
		map[nowR][nowC] = 0;
		int[] reverseTime = { 1, 0, 3, 2 };
		int index = 0;
		while (index != 4) {
			if (nowR + dr[reverseTime[index]] < 0 || nowR + dr[reverseTime[index]] >= R
					|| nowC + dc[reverseTime[index]] < 0 || nowC + dc[reverseTime[index]] >= C) {
				index++;
				continue;
			}
			if (map[nowR + dr[reverseTime[index]]][nowC + dc[reverseTime[index]]] == -1) {
				break;
			}
			nowR += dr[reverseTime[index]];
			nowC += dc[reverseTime[index]];
			q.add(map[nowR][nowC]);
			map[nowR][nowC] = q.poll();
		}
		q.clear();
		nowR = r[1].r + dr[1];
		nowC = r[1].c + dc[1];
		int[] Time = { 1, 2, 3, 0 };
		q.add(map[nowR][nowC]);
		map[nowR][nowC] = 0;
		index = 0;
		while (index != 4) {

			if (nowR + dr[Time[index]] < 0 || nowR + dr[Time[index]] >= R || nowC + dc[Time[index]] < 0
					|| nowC + dc[Time[index]] >= C) {
				index++;
				continue;
			}
			if (map[nowR + dr[Time[index]]][nowC + dc[Time[index]]] == -1) {
				break;
			}
			nowR += dr[Time[index]];
			nowC += dc[Time[index]];
			q.add(map[nowR][nowC]);
			map[nowR][nowC] = q.poll();
		}
	}

	static void spread(int r, int c, int[][] temp) {
		Queue<Integer> q = new LinkedList();
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C)
				continue;
			if (map[nextR][nextC] == -1)
				continue;
			q.add(i);
		}
		int clone = q.size();
		while (!q.isEmpty()) {
			int move = q.poll();
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			temp[nextR][nextC] += map[r][c] / 5;
		}
		map[r][c] -= clone * (map[r][c] / 5);
	}
}

class robot {
	int r, c;

	public robot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
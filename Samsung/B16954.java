package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B16954 {
	static int N = 8;
	static int[][] map;
	static ArrayList<MM> wall;
	static int[] dr = { 0, -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] dc = { 0, 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		wall = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				if (str[j].equals(".")) {
					map[i][j] = 0;
				} else if (str[j].equals("#")) {
					map[i][j] = -1;
					wall.add(new MM(i, j));
				}
			}
		}
		MM start = new MM(7, 0);
		Queue<MM> q = new LinkedList<MM>();
		boolean[][] visit = new boolean[8][8];
		q.add(start);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (cnt == 9 || wall.size() == 0) {
				System.out.println("1");
				return;
			}
			
			for (int s = 0; s < size; s++) {
				MM now = q.poll();
				if (map[now.r][now.c] == -1)
					continue;

				for (int move = 0; move < dr.length; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR >= N || nextC >= N || nextC < 0 || nextR < 0) {
						continue;
					}
					if (map[nextR][nextC] == -1)
						continue;
					if (visit[nextR][nextC])
						continue;
					visit[nextR][nextC] = true;
					q.add(new MM(nextR, nextC));
				}
			}
			visit = new boolean[8][8];
			drop();
			cnt++;
		}
		System.out.println("0");
		return;
	}

	static void drop() {
		for (int i = 0; i < wall.size(); i++) {
			if (wall.get(i).r + 1 >= N) {
				map[wall.get(i).r][wall.get(i).c] = 0;
				wall.remove(i--);
			} else {
				map[wall.get(i).r][wall.get(i).c] = 0;
				map[wall.get(i).r + 1][wall.get(i).c] = -1;
				wall.set(i, new MM(wall.get(i).r + 1, wall.get(i).c));
			}
		}
	}
}

class MM {
	int r, c;

	public MM(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {
	static int R, C;
	static String[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		Queue<Pos> biber = new LinkedList<>();
		Queue<Pos> water = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("*"))
					water.add(new Pos(i, j));
				else if (map[i][j].equals("S"))
					biber.add(new Pos(i, j));
			}
		}
		Pos now = biber.poll();
		boolean[][] visit = new boolean[R][C];
		visit[now.r][now.c] = true;
		biber.add(now);
		int nextR = 0;
		int nextC = 0;
		int ans = 1;
		while (!biber.isEmpty()) {
			int biber_size = biber.size();
			for (int i = 0; i < biber_size; i++) {
				Pos b = biber.poll();
				if (map[b.r][b.c].equals("*"))
					continue;

				for (int move = 0; move < 4; move++) {
					nextR = b.r + dr[move];
					nextC = b.c + dc[move];
					if (nextR >= R || nextR < 0 || nextC >= C || nextC < 0)
						continue;
					if (map[nextR][nextC].equals("D")) {
						System.out.println(ans);
						return;
					}
					if (map[nextR][nextC].equals(".")) {
						map[nextR][nextC] = "S";
						biber.add(new Pos(nextR, nextC));
					}
				}
			}
			int water_size = water.size();
			for (int i = 0; i < water_size; i++) {
				Pos w = water.poll();
				for (int move = 0; move < 4; move++) {
					nextR = w.r + dr[move];
					nextC = w.c + dc[move];
					if (nextR >= R || nextR < 0 || nextC >= C || nextC < 0)
						continue;
					if (map[nextR][nextC].equals(".") || map[nextR][nextC].equals("S")) {
						map[nextR][nextC] = "*";
						water.add(new Pos(nextR, nextC));
					}
				}
			}
			ans++;
		}
		System.out.println("KAKTUS");
	}

}

class Pos {
	int r, c;

	public Pos(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}

package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17143_re {
	static int R, C;
	static int[][] map;
	static Shark[] s;
	static int[] dr = { -1, 1, 0, 0 };// 위 아래 오른쪽 왼쪽
	static int[] dc = { 0, 0, 1, -1 };
	static int[] rdir = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = -1;
			}
		}
		Shark[] s = new Shark[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			s[i] = new Shark(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
			map[s[i].r][s[i].c] = i;
		}
		int hunter = -1;
		int res = 0;
		while (hunter < C) {
			hunter++;
			for (int i = 0; i < R; i++) {
				if (map[i][hunter] != -1) {
					res += s[map[i][hunter]].z;
					map[i][hunter] = -1;
					s[map[i][hunter]] = null;
					break;
				}
			}
			for (int i = 0; i < M; i++) {
				if (s[i] == null)
					continue;
				int nextR = s[i].r + s[i].s * dr[s[i].d];
				int nextC = s[i].c + s[i].s * dc[s[i].d];
				int modSpeed;
				if (nextR >= R || nextR < 0) {
					modSpeed = s[i].s % R;
					int dif = 
				} else if (nextC >= C || nextC < 0) {
					modSpeed = s[i].s % C;
				} else {
					map[s[i].r][s[i].c] = -1;
					map[nextR][nextC] = i;
					s[i].r = nextR;
					s[i].c = nextC;
					continue;
				}
			}
		}
		int result = 0;
	}

}

class Shark {
	int r, c, s, d, z;

	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

}
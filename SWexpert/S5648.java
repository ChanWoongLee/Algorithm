package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5648 {
	// 8:40 시작
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static atom[] atoms;
	static int[] reverse = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			atoms = new atom[size];
			int[][] space = new int[2001][2001];
			for (int i = 0; i < 2001; i++)
				Arrays.fill(space[i], -1);
			boolean[][] getlidof = new boolean[2001][2001];
			int[][] collid = new int[2001][2001];
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken()) + 1000;
				int y = Integer.parseInt(st.nextToken()) + 1000;
				int dir = Integer.parseInt(st.nextToken());
				atoms[i] = new atom(y, x, dir, Integer.parseInt(st.nextToken()));
				space[x][y] = i;
				collid[x][y]++;
			}

			while (true) {
				for (int i = 0; i < size; i++) {
					if (atoms[i] == null)
						continue;
					int r = atoms[i].r;
					int c = atoms[i].c;
					if (getlidof[r][c]) {
						collid[r][c]--;
						if (collid[r][c] == 0)
							getlidof[r][c] = false;
						result += atoms[i].weight;
						atoms[i] = null;
						continue;
					} // 같은 자리 충돌 검사
					else
						collid[r][c]--;

					int move = atoms[i].dir;
					int nextR = r + dr[move];
					int nextC = c + dc[move];
					if (nextR < 0 || nextC < 0 || nextR >= 2001 || nextC >= 2001)
						continue;
					if (space[nextR][nextC] == -1)
						continue;
					if (atoms[space[nextR][nextC]].dir == reverse[atoms[i].dir]) {
						result += atoms[i].weight;
						result += atoms[space[nextR][nextC]].weight;
						atoms[i] = null;
						atoms[space[nextR][nextC]] = null;
						space[nextR][nextC] = -1;
						space[r][c] = -1;
						break;
					}
				}
				for (int i = 0; i < size; i++) {
					if (atoms[i] == null)
						continue;
					int nextR = atoms[i].r + dr[atoms[i].dir];
					int nextC = atoms[i].c + dc[atoms[i].dir];
					if (nextR < 0 || nextC < 0 || nextR >= 2001 || nextC >= 2001) {
						atoms[i] = null;
						continue;
					}
					space[atoms[i].r][atoms[i].c] = -1;
					space[nextR][nextC] = i; // space에 이동위치 찍음
					collid[nextR][nextC]++;
					if (collid[nextR][nextC] > 1)
						getlidof[nextR][nextC] = true;
					atoms[i] = new atom(nextR, nextC, atoms[i].dir, atoms[i].weight);
				}

				int num = 0;
				for (int i = 0; i < size; i++) {
					if (atoms[i] != null)
						num++;
				}
				if (num <= 1)
					break;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}

class atom {
	int r, c, dir, weight;

	public atom(int r, int c, int dir, int weight) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.weight = weight;
	}
}

package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B17837 {
	// 3시 시작     5시 끝
	static int N, K;
	static int[][][] map;
	static int[] dr = { 0, 0, -1, 1 };// 오른쪽 / 왼쪽/ 위/ 아래
	static int[] dc = { 1, -1, 0, 0 };// 오른쪽 / 왼쪽/ 위/ 아래
	static m[] target;
	static boolean end = false;
	//arraylist로 이루어진 맵으로 다시한번 풀어볼것!!!!!!!!!!!!!!!!!!
	//그러면 쉽게 풀 수 있다.
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {// 0 흰색 1빨간 2파란
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		target = new m[K + 1];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			target[i] = new m(r, c, dir);
			map[r][c][1] = i;
		}
		int cnt = 0;
		while (cnt++ < 1000) {
			for (int i = 1; i <= K; i++) {
				move(i);
				if (end) {
					System.out.println(cnt);
					System.exit(0);
				}
				// for (int a = 0; a < N; a++) {
				// for (int b = 0; b < N; b++) {
				// for (int c = 0; c < 4; c++) {
				// System.out.print(map[a][b][c] + ",");
				// }
				// System.out.print(" ");
				// }
				// System.out.println();
				// }
				// System.out.println();
			}
		}
		System.out.println("-1");
	}

	static void move(int i) {
		int r = target[i].r;
		int c = target[i].c;
		int dir = target[i].dir;
		int nextR = r + dr[dir];
		int nextC = c + dc[dir];
		if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || map[nextR][nextC][0] == 2) {// 움직일 칸이 파랑일때
			int newdir = 0;
			if (dir == 0 || dir == 1)
				newdir = dir == 0 ? 1 : 0;
			else
				newdir = dir == 2 ? 3 : 2;
			nextR += dr[newdir] * 2;
			nextC += dc[newdir] * 2;

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || map[nextR][nextC][0] == 2) {// 또파란색일때
				target[i] = new m(r, c, newdir);
			} else if (map[nextR][nextC][0] == 1) {// 빨간색일때
				target[i] = new m(r, c, newdir);
				if (finish(r, c, nextR, nextC, newdir, i)) {
					end = true;
					return;
				}
				realMove(r, c, nextR, nextC, newdir, i);
				forRed(nextR, nextC, i);
			} else if (map[nextR][nextC][0] == 0) {// 하얀색일때
				target[i] = new m(r, c, newdir);
				if (finish(r, c, nextR, nextC, newdir, i)) {
					end = true;
					return;
				}
				realMove(r, c, nextR, nextC, newdir, i);
			}
		} else if (map[nextR][nextC][0] == 1) {// 빨간색일때
			if (finish(r, c, nextR, nextC, dir, i)) {
				end = true;
				return;
			}
			realMove(r, c, nextR, nextC, dir, i);
			forRed(nextR, nextC, i);
		} else if (map[nextR][nextC][0] == 0) {
			if (finish(r, c, nextR, nextC, dir, i)) {
				end = true;
				return;
			}
			realMove(r, c, nextR, nextC, dir, i);
		}
	}

	static void forRed(int r, int c, int now) {
		for (int check = 1; check < 4; check++) {
			if (map[r][c][check] == now) {
				for (int endcheck = 3; endcheck >= 0; endcheck--) {
					if (map[r][c][endcheck] != 0) {
						LinkedList<Integer> list = new LinkedList();
						for (int start = check; start <= endcheck; start++) {
							list.addFirst(map[r][c][start]);
						}
						for (int start = check; start <= endcheck; start++) {
							map[r][c][start] = list.pollFirst();
						}
						break;
					}
				}
				break;
			}
		}
	}

	static void realMove(int r, int c, int nextR, int nextC, int dir, int now) {
		boolean nextMove = false;
		for (int check = 1; check < 4; check++) {
			if (nextMove) {
				if (map[r][c][check] == 0)
					continue;
				int temp = map[r][c][check];
				map[r][c][check] = 0;
				for (int inMap = 1; inMap < 4; inMap++) {
					if (map[nextR][nextC][inMap] == 0) {
						map[nextR][nextC][inMap] = temp;
						target[temp] = new m(nextR, nextC, target[temp].dir);
						break;
					}
				}

			}
			if (map[r][c][check] == now) {
				nextMove = true;
				map[r][c][check] = 0;
				for (int inMap = 1; inMap < 4; inMap++) {
					if (map[nextR][nextC][inMap] == 0) {
						map[nextR][nextC][inMap] = now;
						target[now] = new m(nextR, nextC, target[now].dir);
						break;
					}
				}
			}
		}
	}

	static boolean finish(int r, int c, int nextR, int nextC, int dir, int now) {
		int cnt = 0;
		boolean nextMove = false;
		for (int check = 1; check < 4; check++) {
			if (nextMove && map[r][c][check] != 0)
				cnt++;
			if (map[r][c][check] == now) {
				cnt++;
				nextMove = true;
			}
		}
		for (int check = 1; check < 4; check++) {
			if (map[nextR][nextC][check] != 0)
				cnt++;
		}
		if (cnt >= 4)
			return true;

		return false;
	}
}

class m {
	int r;
	int c;
	int dir;

	m(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}

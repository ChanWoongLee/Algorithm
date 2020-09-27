package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17143 {
	// 3 �� 26 �� ����
	static int C, R;
	static int[][] map;
	static int[][] nextmap;
	static int[] dr = { -1, 1, 0, 0 };// �� �Ʒ� ������ ����
	static int[] dc = { 0, 0, 1, -1 };
	static shark[] s;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		nextmap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = -1;
			}
		}
		s = new shark[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			s[i] = new shark(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
			map[s[i].r][s[i].c] = i;
		}
		int result = 0;

		for (int i = 0; i < C; i++) { // ���� ����ŭ ����
			for (int j = 0; j < R; j++) {
				if (map[j][i] != -1) {
					result += s[map[j][i]].size;
					s[map[j][i]] = null;
					map[j][i] = -1;
					break;
				}
			} // ���� ����� ��� ��ȹ
			nextmap = new int[R][C];
			for (int k = 0; k < R; k++) {
				Arrays.fill(nextmap[k], -1);
			}
			for (int j = 0; j < M; j++) {
				if (s[j] != null) {
					int r = s[j].r;
					int c = s[j].c;
					int dir = s[j].dir;
					int move1 = s[j].speed;
					if (dir == 0 || dir == 1) {
						if (2 * (R - 1) <= move1)
							move1 = move1 % (2 * (R - 1));
					} else {
						if (2 * (C - 1) <= move1)
							move1 = move1 % (2 * (C - 1));
					}
					for (int move = 0; move < move1; move++) {
						if (r + dr[dir] >= 0 && r + dr[dir] < R && c + dc[dir] >= 0 && c + dc[dir] < C) {
							r += dr[dir];
							c += dc[dir];
						} // �̵�����
						else {
							if (dir == 0 || dir == 1)
								dir = dir == 0 ? 1 : 0;
							else
								dir = dir == 2 ? 3 : 2;
							r += dr[dir];
							c += dc[dir];
						} // �Ұ����϶��� ����ٲ㼭 �ѹ� ����
					}
					if (nextmap[r][c] != -1) {
						if (s[nextmap[r][c]].size < s[j].size) {
							s[nextmap[r][c]] = null;
							s[j] = new shark(r, c, s[j].speed, dir, s[j].size);
							nextmap[r][c] = j;
						} // ������ ������ ��Ƹ԰� �߰�
						else {
							s[j] = null;
						} // ū���϶� ��Ƹ����� ����
					} // �����ߴµ� �̹� ���������
					else {
						s[j] = new shark(r, c, s[j].speed, dir, s[j].size);
						nextmap[r][c] = j;
					} // ��������
				}
			} // �������
			for (int k = 0; k < R; k++) {
				map[k] = Arrays.copyOf(nextmap[k], C);
			}

		}
		System.out.println(result);
	}

}

class shark {
	int r, c;
	int speed;
	int size;
	int dir;

	public shark(int rr, int cc, int sp, int d, int si) {
		r = rr;
		c = cc;
		speed = sp;
		dir = d;
		size = si;
	}
}

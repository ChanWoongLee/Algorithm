package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B17837_re {
	// 5 : 17 ���� !

	static ArrayList<Integer>[][] hmap;
	static int[][] map;
	static int[] dr = { 0, 0, -1, 1 };// ������ , ���� , ��, �Ʒ�
	static int[] dc = { 1, -1, 0, 0 };
	static int[] rdir = { 1, 0, 3, 2 };
	static int N, K;
	static int[][] loc;
	static boolean allpos = false;
	static boolean isChange = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		hmap = new ArrayList[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				hmap[i][j] = new ArrayList();
			}
		}
		loc = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			loc[i][0] = r;
			loc[i][1] = c;
			loc[i][2] = dir;
			hmap[r][c].add(i);
		}

		int cnt = 0;
		while (true) {
			if (cnt > 1000) {
				System.out.println("-1");
				return;
			}
			cnt++;
			isChange = false;
			for (int i = 0; i < K; i++) {
				int r = loc[i][0];
				int c = loc[i][1];
				int nextR = loc[i][0] + dr[loc[i][2]];
				int nextC = loc[i][1] + dc[loc[i][2]];
				int dir = loc[i][2];
				if (nextR >= N || nextR < 0 || nextC >= N || nextC < 0 || map[nextR][nextC] == 2) {// �Ķ����ϰ��
					nextR = nextR + dr[rdir[dir]] * 2;
					nextC = nextC + dc[rdir[dir]] * 2;
					if (nextR >= N || nextR < 0 || nextC >= N || nextC < 0 || map[nextR][nextC] == 2) {// �� �Ķ����� ���
						loc[i][2] = rdir[dir];
						continue;// ���⸸ �̵��ϰ� ���� ����
					} else if (map[nextR][nextC] == 1) // �������ϰ��
						move(r, c, nextR, nextC, i, 1);
					else
						move(r, c, nextR, nextC, i, 0); // �Ͼ���� ���
					loc[i][2] = rdir[dir];
					continue;
				} else if (map[nextR][nextC] == 1)
					move(r, c, nextR, nextC, i, 1);
				else
					move(r, c, nextR, nextC, i, 0);

			}

			if (allpos) {
				System.out.println(cnt);
				return;
			}
			if (isChange == false) {
				System.out.println("-1");
				return;
			}
		}
	}

	static void move(int r, int c, int nextR, int nextC, int num, int color) {
		boolean flag = false;
		ArrayList<Integer> temp = new ArrayList();
		for (int i = 0; i < hmap[r][c].size(); i++) {
			if (num == hmap[r][c].get(i))
				flag = true;

			if (flag) {
				temp.add(hmap[r][c].get(i));
				hmap[r][c].remove(i--);
			}
		}
		if (color == 1) {
			for (int i = temp.size() - 1; i >= 0; i--) {
				hmap[nextR][nextC].add(temp.get(i));
				loc[temp.get(i)][0] = nextR;
				loc[temp.get(i)][1] = nextC;
				isChange = true;
			}
		} else {
			for (int i = 0; i < temp.size(); i++) {
				hmap[nextR][nextC].add(temp.get(i));
				loc[temp.get(i)][0] = nextR;
				loc[temp.get(i)][1] = nextC;
				isChange = true;
			}
		}
		if (hmap[nextR][nextC].size() >= 4)//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
			allpos = true;
	}
}

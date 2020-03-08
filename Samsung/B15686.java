package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15686 {
	// 9�� 30�н���
	// ��� ��츦 �������ϴ°� ���� ����
	// ġŲ���� ���� nCr �ؾ��ϴ� �Ǿ˾����� ���� ��� ����
	// �������� map�� �̵����� �ʹ� ���� ���� , ������ 1ĭ�� �����̴»����� ��������
	// �Ÿ��� x - x'  + y - y' �ΰ��̿� 
	// ��ġ �κ������� ���ϴ°�ó�� 4���� ���ؼ� ��� ������ (visit�� üũ�ϸ鼭 dfs ����)
	//�ٽ��غ���
	static int[][] map;
	static int[][] chiken;
	static int[] dr = { -1, 0, 1, 0 };// �� ������ �Ʒ� ����
	static int[] dc = { 0, 1, 0, -1 };
	static int num = 0;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chiken = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					num++;
			}
		}
		if (num == M) { // ��� ���Ҷ�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						bfs2(i, j);
				}
			}
		} else {// �����ؾ��Ҷ�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						bfs(i, j);
				}
			} // for�������� ��� �������� ġŲ������ ġŲ�Ÿ��� ���� �������� �ͺ��� M�� ���� ä��
			ArrayList<loc> forcomp = new ArrayList();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 2) {
						forcomp.add(new loc(i, j, chiken[i][j]));
						System.out.println(chiken[i][j]);
					}
				}
			}
			Collections.sort(forcomp);
			int s = forcomp.size() - 1;
			for (int i = s; i >= M; i--) {
				map[forcomp.get(i).r][forcomp.get(i).c] = 0;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						bfs2(i, j);
				}
			}

		}
		System.out.println(result);

	}

	static public void bfs(int r, int c) {
		int len = 1;
		int bnum = 0;
		boolean[][] visit = new boolean[map.length][map.length];
		Queue<loc> q = new LinkedList();
		q.add(new loc(r, c));
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int nowr = q.peek().r;
				int nowc = q.peek().c;
				q.poll();
				for (int i = 0; i < 4; i++) {
					int mr = nowr + dr[i];
					int mc = nowc + dc[i];
					if (mr < map.length && mr >= 0 && mc < map.length && mc >= 0 && visit[mr][mc] == false) {
						if (map[mr][mc] == 2) {
							chiken[mr][mc] += len;
							bnum++;
							if (bnum == num)
								return;
							else {
								visit[mr][mc] = true;
								q.add(new loc(mr, mc));
							}
						} else {
							visit[mr][mc] = true;
							q.add(new loc(mr, mc));
						}
					}
				}
			}
			len++;
		}
	}

	static public void bfs2(int r, int c) {
		int len = 1;
		boolean[][] visit = new boolean[map.length][map.length];
		Queue<loc> q = new LinkedList();
		q.add(new loc(r, c));
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int nowr = q.peek().r;
				int nowc = q.peek().c;
				q.poll();
				for (int i = 0; i < 4; i++) {
					int mr = nowr + dr[i];
					int mc = nowc + dc[i];
					if (mr < map.length && mr >= 0 && mc < map.length && mc >= 0 && visit[mr][mc] == false) {
						if (map[mr][mc] == 2) {
							result += len;
							return;
						}
						else {
							visit[mr][mc] = true;
							q.add(new loc(mr, mc));
						}
					}
				}
			}
			len++;
		}
	}
}


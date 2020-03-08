package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import AlgoStudy.codeForce1;

public class B14502 {// ���̷��� ��Ʈ����
	// 3 : 06 ����
	// ������ .. �������� ���Ʈ�������� ��� ���߱� ������
	// �̹����� ���̷����� ���� ��� ���Ƽ� �ִ밪�� ���ϴ��ķ� ���� Ǯ �� ����.
	// ������ 3���� ���� �� ��ġ���� �񱳸� �ؾ��ϴ� ��û ��ģ ������ ..
	// dfs�� �����ų� backtracking�� �̿��Ͽ� m*n C 3 �� ������ �������Ѵ�!!
	// ���ڸ� 0 ~ n*m ���� ������ų�� (i/m, i%m) �� ��ǥ�� �ϸ� 2���� �迭�� ��� �ε����� Ž���� �� �ֽ��ϴ�. ->
	// backtracking
	// 2�� for�� 2��, c ������ �ø��ٰ� r ������ �ø��� -> dfs

	static int[][] map;
	static int M, N;
	static ArrayList<loc> virus2 = new ArrayList();
	static Queue<loc> virus = new LinkedList();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus2.add(new loc(i, j));
			}
		}
		dfs(0, 0);
		System.out.println(result);
	}

	static void dfs(int index, int cnt) {
		if (cnt == 3) {
			int[][] temp = new int[map.length][map[0].length];
			for (int i = 0; i < map.length; i++) {
				temp[i] = Arrays.copyOf(map[i], map[0].length);
			}
			Queue<loc> q = new LinkedList();
			q.addAll(virus2);
			boolean[][] visit = new boolean[temp.length][temp[0].length];
			while (!q.isEmpty()) {
				loc nowloc = q.poll();
				visit[nowloc.r][nowloc.c] = true;
				for (int i = 0; i < 4; i++) {
					int mr = nowloc.r + dr[i];
					int mc = nowloc.c + dc[i];
					if (mr < 0 || mr >= map.length || mc < 0 || mc >= map[0].length)
						continue;
					if (temp[mr][mc] == 1 || visit[mr][mc] == true)
						continue;
					q.add(new loc(mr, mc));
					temp[mr][mc] = 2;
				}
			}
			int res = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (temp[i][j] == 0)
						res++;
				}
			}
			result = result < res ? res : result;
			return;
		}

		for (int i = index; i < N * M; i++) {
			int r = i / M;
			int c = i % M;
			if (map[r][c] == 0) {
				map[r][c] = 1;
				dfs(index + 1, cnt + 1);
				map[r][c] = 0;
			}
		}
	}
}

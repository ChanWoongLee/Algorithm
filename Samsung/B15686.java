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
	// 9시 30분시작
	// 모든 경우를 따져야하는건 느낌 받음
	// 치킨집에 대해 nCr 해야하는 건알았지만 설마 라고 생각
	// 과정에서 map의 이동에만 너무 생각 한정 , 무조건 1칸씩 움직이는생각을 지양하자
	// 거리는 x - x'  + y - y' 인걸이용 
	// 마치 부분집합을 구하는것처럼 4개에 대해서 재귀 돌리기 (visit을 체크하면서 dfs 가됨)
	//다시해보자
	static int[][] map;
	static int[][] chiken;
	static int[] dr = { -1, 0, 1, 0 };// 위 오른쪽 아래 왼쪽
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
		if (num == M) { // 모두 구할때
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						bfs2(i, j);
				}
			}
		} else {// 폐점해야할때
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						bfs(i, j);
				}
			} // for문종료후 모든 집에대해 치킨집마다 치킨거리가 계산됨 가장작은 것부터 M개 까지 채택
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


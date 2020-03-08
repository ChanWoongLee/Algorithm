package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;

public class B15972 {
	static int[] dx = { -1, 0, 1, 0 };// 위 오른쪽 아래 왼쪽
	static int[] dy = { 0, 1, 0, -1 };// 위 오른쪽 아래 왼쪽

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int sero = Integer.parseInt(st.nextToken());// N
		int garo = Integer.parseInt(st.nextToken());// M
		int height = Integer.parseInt(st.nextToken());
		int[][] tank = new int[sero][garo];
		boolean[][] visit = new boolean[sero][garo];
		for (int i = 0; i < tank.length; i++)
			Arrays.fill(tank[i], height);
		int[][] garo_hole = new int[sero + 1][garo];
		int[][] sero_hole = new int[sero][garo + 1];
		for (int i = 0; i < sero + 1; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < garo_hole[i].length; j++) {
				garo_hole[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < sero; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < sero_hole[i].length; j++) {
				sero_hole[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 겉에 부터 빠지게하기
		int garo_end = garo_hole.length - 1;
		int sero_end = sero_hole[0].length - 1;
		int tank_end = tank.length - 1;
		int tank_garo_end = tank[0].length - 1;

		for (int i = 0; i < garo_hole[0].length; i++) {
			if (garo_hole[0][i] != -1)
				tank[0][i] = tank[0][i] < garo_hole[0][i] ? tank[0][i] : garo_hole[0][i];
		}
		for (int i = 0; i < garo_hole[garo_end].length; i++) {
			if (garo_hole[garo_end][i] != -1)
				tank[tank_end][i] = tank[tank_end][i] < garo_hole[garo_end][i] ? tank[tank_end][i]
						: garo_hole[garo_end][i];
		}
		for (int i = 0; i < sero_hole.length; i++) {
			if (sero_hole[i][0] != -1)
				tank[i][0] = tank[i][0] < sero_hole[i][0] ? tank[i][0] : sero_hole[i][0];
		}
		for (int i = 0; i < sero_hole.length; i++) {
			if (sero_hole[i][sero_end] != -1)
				tank[i][tank_garo_end] = tank[i][tank_garo_end] < sero_hole[i][sero_end] ? tank[i][tank_garo_end]
						: sero_hole[i][sero_end];
		}
		// 끝의 작은것부터 BFS 필수 !! 1. 작은것 부터(우선순위) , 2.BFS (DFS X)
		// 작고 변화된것 넣고 visit 처리
		// for (int i = 0; i < tank.length; i++) {
		// for (int j = 0; j < tank[i].length; j++) {
		// System.out.print(tank[i][j] + " ");
		// }
		// System.out.println();
		// }
		PriorityQueue<loc> pq = new PriorityQueue();
		for (int i = 0; i < tank[0].length; i++) {
			if (tank[0][i] != height) {
				pq.add(new loc(0, i, tank[0][i]));
			}
		}
		for (int i = 0; i < tank[0].length; i++) {
			if (tank[tank_end][i] != height) {
				pq.add(new loc(tank_end, i, tank[tank_end][i]));
			}
		}
		for (int i = 1; i < tank.length - 1; i++) {
			if (tank[i][0] != height) {
				pq.add(new loc(i, 0, tank[i][0]));
			}
		}
		for (int i = 1; i < tank.length - 1; i++) {
			if (tank[i][tank_garo_end] != height) {
				pq.add(new loc(i, tank_garo_end, tank[i][tank_garo_end]));
			}
		}
//		 for(int i = 0; i < 8; i++) {
//		 loc d = pq2.poll();
//		 System.out.println(d.x + " "+ d.y + " "+ d.h );
//		 }
//		 System.exit(0);
	//	int size = pq.size();
	//	for (int j = 0; j < size; j++) {
			//PriorityQueue<loc> pq = new PriorityQueue();
			//loc min = pq2.poll();
//			if (visit[min.x][min.y] == false) {
//				visit[min.x][min.y] = true;
//				pq.add(min);
				while (!pq.isEmpty()) {
					loc now = pq.poll();
					int x = now.x;
					int y = now.y;
					int h = now.h;
					for (int i = 0; i < 4; i++) {
						if (x + dx[i] >= 0 && x + dx[i] < tank.length && y + dy[i] >= 0 && y + dy[i] < tank[0].length) {
							if (visit[x + dx[i]][y + dy[i]] == false) {
								if (dx[i] == 0 && dy[i] == 1) {// 오른쪽
									if (sero_hole[x + dx[i]][y + dy[i]] != -1) {
										tank[x + dx[i]][y + dy[i]] = sero_hole[x + dx[i]][y + dy[i]] > tank[x][y]
												? sero_hole[x + dx[i]][y + dy[i]]
												: tank[x + dx[i]][y + dy[i]];
										visit[x + dx[i]][y + dy[i]] = true;
										pq.add(new loc(x + dx[i], y + dy[i], tank[x + dx[i]][y + dy[i]]));
									}
								} else if (dx[i] == 0 && dy[i] == -1) {// 왼쪽
									if (sero_hole[x][y] != -1) {
										tank[x + dx[i]][y + dy[i]] = sero_hole[x][y] > tank[x][y] ? sero_hole[x][y]
												: tank[x + dx[i]][y + dy[i]];
										visit[x + dx[i]][y + dy[i]] = true;
										pq.add(new loc(x + dx[i], y + dy[i], tank[x + dx[i]][y + dy[i]]));
									}
								} else if (dx[i] == 1 && dy[i] == 0) {// 아래
									if (garo_hole[x + dx[i]][y + dy[i]] != -1) {
										tank[x + dx[i]][y + dy[i]] = garo_hole[x + dx[i]][y + dy[i]] > tank[x][y]
												? garo_hole[x + dx[i]][y + dy[i]]
												: tank[x + dx[i]][y + dy[i]];
										visit[x + dx[i]][y + dy[i]] = true;
										pq.add(new loc(x + dx[i], y + dy[i], tank[x + dx[i]][y + dy[i]]));
									}
								} else if (dx[i] == -1 && dy[i] == 0) {// 위
									if (garo_hole[x][y] != -1) {
										tank[x + dx[i]][y + dy[i]] = garo_hole[x][y] > tank[x][y] ? garo_hole[x][y]
												: tank[x + dx[i]][y + dy[i]];
										visit[x + dx[i]][y + dy[i]] = true;
										pq.add(new loc(x + dx[i], y + dy[i], tank[x + dx[i]][y + dy[i]]));
									}
								}
							}
						}

					}
				}
			//}
	//	}
		 for (int i = 0; i < tank.length; i++) {
		 for (int j = 0; j < tank[i].length; j++) {
		 System.out.print(tank[i][j] + " ");
		 }
		 System.out.println();
		 }
		int result = 0;
		for (int i = 0; i < tank.length; i++) {
			for (int j = 0; j < tank[i].length; j++) {
				result+=tank[i][j];
			}
		}
		System.out.println(result);
	}
}

class loc implements Comparable<loc> {
	int x;
	int y;
	int h;

	public loc(int xx, int yy, int hh) {
		x = xx;
		y = yy;
		h = hh;
	}

	@Override
	public int compareTo(loc arg0) {
		return this.h - arg0.h;
	}
}
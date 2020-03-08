package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B2178 {
	static int[][] miro;
	static boolean[][] visited;
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 }; // �� ������ �Ʒ� ����
	static int[] dy = { 0, 1, 0, -1 };

	// �ٳ���°� �ϰڴٸ� ��� �ּҸ� ���Ұ��ΰ� 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] sar = bf.readLine().trim().split(" ");
		N = Integer.parseInt(sar[0]);
		M = Integer.parseInt(sar[1]);
		miro = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			sar = bf.readLine().trim().split("");
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(sar[j]);
				visited[i][j] = false;
			}
		}
		bfs();
		System.out.println(miro[N-1][M-1]);
	}

	public static void bfs() {
		Queue<Loc> q = new LinkedList();
		Loc start = new Loc(0, 0);
		q.add(start);
		while (!q.isEmpty()) {
			Loc loc = q.poll();
			if (loc.x == N-1 && loc.y == M-1)
				break;
			visited[loc.x][loc.y] = true;
			for (int i = 0; i < 4; i++) {// 4���� �˻�
				if (loc.x + dx[i] >= 0 && loc.x + dx[i] < N && loc.y + dy[i] < M && loc.y + dy[i] >= 0) { // ������ġ�� ���� �� 4������ miro ���� ���� �Ǵ�
					if (miro[loc.x + dx[i]][loc.y + dy[i]] == 1&& visited[loc.x + dx[i]][loc.y + dy[i]] == false) {// miro�� 1 , �湮���� x �Ǵ�
						Loc go = new Loc(loc.x + dx[i], loc.y + dy[i]);
						visited[loc.x + dx[i]][loc.y + dy[i]] = true;
						miro[loc.x + dx[i]][loc.y + dy[i]] = miro[loc.x][loc.y]+1;
						q.add(go);
					}
				}
			}
		}
	}
}

class Loc {
	int x;
	int y;
	public Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

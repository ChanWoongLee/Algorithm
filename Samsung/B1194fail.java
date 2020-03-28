package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B1194fail {
	// 9시 30분 시작
	static int N, M;
	static String[][] map;
	static boolean opendoor[] = new boolean[6];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 'a' = 97 , 'A' = 65
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new String[N][M];
		pos init = null;
		for (int i = 0; i < N; i++) {
			str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("0"))
					init = new pos(i, j, 0);
			}
		}
		Queue<pos> getKey = new LinkedList();
		Queue<pos> q = new LinkedList();
		q.add(init);
		while (true) {
			boolean[][] visit = new boolean[N][M];
			for (pos p : getKey)
				q.add(p);
			getKey.clear();
			
			for(pos p : q) {
				visit[p.r][p.c] = true;
			}
			while (!q.isEmpty()) {
				pos now = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)// 장외 삭제
						continue;
					if (map[nextR][nextC].equals("#"))// 벽 삭제
						continue;
					if (visit[nextR][nextC] = true)// 다녀온곳 삭제
						continue;
					char[] cr = map[nextR][nextC].toCharArray();
					if (cr[0] >= 65 && cr[0] <= 70) // 문 만났을때 키가 없다면 삭제
						if (!now.ar.contains(cr[0] - 65))
							continue;

					if (cr[0] >= 97 && cr[0] <= 102) {
						pos next = new pos(nextR, nextC, now.cnt + 1);
						next.ar = (ArrayList<Integer>) now.ar.clone();
						next.ar.add(cr[0] - 97);
						getKey.add(next);
						visit[nextR][nextC] = true;
						continue;
					} // key를 만났다면 q넣고 끝내기
					q.add(new pos(nextR, nextC, now.cnt));
					visit[nextR][nextC] = true;

				}
			}
		}
	}
}

class pos {
	int r, c, cnt;
	ArrayList<Integer> ar = new ArrayList();

	public pos(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}

	public void getKey(int key) {
		ar.add(key);
	}
}
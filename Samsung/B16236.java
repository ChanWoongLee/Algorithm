package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
	// 3시 26
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static sshark s;
	static int[] dr = { -1, 0, 0, 1 };// 위 왼쪽 오른쪽 아래
	static int[] dc = { 0, -1, 1, 0 };
	
	
	//예외를 생각하지못함  정통 BFS를 이용하고 깔끔한 느낌이 들도록 문제를 풀도록하자!!!!!
	
	
	// 같으면 지나갈수 있음
	// 크면 못지나감
	// 작으면 먹고 그자리 위치
	// 먹는 물고기는 1.가장위 2. 가장왼쪽 물고기가 우선순위를 가짐
	// 상어는 자신의 크기만큼의 물고기개수를 먹을때마다 크기가 1증가됨
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					s = new sshark(i, j, 2, 2);
					map[i][j] = 0;
				}
			}
		}

		int result = 0;
		while (true) {
			int temp = bfs(s.r, s.c);
			if (temp == -1)
				break;
			else
				result += temp;
		}
		System.out.println(result);
	}

	static int bfs(int r, int c) {
		visit = new boolean[N][N];
		Queue<sloc> q = new LinkedList();
		q.add(new sloc(r, c));
		visit[r][c] = true;
		int time = 0;
		while (!q.isEmpty()) {
			if (check(q))
				return time;
			int qsize = q.size();
			time++;
			for (int i = 0; i < qsize; i++) {
				sloc loc = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextR = loc.r + dr[move];
					int nextC = loc.c + dc[move];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
						continue;
					if (visit[nextR][nextC] || s.size < map[nextR][nextC])
						continue;

					q.add(new sloc(nextR, nextC));
					visit[nextR][nextC] = true;
				}
			}
		}
		return -1;
	}

	static boolean check(Queue<sloc> q) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && visit[i][j] == true && s.size > map[i][j]) {
					map[i][j] = 0;
					if (s.need - 1 == 0)
						s = new sshark(i, j, s.size + 1, s.size + 1);
					else
						s = new sshark(i, j, s.size, s.need - 1);
					return true;
				}
			}
		}
		return false;
	}

	static boolean nothingeat() {
		boolean finish = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && map[i][j] < s.size)
					finish = false;
			}
		}
		return finish;
	}

}

class sloc {
	int r;
	int c;

	public sloc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class sshark {
	int size;
	int r;
	int c;
	int need;

	public sshark(int r, int c, int size, int need) {
		this.r = r;
		this.c = c;
		this.size = size;
		this.need = need;
	}
}
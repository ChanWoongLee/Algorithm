package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5213 {
	// 9 : 36 시작
	// 생각 30분
	static int N;
	static int[][] tile;
	static int[][] tileNum;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		tile = new int[N][N * 2];
		tileNum = new int[N][N * 2];
		int line = 0;
		int cnt = 1;
		int need = N;
		for (int i = 0; i < N * N * 2; i += 2) {
			st = new StringTokenizer(bf.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int r = i / (N * 2);
			int c = i % (N * 2);
			tile[r][c] = one;
			tile[r][c + 1] = two;
			tileNum[r][c] = cnt;
			tileNum[r][c + 1] = cnt++;
			line++;
			if (line == need) {
				if (r + 1 < N && need == N)
					tile[r + 1][0] = -1;
				else if (c + 2 < 2 * N)
					tile[r][c + 2] = -1;
				i++;
				line = 0;
				need = need == N ? N - 1 : N;
			}
		}
		ArrayList<Integer>[] graph = new ArrayList[cnt];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N * 2; j++) {
				for (int move = 0; move < 4; move++) {
					int nextR = i + dr[move];
					int nextC = j + dc[move];
					if (check(nextR, nextC) == false)
						continue;
					if (tileNum[nextR][nextC] == tileNum[i][j])
						continue;
					if (tile[nextR][nextC] != tile[i][j])
						continue;
					graph[tileNum[i][j]].add(tileNum[nextR][nextC]);
				}
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[cnt];
		int[] path = new int[cnt];

		q.add(1);
		visit[1] = true;
		int maxNum = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			maxNum = maxNum < now ? now : maxNum;
			for (int i = 0; i < graph[now].size(); i++) {
				int child = graph[now].get(i);
				if (visit[child])
					continue;
				path[child] = now;
				visit[child] = true;
				q.add(child);
			}
		}

		int result = 0;
		ArrayList<Integer> answer = new ArrayList<>();
		while (true) {
			answer.add(maxNum);
			if (maxNum == 1)
				break;
			maxNum = path[maxNum];
		}
		System.out.println(answer.size());
		for (int i = answer.size() - 1; i >= 0; i--)
			System.out.print(answer.get(i) + " ");
	}

	static boolean check(int nextR, int nextC) {
		if (nextR >= N || nextC >= N * 2 || nextR < 0 || nextC < 0)
			return false;
		if (tile[nextR][nextC] == -1)
			return false;
		return true;
	}
}

class Block {
	int r, c, num;

	public Block(int r, int c, int num) {
		this.r = r;
		this.c = c;
		this.num = num;

	}
}
package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4197 {
	static int N, M;
	static String[][] map;
	static boolean[][] fireVisit;
	static boolean[][] jihunVisit;
	static int result = Integer.MAX_VALUE;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<escape> fire = new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		fireVisit = new boolean[N][M];
		jihunVisit = new boolean[N][M];
		escape jihun = null;
		if (N == 1 && M == 1) {
			System.out.println("1");
			return;
		}
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("J"))
					jihun = new escape(i, j);
				if (map[i][j].equals("F"))
					fire.add(new escape(i, j));
			}
		}

		Queue<escape> q = new LinkedList();
		Queue<escape> j = new LinkedList();
		j.add(jihun);
		for (int i = 0; i < fire.size(); i++) {
			q.add(new escape(fire.get(i).r, fire.get(i).c));
			fireVisit[fire.get(i).r][fire.get(i).c] = true;
		}
		int time = 0;
		jihunVisit[jihun.r][jihun.c] = true;
		while (!q.isEmpty() || !j.isEmpty()) {
			int fsize = q.size();
			int jsize = j.size();
			time++;
			for (int i = 0; i < jsize; i++) {
				escape nowJihun = j.poll();
				if (fireVisit[nowJihun.r][nowJihun.c] == true)
					continue;
				for (int move = 0; move < 4; move++) {
					int nextR = nowJihun.r + dr[move];
					int nextC = nowJihun.c + dc[move];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
						System.out.println(time);
						return;
					}
					if (map[nextR][nextC].equals("#") || jihunVisit[nextR][nextC] == true
							|| fireVisit[nextR][nextC] == true)
						continue;

					jihunVisit[nextR][nextC] = true;
					j.add(new escape(nextR, nextC));
				}
			}
			for (int i = 0; i < fsize; i++) {
				escape now = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
						continue;
					if (map[nextR][nextC].equals("#") || fireVisit[nextR][nextC] == true)
						continue;
					jihunVisit[nextR][nextC] = true;
					fireVisit[nextR][nextC] = true;
					q.add(new escape(nextR, nextC));
				}

			}
		}

		System.out.println("IMPOSSIBLE");
	}

}

class escape {
	int r, c;

	public escape(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
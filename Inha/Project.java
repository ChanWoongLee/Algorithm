package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Project {
	static int N;
	static int[][] map;
	static int[][] possible;
	static int result = 0;
	static int[] dr = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		possible = new int[N][N];
		backTracking(0, 0);
		System.out.println(result);
	}

	static void backTracking(int index, int cnt) {
		if (cnt == N+1) {
			result++;
			return;
		}
		for (int i = index; i < N * N; i++) {
			if (possible[i / N][i % N] != 0)// ���� ���� ���� �ڸ���� �����ڸ����� �ٽð˻�(i++)
				continue;
			// ���� �װ��� �Ѽ� �ִٸ�
			check(i, i);// �ش� �ڸ��� queen�ΰ� ���� �ִ°��� visit�� üũ���ش�.
			backTracking(i + 1, cnt + 1);// ���� queen�� ���� �ִ°��� Ž���Ѵ�.
			check(i, 0); // Ž���� ���� queen�̹Ƿ� visit�� false�� �ٲ��ش�.
		}
	}

	static void check(int index, int num) {
		int r = index / N;
		int c = index % N;
		possible[r][c] = num;
		for (int i = 0; i < 8; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			while (true) {
				if (nextR >= N || nextR < 0 || nextC < 0 || nextC >= N)
					break;
				if (num == 0 && possible[nextR][nextC] != index) {
					nextR += dr[i];
					nextC += dc[i];
					continue;
				}
				if (num != 0 && possible[nextR][nextC] != 0) {
					nextR += dr[i];
					nextC += dc[i];
					continue;
				}
				possible[nextR][nextC] = num;
				nextR += dr[i];
				nextC += dc[i];
			}
		}
	}
}

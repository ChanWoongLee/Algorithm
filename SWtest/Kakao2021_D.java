package SummerCoding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Kakao2021_D {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
		int[][] board2 = { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } };
		System.out.println(solution(board2));
	}

	static public int solution(int[][] board) {
		int answer = 0;
		N = board.length;

		Car now = new Car(0, 0, 0, -1);
		Queue<Car> q = new LinkedList();
		int[][] visit = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		visit[0][0] = 0;
		q.add(now);

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.r == N - 1 && now.c == N - 1)
				continue;
			for (int move = 0; move < 4; move++) {
				if (now.dir != -1 && (now.dir + 2) % 4 == move)
					continue;

				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				// 범위 및 벽확인
				if (nextR >= N || nextR < 0 || nextC >= N || nextC < 0 || board[nextR][nextC] == 1)
					continue;
				if (now.dir == -1) {
					q.add(new Car(nextR, nextC, now.money + 100, move));
					visit[nextR][nextC] = now.money + 100;
				} else {
					int predicMoney = 0;
					if (now.dir == move)
						predicMoney = now.money + 100;
					else
						predicMoney = now.money + 500 + 100;

					if (visit[nextR][nextC] >= predicMoney) {
						q.add(new Car(nextR, nextC, predicMoney, move));
						visit[nextR][nextC] = predicMoney;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == Integer.MAX_VALUE)
						System.out.print("0000 ");
					else
						System.out.print(visit[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		return visit[N - 1][N - 1];
	}
}

class Car {
	int r, c, money, dir;

	public Car(int r, int c, int money, int dir) {
		this.r = r;
		this.c = c;
		this.money = money;
		this.dir = dir;
	}
}
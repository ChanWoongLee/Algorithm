package Inha;

import java.util.Scanner;

public class BackTracking_NQ {
	public static int N;
	public static int count = 0;
	public static boolean find;
	public static int[] col;
	static long startTime;
	static long finishTime;
	static int time = 1000000;

	public static void main(String[] args) {
		System.out.println("12151611 이찬웅 설계 프로젝트 -backtracking-");
		N = 17;
		col = new int[N + 1]; // N * N 행렬이기에 열도 인덱스를 N 까지 갖을 수 있게 한다.
		find = false;
		startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로 반환
		backTracking(1);
		finishTime = System.currentTimeMillis();
		System.out.println("N = " + N + " 일때 걸린시간 : " + (finishTime - startTime) + "ms");
		// 출력을 위한 board 판
		String board[][] = new String[N + 1][N + 1];
		// 먼저 크기만큼 board를 string 선언
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				board[x][y] = "";
			}
		}
		// thisChromo의 row의 값인 열에 Q를 대입한다.
		for (int x = 1; x <= N; x++) {
			board[x][col[x]] = "Q";
		}
		// 찾은결과를 출력
		System.out.println("Board:");
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				if (board[x][y] == "Q") {
					System.out.print("Q ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.print("\n");
		}
	}

	static void backTracking(int row) {
		if (find)
			return;
		if (row == N + 1) { // 만약 모든 N행까지 돌을 놓았다면 N*N에 queen이 N이 있으므로
			find = true;
			return;
		}
		for (int i = 1; i <= N; i++) {// 해당행에 1 부터 N열까지 놓아보기위해 for문
			finishTime = System.currentTimeMillis();
			if (time == (finishTime - startTime)) {
				System.out.println("현재 " + time + "ms 경과");
				time += 1000000;
			} // 10000ms단위로 시간경과시 출력
			col[row] = i; // row행 i열에 퀸을 놓았다는 의미
			if (isPossible(row)) { // 해당행,열에 퀸을 놓을수 있는지 확인
				backTracking(row + 1);// 가능하다면 다음 행으로 재귀함수 진행
				if (find)
					return;
			}
		}
	}

	public static boolean isPossible(int row) {
		// 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.

		for (int i = 1; i < row; i++) {
			// i 행과 row 행의 열 값이 같으면 퀸을 놓을수 없다.
			if (col[i] == col[row])
				return false;
			// i 행과 row 행의 열값이 대각선에 위치하는 절대값이면 안된다.
			if (Math.abs(i - row) == Math.abs(col[i] - col[row]))
				return false;
		}
		return true;
	}
}
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
		System.out.println("12151611 ������ ���� ������Ʈ -backtracking-");
		N = 17;
		col = new int[N + 1]; // N * N ����̱⿡ ���� �ε����� N ���� ���� �� �ְ� �Ѵ�.
		find = false;
		startTime = System.currentTimeMillis(); // ���� �ý��� �ð��� �и������������ ��ȯ
		backTracking(1);
		finishTime = System.currentTimeMillis();
		System.out.println("N = " + N + " �϶� �ɸ��ð� : " + (finishTime - startTime) + "ms");
		// ����� ���� board ��
		String board[][] = new String[N + 1][N + 1];
		// ���� ũ�⸸ŭ board�� string ����
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				board[x][y] = "";
			}
		}
		// thisChromo�� row�� ���� ���� Q�� �����Ѵ�.
		for (int x = 1; x <= N; x++) {
			board[x][col[x]] = "Q";
		}
		// ã������� ���
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
		if (row == N + 1) { // ���� ��� N����� ���� ���Ҵٸ� N*N�� queen�� N�� �����Ƿ�
			find = true;
			return;
		}
		for (int i = 1; i <= N; i++) {// �ش��࿡ 1 ���� N������ ���ƺ������� for��
			finishTime = System.currentTimeMillis();
			if (time == (finishTime - startTime)) {
				System.out.println("���� " + time + "ms ���");
				time += 1000000;
			} // 10000ms������ �ð������ ���
			col[row] = i; // row�� i���� ���� ���Ҵٴ� �ǹ�
			if (isPossible(row)) { // �ش���,���� ���� ������ �ִ��� Ȯ��
				backTracking(row + 1);// �����ϴٸ� ���� ������ ����Լ� ����
				if (find)
					return;
			}
		}
	}

	public static boolean isPossible(int row) {
		// 1����� row ����� ���� �� Ȥ�� �밢���� ��ġ�ϴ� ���� �ִ��� Ȯ���Ѵ�.

		for (int i = 1; i < row; i++) {
			// i ��� row ���� �� ���� ������ ���� ������ ����.
			if (col[i] == col[row])
				return false;
			// i ��� row ���� ������ �밢���� ��ġ�ϴ� ���밪�̸� �ȵȴ�.
			if (Math.abs(i - row) == Math.abs(col[i] - col[row]))
				return false;
		}
		return true;
	}
}
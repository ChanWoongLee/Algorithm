package AlgoStudy;

import java.util.Scanner;

public class Algospot_Board {
	public static void main(String[] args) {
		int[][] board;
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String result = "";
		for (int j = 0; j < count; j++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			board = new int[y][x];
			for (int a = 0; a < y; a++) {
				String line = sc.next();
				for (int b = 0; b < x; b++) {
					board[a][b] = (line.charAt(b) == '#') ? 1 : 0;
				}
			}
			result += (j + 1 == count) ? cover(board) : cover(board) + "\n";
		}
		System.out.println(result);

	}

	static int coverType[][][] = { { { 0, 0 }, { 1, 0 }, { 0, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, -1 } } };

	private static boolean set(int[][] board, int y, int x, int type, int delta) {

		boolean ok = true;
		for (int i = 0; i < 3; i++) {
			int ny = y + coverType[type][i][0];
			int nx = x + coverType[type][i][1];
			if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length)
				ok = false;
			else if ((board[ny][nx] += delta) > 1)
				ok = false;

		}

		return ok;

	}

	private static int cover(int[][] board) {

		int y = -1, x = -1;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if (y != -1)
				break;
		}

		if (y == -1)
			return 1;

		int ret = 0;
		for (int type = 0; type < 4; type++) {
			if (set(board, y, x, type, 1))
				ret += cover(board);
			set(board, y, x, type, -1);
		}

		return ret;
	}
}
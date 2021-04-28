package SWtest;

public class JOB_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int[] col;
	static int answer;
	static int[][] map;

	public int solution(int[][] board) {
		answer = 0;
		map = board;
		int n = board.length;
		for (int i = 0; i < n; ++i) {
			col = new int[n];
			col[0] = i;
			backtracking(n, 1, map[0][i]);
		}

		return answer;
	}

	private void backtracking(int max, int row, int sum) {
		if (row == max) {
			answer = answer < sum ? sum : answer;
			col[row - 1] = 0;
			return;
		}

		for (int i = 0; i < max; ++i) {
			col[row] = i;
			if (isPossible(row)) {
				backtracking(max, row + 1, sum + map[row][i]);
			} else {
				col[row] = 0;
			}
		}
		col[row] = 0;
	}

	private boolean isPossible(int row) {
		for (int i = 0; i < row; ++i) {
			if (col[i] == col[row])
				return false;
		}

		return true;
	}
}

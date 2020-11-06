package LeetCode;

public class L240 {

	public static void main(String[] args) {
	}

	static public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;

		int N = matrix.length;
		int M = matrix[0].length;
		int i = 0, j = 0;
		while (true) {
			if (matrix[i][j] == target)
				return true;
			else {
				if (matrix[i][j] > target) {
					i--;
					j--;
					break;
				} else {
					if (i + 1 >= N || j + 1 >= M)
						break;
					i++;
					j++;
				}
			}
		}
		if (i < 0 || j < 0)
			return false;
		for (int search = i; search < N; search++) {
			if (target == matrix[search][j])
				return true;
		}
		for (int search = j; search < M; search++) {
			if (target == matrix[i][search])
				return true;
		}
		return false;
	}
}

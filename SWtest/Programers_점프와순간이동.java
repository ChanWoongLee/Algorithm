package SummerCoding;

public class Programers_점프와순간이동 {

	public static void main(String[] args) {

	}

	static int dfs(int n, int res) {
		if (n == 0)
			return res;

		if (n % 2 == 0)
			return dfs(n / 2, res);
		else {
			return dfs(n - 1, res + 1);
		}
	}

	public int solution(int n) {
		return dfs(n, 0);
	}
}

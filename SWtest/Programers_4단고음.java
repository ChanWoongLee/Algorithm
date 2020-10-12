package SummerCoding;

public class Programers_4´Ü°íÀ½ {
	public static void main(String[] args) {

	}

	static int dfs(int n, int addCnt) {
		if (Math.pow(3, addCnt / 2) > n)
			return 0;
		int res = 0;
		if (n == 3) {
			if (addCnt == 2)
				return 1;
		} else if (n > 3) {
			if (n % 3 == 0 && addCnt == 2)
				res += dfs(n / 3, addCnt - 2);
			res += dfs(n - 1, addCnt + 1);
		}
		return res;
	}

	public int solution(int n) {
		return dfs(n, 0);
	}
}

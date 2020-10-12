package SummerCoding;

public class Cp1 {

	public static void main(String[] args) {
		int[] ans = solution(10);
		System.out.println(ans[0] + " "+ans[1]);
	}

	static public int[] solution(int N) {
		int max = 0;
		int maxNum = 0;
		for (int i = 9; i >= 2; i--) {
			int num = N;
			int multi = 1;
			while (num > 0) {
				int now = (num % i);
				if (now != 0)
					multi *= now;
				num /= i;
			}
			if (multi > max) {
				max = multi;
				maxNum = i;
			}
		}
		return new int[] { maxNum, max };
	}
}
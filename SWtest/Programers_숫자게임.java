package SummerCoding;

public class Programers_숫자게임 {
	// 3 : 34
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7,10}));
	}
	// 시간을 보니 times 횟수만에 답을 내야됨  -> 그러면 times로 어떻게 답을 도출할꺼냐 ??
	// 생각생각생각 이 더해져
	// 총시간이 있을때 times 로 나눈 만큼은 무조건 통과니까 이런식으로 이분탐색을 진행!!!!
	static public long solution(int n, int[] times) {
		long left = 0;
		long right = Long.MAX_VALUE;
		long middle = 0;
		long people = 0;
		while (left <= right) {
			people = 0;
			middle = (left + right) / 2;
			for (int i = 0; i < times.length; i++) {
				people += middle / times[i];
				if (people > n)
					break;
			}
			if (people >= n) {
				right = middle - 1;
			} else if (people < n) {
				left = middle + 1;
			}
		}

		return left;
	}
}

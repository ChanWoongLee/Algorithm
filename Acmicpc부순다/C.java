package AcmicpcºÎ¼ø´Ù;

import java.util.Arrays;

public class C {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000}));
	}

	static public int solution(int[] A) {
		int answer = 0;
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			answer += Math.abs(A[i] - (i + 1));
			if (answer > 1000000000)
				return -1;
		}

		return answer;
	}
}

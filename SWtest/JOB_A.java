package SWtest;

public class JOB_A {

	public static void main(String[] args) {

	}

	public int solution(int[] openA, int[] closeB) {
		int answer = 0;
		int B = 0;
		int nowA = 0;
		int nowB = 0;
		for (int A = 0; A < openA.length; A++) {
			nowA = openA[A];
			if (nowA < nowB)
				continue;
			while (closeB[B] < nowA) {
				B++;
			}
			nowB = closeB[B];
			answer += nowB - nowA;
		}
		return answer;
	}
}

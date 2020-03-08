package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B14888 {// 연산자 끼워넣기
	static int[] num;
	static int[] oper; // + , -, *, /
	static boolean[] btr;
	static int[] temp;
	static int maxresult = -Integer.MAX_VALUE;
	static int minresult = Integer.MAX_VALUE;

	// 2시 40 분 시작
	// 바로 순열 임을 인지
	// 문제의 특성에따라 구현력에 달려있는문제
//	private static void solution(int index, int sum, int plus, int minus, int mult, int div){
//		if(index == N){
//			max = Math.max(max, sum);
//			min = Math.min(min, sum);
//		}
//		
//		if(plus > 0)
//			solution(index + 1, sum + numbers[index], plus - 1, minus, mult, div);
//		if(minus > 0)
//			solution(index + 1, sum - numbers[index], plus, minus - 1, mult, div);
//		if(mult > 0)
//			solution(index + 1, sum * numbers[index], plus, minus, mult - 1, div);
//		if(div > 0)
//			solution(index + 1, sum / numbers[index], plus, minus, mult, div - 1);
//	} 이런 대박 솔루션도잇음
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		oper = new int[N-1];
		btr = new boolean[N-1];
		temp = new int[N-1];
		st = new StringTokenizer(bf.readLine());
		int index = 0;
		int operation = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for (int k = 0; k < cnt; k++) {
				oper[index] = operation;
				index++;
			}
			operation++;
		}
		for (int i = 0; i < N - 1; i++) {
			btr[i] = true;
			dfs(i, 0);
			btr[i] = false;
		}
		System.out.println(maxresult);
		System.out.println(minresult);
	}

	static void dfs(int index, int cnt) {
		temp[cnt] = oper[index];
		if (cnt == btr.length-1) {
			int value = num[0];
			for (int i = 1; i < num.length; i++) {
				if (temp[i - 1] == 0)
					value += num[i];
				if (temp[i - 1] == 1)
					value -= num[i];
				if (temp[i - 1] == 2)
					value *= num[i];
				if (temp[i - 1] == 3)
					value /= num[i];
			}
			maxresult = value > maxresult ? value : maxresult;
			minresult = value < minresult ? value : minresult;
			return;
		}

		for (int i = 0; i < btr.length; i++) {
			if (!btr[i]) {
				btr[i] = true;
				dfs(i, cnt + 1);
				btr[i] = false;
			}
		}
	}
}

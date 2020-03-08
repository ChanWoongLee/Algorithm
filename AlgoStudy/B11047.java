package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
	static int[] money;
	static long goal;
	static int start;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		money = new int[n];
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			if (m > goal) {
				start = i;
				break;
			} else
				money[i] = m;
		}
		if(start == 0)
			start = money.length;
		recur(0, 0);
	}

	static void recur(int m, int count) {
		if (m > goal)
			return;
		if(m == goal) {
			System.out.println(count);
			System.exit(0);
		}
		for (int i = start - 1; i >= 0; i--) {
			int mon = m + money[i];
			recur(mon, count + 1);
		}
	}
}

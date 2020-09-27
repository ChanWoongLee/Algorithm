package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_2 {
	static int[] line0 = { 0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int now = 0;
		for (int i = 0; i < n; i++) {
			int move = Integer.parseInt(st.nextToken());
			int nextMove = now + move;
			if (nextMove >= line0.length) {
				System.out.println("1000");
				return;
			}
			System.out.print(line0[nextMove]+ " ");
			now = nextMove;
		}
	}

}

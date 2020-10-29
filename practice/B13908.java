package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13908 {
	static ArrayList<Integer> temp;
	static int[] known;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		known = new int[M];
		temp = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			known[i] = Integer.parseInt(st.nextToken());
		}
		recur(0, N);
		System.out.println(answer);
	}

	static void recur(int cnt, int maxCnt) {
		if (maxCnt == cnt) {
			for (int i = 0; i < known.length; i++) {
				if (!temp.contains(known[i]))
					return;
			}
			answer++;
			return;
		}
		for (int i = 0; i < 10; i++) {
			temp.add(i);
			recur(cnt + 1, maxCnt);
			temp.remove(temp.size() - 1);
		}
	}
}

package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15652 {
	static int N;
	static ArrayList<Integer> ar = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		recur(1, 0, m);
	}

	static void recur(int index, int cnt, int maxCnt) {
		if (cnt == maxCnt) {
			for (int i : ar) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = index; i <= N; i++) {
			if (!ar.isEmpty()  && ar.get(ar.size() - 1) > i)
				continue;
			ar.add(i);
			recur(index, cnt + 1, maxCnt);
			ar.remove(ar.size() - 1);
		}
	}
}

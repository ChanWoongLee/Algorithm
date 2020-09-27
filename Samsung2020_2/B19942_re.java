package Samsung2020_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B19942_re {
	static int result = Integer.MAX_VALUE;
	static int N;
	static int[] temp;
	static Food[] food;
	static Food want;
	static ArrayList<Integer> resultAr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		resultAr = new ArrayList<>();
		want = new Food();
		String[] str = bf.readLine().split(" ");
		want.p = Integer.parseInt(str[0]);
		want.f = Integer.parseInt(str[1]);
		want.s = Integer.parseInt(str[2]);
		want.v = Integer.parseInt(str[3]);
		food = new Food[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			food[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		int[][] dp = new int[][];
		for(int i = 0; i < )
		
		if (result == Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
		System.out.println(result);
		Collections.sort(resultAr);
		for (int r : resultAr)
			System.out.print((r + 1) + " ");
	}

	static void recur(int idx, int cnt, int maxCnt) {
		if (cnt == maxCnt) {
			ArrayList<Integer> ar = new ArrayList<>();
			int nowP = 0;
			int nowF = 0;
			int nowS = 0;
			int nowV = 0;
			int price = 0;
			for (int i = 0; i < temp.length; i++) {
				nowP += food[temp[i]].p;
				nowF += food[temp[i]].f;
				nowS += food[temp[i]].s;
				nowV += food[temp[i]].v;
				price += food[temp[i]].price;
				ar.add(temp[i]);
			}
			if (want.p > nowP || want.f > nowF || want.s > nowS || want.v > nowV)
				return;
			if (result >= price) {
				if(result == price && ar.size() >= resultAr.size()) {
					resultAr.clear();
					for (int a : ar)
						resultAr.add(a);
					return;
				}
				result = price;
				resultAr.clear();
				for (int a : ar)
					resultAr.add(a);
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			temp[cnt] = i;
			recur(i + 1, cnt + 1, maxCnt);
		}
	}

	static class Food {
		int p, f, s, v, price;

		public Food(int p, int f, int s, int v, int price) {
			super();
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.price = price;
		}

		public Food() {
		}

	}
}

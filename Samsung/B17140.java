package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B17140 {
	// 1 시 3분 시작
	static int R, C, K;
	static int[][] map;
	static int itm = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken()) - 1;
		C = Integer.parseInt(st.nextToken()) - 1;
		K = Integer.parseInt(st.nextToken());
		map = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (map.length > R && map[0].length > C && map[R][C] == K) {
			System.out.println("0");
			System.exit(0);
		}
		int result = 0;
		for (int i = 1; i <= 100; i++) {
			if (map.length >= map[0].length)
				Roper();
			else
				Loper();

			if (map.length > R && map[0].length > C && map[R][C] == K) {
				result = i;
				break;
			}

		}
		if (result == 0)
			System.out.println("-1");
		else
			System.out.println(result);

	}

	static void Roper() {
		ArrayList<pair>[] ar = new ArrayList[map.length];
		for (int i = 0; i < ar.length; i++)
			ar[i] = new ArrayList();

		int maxC = 0;
		int index = 0;
		for (int[] m : map) {
			int[] cnt = new int[101];
			for (int v : m) {
				if (v == 0)
					continue;
				cnt[v]++;
			}
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] != 0)
					ar[index].add(new pair(i, cnt[i]));
			}
			Collections.sort(ar[index]);
			if (maxC < ar[index].size() * 2) {
				maxC = ar[index].size() * 2;
				if (maxC >= 100)
					maxC = 100;
			}
			index++;
		}
		map = new int[map.length][maxC];
		for (int i = 0; i < map.length; i++) {
			int k = 0;
			int temp = ar[i].size();
			if (ar[i].size() > 50)
				temp = 50;
			for (int j = 0; j < temp; j++) {
				pair now = ar[i].get(j);
				map[i][k] = now.num;
				k++;
				map[i][k] = now.cnt;
				k++;
			}
		}
	};

	static void Loper() {
		ArrayList<pair>[] ar = new ArrayList[map[0].length];
		for (int i = 0; i < ar.length; i++)
			ar[i] = new ArrayList();

		int maxR = 0;
		int index = 0;
		for (int i = 0; i < map[0].length; i++) {
			int[] cnt = new int[101];
			for (int j = 0; j < map.length; j++) {
				if (map[j][i] == 0)
					continue;
				cnt[map[j][i]]++;
			}
			for (int k = 0; k < cnt.length; k++) {
				if (cnt[k] != 0)
					ar[index].add(new pair(k, cnt[k]));
			}
			Collections.sort(ar[index]);
			if (maxR < ar[index].size() * 2) {
				maxR = ar[index].size() * 2;
				if (maxR >= 100)
					maxR = 100;
			}
			index++;
		}
		map = new int[maxR][map[0].length];
		for (int i = 0; i < map[0].length; i++) {
			int k = 0;
			int temp = ar[i].size();
			if (ar[i].size() > 50)
				temp = 50;
			for (int j = 0; j < temp; j++) {
				pair now = ar[i].get(j);
				map[k][i] = now.num;
				k++;
				map[k][i] = now.cnt;
				k++;
			}
		}
	};

}

class pair implements Comparable<pair> {
	int num;
	int cnt;

	public pair(int n, int c) {
		num = n;
		cnt = c;
	}

	@Override
	public int compareTo(pair arg0) {
		if (this.cnt == arg0.cnt)
			return this.num - arg0.num;
		return this.cnt - arg0.cnt;
	}
}

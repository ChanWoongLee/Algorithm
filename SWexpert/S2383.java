package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S2383 {
	// 12 20
	static int size, result;
	static int[][] map;
	static ArrayList<person> per = new ArrayList();
	static ArrayList<stair> s = new ArrayList();
	static int[] door;

	// 논리력 싸움에서 진문제 ..
	// 3명씩 들어간 문에는 안들어가는데 자신도 못들어감
	// 한명 나왔을 때 한명이 들어가야함 list에서 index로 비교하면 못함
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(bf.readLine());
			size = Integer.parseInt(st.nextToken());// N
			map = new int[size][size];
			per.clear();
			s.clear();
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0)
						continue;
					if (map[i][j] == 1)
						per.add(new person(i, j, 0, 0, 0));
					else
						s.add(new stair(i, j, map[i][j]));
				}
			}
			door = new int[per.size()];
			dfs(0);

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void dfs(int index) {
		if (index == per.size()) {
			solve();
			return;
		}
		for (int i = 0; i < s.size(); i++) {
			door[index] = i;
			dfs(index + 1);
		}
	}

	static void solve() {
		int[] instair = new int[s.size()];
		ArrayList<person> p = new ArrayList();
		for (int i = 0; i < per.size(); i++) {
			int r = per.get(i).r;
			int c = per.get(i).c;
			int s = per.get(i).stair;
			int d = per.get(i).distance;
			int dow = per.get(i).downing;
			p.add(new person(r, c, d, s, dow));
		}
		for (int i = 0; i < door.length; i++) {
			int d = door[i];
			p.get(i).distance = Math.abs(p.get(i).r - s.get(d).r) + Math.abs(p.get(i).c - s.get(d).c);
			p.get(i).stair = d;
			p.get(i).downing = s.get(d).len;
		}
		int res = 0;
		while (!p.isEmpty()) {
			Collections.sort(p);
//			for(person aa : p) {
//				System.out.println(aa.downing + " " + aa.distance);
//			}System.out.println();
			res++;
			if (res >= result)
				break;
			for (int i = 0; i < p.size(); i++) {
				int stiarIndex = p.get(i).stair;
				int distance = p.get(i).distance;
				int down = p.get(i).downing;

				if (down == 0) {
					instair[stiarIndex]--;
					p.remove(i);
					i--;
					continue;
				} // 내려온사람 체크
				if (distance != 0) {
					p.get(i).distance--;
				} // 아직 문까지 가는중
				else {
					if (s.get(stiarIndex).len == down) {
						if (instair[stiarIndex] == 3)
							continue; // 3명이 차있음 기다려야뎀
						instair[p.get(i).stair]++;
						p.get(i).downing--;
					} // 처음 입구 있을때 instair 올리기위해
					else
						p.get(i).downing--;
				}
			}
		}
		result = res;
	}
}

class person implements Comparable<person> {
	int r, c, distance, stair, downing;

	public person(int r, int c, int distance, int stair, int downing) {
		this.r = r;
		this.c = c;
		this.distance = distance;
		this.stair = stair;
		this.downing = downing;
	}

	@Override
	public int compareTo(person arg0) {
		return this.downing -arg0.downing;
	}

}

class stair {
	int r, c, len;

	public stair(int r, int c, int len) {
		this.r = r;
		this.c = c;
		this.len = len;
	}
}
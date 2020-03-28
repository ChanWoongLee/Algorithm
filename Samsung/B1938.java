import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1938 {
	// 11시 5분 시작
	static int N;
	static String map[][];
	static int[][] Rwoodtype = { { -1, 0 }, { 0, 1 } };
	static int[][] Cwoodtype = { { 1, 0 }, { 0, -1 } };
	static int[] aroundR = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] aroundC = { 0, 0, 1, -1, -1, 1, -1, 1 };
	static boolean[][][] visit;

	// type 0 type 1 ㅡㅡㅡ
	// |
	// |
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new String[N][N];
		ArrayList<Tongwood> init = new ArrayList();
		ArrayList<Tongwood> end = new ArrayList();
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("B")) {
					init.add(new Tongwood(i, j));
					map[i][j] = "0";
				}
				if (map[i][j].equals("E")) {
					end.add(new Tongwood(i, j));
				}
			}
		}
		Queue<total> q = new LinkedList();
		q.add(new total(init, checkType(init), 0));
		visit = new boolean[N][N][2];
		visit[init.get(1).r][init.get(1).c][checkType(init)] = true;
		while (!q.isEmpty()) {
			total now = q.poll();
			// String[][] mapClone = new String[N][N];
			// for (int i = 0; i < N; i++) {
			// mapClone[i] = Arrays.copyOf(map[i], N);
			// }
			// for (Tongwood t : now.ar) {
			// mapClone[t.r][t.c] = "B";
			// }
			// for(int i = 0; i < N; i++) {
			// for(int j = 0; j < N; j++) {
			// System.out.print(mapClone[i][j]);
			// }System.out.println();
			// }System.out.println();
			// System.out.println(now.ar.get(1).r + ", " + now.ar.get(1).c + ", " +
			// now.type);
			if (endcheck(now.ar, end)) {
				System.out.println(now.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				if (checkMove(now.ar, now.type, i)) {// U D R L
					ArrayList<Tongwood> temp = new ArrayList();
					for (Tongwood t : now.ar) {
						temp.add(new Tongwood(t.r + aroundR[i], t.c + aroundC[i]));
					}
					q.add(new total(temp, now.type, now.cnt + 1));
					visit[temp.get(1).r][temp.get(1).c][now.type] = true;
				}
			}
			if (checkRotate(now.ar, now.type)) {
				ArrayList<Tongwood> temp = new ArrayList();
				for (Tongwood t : now.ar) {
					temp.add(new Tongwood(t.r, t.c));
				}
				if (now.type == 0) {
					temp.set(0, new Tongwood(temp.get(0).r + 1, temp.get(0).c - 1));
					temp.set(2, new Tongwood(temp.get(2).r - 1, temp.get(2).c + 1));
				} else {
					temp.set(0, new Tongwood(temp.get(0).r - 1, temp.get(0).c + 1));
					temp.set(2, new Tongwood(temp.get(2).r + 1, temp.get(2).c - 1));
				}
				q.add(new total(temp, now.type == 0 ? 1 : 0, now.cnt + 1));
				visit[temp.get(1).r][temp.get(1).c][now.type == 0 ? 1 : 0] = true;
			}
		}
		System.out.println("0");
	}

	static boolean endcheck(ArrayList<Tongwood> ar, ArrayList<Tongwood> end) {
		for (int i = 0; i < 3; i++) {
			if (!(ar.get(i).r == end.get(i).r && ar.get(i).c == end.get(i).c))
				return false;
		}
		return true;
	}

	static boolean checkRotate(ArrayList<Tongwood> ar, int type) {
		if (visit[ar.get(1).r][ar.get(1).c][type == 0 ? 1 : 0])
			return false;
		for (int i = 0; i < 8; i++) {
			if (ar.get(1).r + aroundR[i] < 0 || ar.get(1).r + aroundR[i] >= N)
				return false;
			if (ar.get(1).c + aroundC[i] < 0 || ar.get(1).c + aroundC[i] >= N)
				return false;
			if (map[ar.get(1).r + aroundR[i]][ar.get(1).c + aroundC[i]].equals("1"))
				return false;
		}
		return true;
	}

	static boolean checkMove(ArrayList<Tongwood> ar, int type, int i) {
		for (Tongwood t : ar) {
			int nextR = t.r + aroundR[i];
			int nextC = t.c + aroundC[i];
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
				return false;
			if (map[nextR][nextC].equals("1"))
				return false;
		}
		if (visit[ar.get(1).r + aroundR[i]][ar.get(1).c + aroundC[i]][type])
			return false;
		return true;

	}

	static int checkType(ArrayList<Tongwood> ar) {
		int a = ar.get(0).r - ar.get(1).r;
		if (a == 0)
			return 1;
		else
			return 0;
	}
}

class total {
	ArrayList<Tongwood> ar = null;
	int type, cnt;

	public total(ArrayList<Tongwood> ar, int type, int cnt) {
		this.ar = ar;
		this.type = type;
		this.cnt = cnt;
	}
}

class Tongwood {
	int r, c, cnt;

	public Tongwood(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

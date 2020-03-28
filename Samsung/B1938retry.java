package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1938retry {
	// 11시 5분 시작
	static int N;
	static String map[][];
	static int[][][] type = { { { 0, -1 }, { 0, 0 }, { 0, 1 } }, { { -1, 0 }, { 0, 0 }, { 1, 0 } } };
	// [type 을 뜻함 0일때 ㅡㅡㅡ][왼쪽 또는 위에 있는 칸을 뜻함][r 과 c 가 움 직이는 값을 뜻함]
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
		ArrayList<Tongwood> ar = new ArrayList();
		ArrayList<Tongwood> ar2 = new ArrayList();
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("B")) {
					ar.add(new Tongwood(i, j, 0, 0));
				}
				if (map[i][j].equals("E")) {
					ar2.add(new Tongwood(i, j, 0, 0));
				}
			}
		}
		Tongwood init = null;
		Tongwood end = null;
		if (ar.get(0).r - ar.get(1).r == 0)
			init = new Tongwood(ar.get(1).r, ar.get(1).c, 0, 0);
		else
			init = new Tongwood(ar.get(1).r, ar.get(1).c, 1, 0);

		if (ar2.get(0).r - ar2.get(1).r == 0)
			end = new Tongwood(ar2.get(1).r, ar2.get(1).c, 0, 0);
		else
			end = new Tongwood(ar2.get(1).r, ar2.get(1).c, 1, 0);

		Queue<Tongwood> q = new LinkedList();
		q.add(init);
		visit = new boolean[N][N][2];
		visit[init.r][init.c][init.type] = true;
		while (!q.isEmpty()) {
			Tongwood now = q.poll();
			String[][] mapClone = new String[N][N];
//			for (int i = 0; i < N; i++) {
//				mapClone[i] = Arrays.copyOf(map[i], N);
//			}
//			for (int wood = 0; wood < 3; wood++) {
//				int besideR = now.r + type[now.type][wood][0];
//				int besideC = now.c + type[now.type][wood][1];
//				mapClone[besideR][besideC] = "B";
//			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(mapClone[i][j]);
//				}
//				System.out.println();
//			}System.out.println();
			if (now.r == end.r && now.c == end.c && now.type == end.type) {
				System.out.println(now.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				if (checkMove(now, i)) {// U D R L
					q.add(new Tongwood(now.r + aroundR[i], now.c + aroundC[i], now.type, now.cnt + 1));
					visit[now.r + aroundR[i]][now.c + aroundC[i]][now.type] = true;
				}
			}
			if (checkRotate(now)) {
				q.add(new Tongwood(now.r, now.c, now.type == 0 ? 1 : 0, now.cnt + 1));
				visit[now.r][now.c][now.type == 0 ? 1 : 0] = true;
			}
		}
		System.out.println("0");
	}

	static boolean checkRotate(Tongwood now) {
		for (int i = 0; i < 8; i++) {
			if (now.r + aroundR[i] < 0 || now.r + aroundR[i] >= N)
				return false;
			if (now.c + aroundC[i] < 0 || now.c + aroundC[i] >= N)
				return false;
			if (map[now.r + aroundR[i]][now.c + aroundC[i]].equals("1"))
				return false;
		}
		if (visit[now.r][now.c][now.type == 0 ? 1 : 0])
			return false;

		return true;
	}

	static boolean checkMove(Tongwood now, int move) {
		for (int wood = 0; wood < 3; wood++) {
			int besideR = now.r + type[now.type][wood][0] + aroundR[move];
			int besideC = now.c + type[now.type][wood][1] + aroundC[move];
			if (besideR < 0 || besideR >= N || besideC < 0 || besideC >= N)
				return false;
			if (map[besideR][besideC].equals("1"))
				return false;
			if (wood == 1 && visit[besideR][besideC][now.type])
				return false;
		}
		return true;
	}

}

class Tongwood {
	int r, c, type, cnt;

	public Tongwood(int r, int c, int type, int cnt) {
		this.r = r;
		this.c = c;
		this.type = type;
		this.cnt = cnt;
	}
}

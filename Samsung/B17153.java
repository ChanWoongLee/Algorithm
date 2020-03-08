package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17153 {
	// 10 : 33 시작
	// 1시간 40분 정도 걸린듯
	// 자잘한 실수때문에 실패
	// arraylist에서  contain을 확인할때 주소값으로 확인함 일일히 값 비교를 해줘야한다.
	// 백트래킹 + 시뮬레이션 문제
	static int[][] map;
	static loc[] archer;
	static int result = 0;
	static int D;
	static boolean[] tracking;
	static ArrayList<loc> d = new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		archer = new loc[M];
		tracking = new boolean[M];
		for (int i = 0; i < M; i++) {
			archer[i] = new loc(N, i);
		}
		recur(0, 0);
		System.out.println(result);
	}

	static void recur(int index, int cnt) {
		if (cnt == 3) {
			int[][] temp = new int[map.length][map[0].length];
			for (int i = 0; i < map.length; i++) {
				temp[i] = Arrays.copyOf(map[i], map[0].length);
			}
			int count = 0;
			while (!end(temp)) {
				for (int i = 0; i < tracking.length; i++) { // 궁수 배치 및 공격
					if (tracking[i] == true) {
						attack(i, temp);
					}
				}
				count += d.size();
				for (loc dead : d) {
					temp[dead.r][dead.c] = 0;
				}
				d.clear();

				for (int i = map.length - 2; i >= 0; i--) { // 적 전진
					for (int j = 0; j < map[0].length; j++) {
						if (i == 0)
							temp[i][j] = 0;
						else {
							temp[i][j] = temp[i - 1][j];
						}
					}
				}
			}
//			for (int i = 0; i < tracking.length; i++) { // 궁수 배치 및 공격
//				if (tracking[i] == true) {
//					System.out.print(i + " ");
//				}
//			}
			//System.out.println(count);
			result = count > result ? count : result;
			return;
		}
		if (index >= map[0].length)
			return;

		tracking[index] = true;

		recur(index + 1, cnt + 1);
		tracking[index] = false;
		recur(index + 1, cnt);
	}

	static void attack(int index, int[][] temp) { // 공격한것은 빼버림
		loc dead = null;
		int archerR = archer[index].r;
		int archerC = archer[index].c;
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] == 1) { // 적이 있고
					if (distance == Math.abs(i - archerR) + Math.abs(j - archerC)
							&& Math.abs(i - archerR) + Math.abs(j - archerC) <= D) {
						if (dead.c > j) {
							dead = new loc(i, j);
						}
					}
					if (distance > Math.abs(i - archerR) + Math.abs(j - archerC)
							&& Math.abs(i - archerR) + Math.abs(j - archerC) <= D) { // 이제껏 잰 거리보다 작은 거리일때 =은 필수 같은 거리
						// 있을수 있으니
						distance = Math.abs(i - archerR) + Math.abs(j - archerC);
						dead = new loc(i, j);
					}
				}
			}
		}
		if (distance == Integer.MAX_VALUE)
			return;
		for (loc a : d) {
			if (a.r == dead.r && a.c == dead.c)
				return;
		}
		d.add(new loc(dead.r, dead.c));
	}

	static boolean end(int[][] temp) {
		for (int i = 0; i < temp.length - 1; i++) {// 궁수 줄은 뺴고
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] > 0)
					return false;
			}
		}
		return true;
	}
}

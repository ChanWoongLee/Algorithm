package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17153 {
	// 10 : 33 ����
	// 1�ð� 40�� ���� �ɸ���
	// ������ �Ǽ������� ����
	// arraylist����  contain�� Ȯ���Ҷ� �ּҰ����� Ȯ���� ������ �� �񱳸� ������Ѵ�.
	// ��Ʈ��ŷ + �ùķ��̼� ����
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
				for (int i = 0; i < tracking.length; i++) { // �ü� ��ġ �� ����
					if (tracking[i] == true) {
						attack(i, temp);
					}
				}
				count += d.size();
				for (loc dead : d) {
					temp[dead.r][dead.c] = 0;
				}
				d.clear();

				for (int i = map.length - 2; i >= 0; i--) { // �� ����
					for (int j = 0; j < map[0].length; j++) {
						if (i == 0)
							temp[i][j] = 0;
						else {
							temp[i][j] = temp[i - 1][j];
						}
					}
				}
			}
//			for (int i = 0; i < tracking.length; i++) { // �ü� ��ġ �� ����
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

	static void attack(int index, int[][] temp) { // �����Ѱ��� ������
		loc dead = null;
		int archerR = archer[index].r;
		int archerC = archer[index].c;
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] == 1) { // ���� �ְ�
					if (distance == Math.abs(i - archerR) + Math.abs(j - archerC)
							&& Math.abs(i - archerR) + Math.abs(j - archerC) <= D) {
						if (dead.c > j) {
							dead = new loc(i, j);
						}
					}
					if (distance > Math.abs(i - archerR) + Math.abs(j - archerC)
							&& Math.abs(i - archerR) + Math.abs(j - archerC) <= D) { // ������ �� �Ÿ����� ���� �Ÿ��϶� =�� �ʼ� ���� �Ÿ�
						// ������ ������
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
		for (int i = 0; i < temp.length - 1; i++) {// �ü� ���� ����
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] > 0)
					return false;
			}
		}
		return true;
	}
}

package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12100 {
	// 10 : 12 ����!
	// 11 : 40 �� 
	// 1�ð� ���� �ߺ��� for�� ���̱� ���� while���� ����غ��� ������.
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };// �� ������ �Ʒ� ����
	static int[] dc = { 0, 1, 0, -1 };
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				result = map[i][j] > result ? map[i][j] : result;
			}
		}
		int[][] save = new int[size][size];
		for (int i = 0; i < map.length; i++) {
			save[i] = Arrays.copyOf(map[i], map.length);
		}
		recur(0, 0, save);
		recur(1, 0, save);
		recur(2, 0, save);
		recur(3, 0, save);
		System.out.println(result);
	}

	static void recur(int dir, int dep, int[][] save) {
		if (dep == 5) {
			for (int i = 0; i < save.length; i++) {
				for (int j = 0; j < save.length; j++) {
					result = result < save[i][j] ? save[i][j] : result;
				}
			}
			return;
		}
		int[][] save2 = new int[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			save2[i] = Arrays.copyOf(save[i], save.length);
		}
		boolean[][] sum = new boolean[map.length][map.length];
		if (dir == 0 || dir == 3) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (save2[i][j] != 0) {
						int mr = i + dr[dir];
						int mc = j + dc[dir];
						while (true) {
							if (!(mr >= 0 && mr < map.length && mc >= 0 && mc < map.length)) { // �̵��ߴµ� ���� �������� Ÿ�� �̵�
								if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// ���ڸ��� �ƴ϶� ������ �̵��Ҷ� �������� Ÿ���̵�
									save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
									save2[i][j] = 0;
								}
								break;

							}
							if (save2[mr][mc] != 0) {// 0 �̾ƴ� Ÿ�� ��������
								if (save2[mr][mc] == save2[i][j] && sum[mr][mc] == false) {// ���������̸鼭 ��ģ���� ������ ���ڸ��� ��ü
									save2[mr][mc] = save2[i][j] * 2;
									save2[i][j] = 0;
									sum[mr][mc] = true;
								} else {// �ٸ� ���� �϶� �������� Ÿ�� �̵�
									if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// ���ڸ��� �ƴ϶� ������ �̵��Ҷ� �������� Ÿ���̵�
										save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
										save2[i][j] = 0;
									}
								}
								break;
							} else {// 0 �� Ÿ�� ��������.
								mr += dr[dir];
								mc += dc[dir];
							}
						}
					}
				}
			}
			if(Arrays.deepEquals(save2, save))
				return;
			dep +=1;
			for (int i = 0; i < 4; i++) {
				recur(i, dep, save2);
			}
		} else { // ������ ������ �Ʒ��� ����
			for (int i = map.length - 1; i > -1; i--) {
				for (int j = map.length - 1; j > -1; j--) {
					if (save2[i][j] != 0) {
						int mr = i + dr[dir];
						int mc = j + dc[dir];
						while (true) {
							if (!(mr >= 0 && mr < map.length && mc >= 0 && mc < map.length)) { // �̵��ߴµ� ���� �������� Ÿ�� �̵�
								if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// ���ڸ��� �ƴ϶� ������ �̵��Ҷ� �������� Ÿ���̵�
									save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
									save2[i][j] = 0;
								}
								break;

							}
							if (save2[mr][mc] != 0) {// 0 �̾ƴ� Ÿ�� ��������
								if (save2[mr][mc] == save2[i][j] && sum[mr][mc] == false) {// ���������̸鼭 ��ģ���� ������ ���ڸ��� ��ü
									save2[mr][mc] = save2[i][j] * 2;
									save2[i][j] = 0;
									sum[mr][mc] = true;
								} else {// �ٸ� ���� �϶� �������� Ÿ�� �̵�
									if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// ���ڸ��� �ƴ϶� ������ �̵��Ҷ� �������� Ÿ���̵�
										save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
										save2[i][j] = 0;
									}
								}
								break;
							} else {// 0 �� Ÿ�� ��������.
								mr += dr[dir];
								mc += dc[dir];
							}
						}
					}
				}
			}
			if(Arrays.deepEquals(save2, save))
				return;
			dep +=1;
			for (int i = 0; i < 4; i++) {
				recur(i, dep, save2);
			}
		}
	}
}

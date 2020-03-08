package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12100 {
	// 10 : 12 시작!
	// 11 : 40 분 
	// 1시간 반컷 중복된 for문 줄이기 위해 while문도 고려해보면 좋을듯.
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };// 위 오른쪽 아래 왼쪽
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
							if (!(mr >= 0 && mr < map.length && mc >= 0 && mc < map.length)) { // 이동했는데 벽끝 그전으로 타일 이동
								if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// 그자리가 아니라 끝으로 이동할때 그전으로 타일이동
									save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
									save2[i][j] = 0;
								}
								break;

							}
							if (save2[mr][mc] != 0) {// 0 이아닌 타일 만났을때
								if (save2[mr][mc] == save2[i][j] && sum[mr][mc] == false) {// 같은숫자이면서 합친적이 없을때 그자리에 합체
									save2[mr][mc] = save2[i][j] * 2;
									save2[i][j] = 0;
									sum[mr][mc] = true;
								} else {// 다른 숫자 일때 그전으로 타일 이동
									if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// 그자리가 아니라 끝으로 이동할때 그전으로 타일이동
										save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
										save2[i][j] = 0;
									}
								}
								break;
							} else {// 0 인 타일 만났을때.
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
		} else { // 방향이 오른쪽 아래로 갈때
			for (int i = map.length - 1; i > -1; i--) {
				for (int j = map.length - 1; j > -1; j--) {
					if (save2[i][j] != 0) {
						int mr = i + dr[dir];
						int mc = j + dc[dir];
						while (true) {
							if (!(mr >= 0 && mr < map.length && mc >= 0 && mc < map.length)) { // 이동했는데 벽끝 그전으로 타일 이동
								if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// 그자리가 아니라 끝으로 이동할때 그전으로 타일이동
									save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
									save2[i][j] = 0;
								}
								break;

							}
							if (save2[mr][mc] != 0) {// 0 이아닌 타일 만났을때
								if (save2[mr][mc] == save2[i][j] && sum[mr][mc] == false) {// 같은숫자이면서 합친적이 없을때 그자리에 합체
									save2[mr][mc] = save2[i][j] * 2;
									save2[i][j] = 0;
									sum[mr][mc] = true;
								} else {// 다른 숫자 일때 그전으로 타일 이동
									if (!(mr == i + dr[dir] && mc == j + dc[dir])) {// 그자리가 아니라 끝으로 이동할때 그전으로 타일이동
										save2[mr - dr[dir]][mc - dc[dir]] = save2[i][j];
										save2[i][j] = 0;
									}
								}
								break;
							} else {// 0 인 타일 만났을때.
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

package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B19236 {
	// 2 : 48 시작
	// 2 : 56 문제 이해 및 코딩 시작
	// 3 : 39 첫번째 완성
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[4][4];
		int[][] fisih = new int[17][3];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				fisih[num][0] = i;
				fisih[num][1] = j;
				fisih[num][2] = dir;
				map[i][j] = num;
			}
		}
		hunting(0, 0, 0, 0, fisih, map);
		System.out.println(result);
	}

	static void hunting(int sharkX, int sharkY, int sharkDir, int totalNum, int[][] fisih, int[][] map) {
		if (map[sharkX][sharkY] == 0) {
			result = result < totalNum ? totalNum : result;
			return;
		}
		totalNum += map[sharkX][sharkY];
		sharkDir = fisih[map[sharkX][sharkY]][2];
		fisih[map[sharkX][sharkY]][0] = -1;
		map[sharkX][sharkY] = -1;
		// 잡아먹음

		moveFish(fisih, map);
		// 움직임
		int[][] tempFisih = new int[17][3];
		int[][] tempMap = new int[4][4];

		int nextSharkX = sharkX;
		int nextSharkY = sharkY;
		for (int i = 0; i < 17; i++) {
			tempFisih[i] = Arrays.copyOf(fisih[i], 3);
		}
		for (int i = 0; i < 4; i++) {
			tempMap[i] = Arrays.copyOf(map[i], 4);
		}
		tempMap[sharkX][sharkY] = 0;
		while (true) {
			nextSharkX += dx[sharkDir];
			nextSharkY += dy[sharkDir];
			if (nextSharkX >= 4 || nextSharkX < 0 || nextSharkY >= 4 || nextSharkY < 0) {
				result = result < totalNum ? totalNum : result;
				break;
			}
			hunting(nextSharkX, nextSharkY, sharkDir, totalNum, tempFisih, tempMap);
		}

	}

	static void moveFish(int[][] fisih, int[][] map) {
		for (int i = 1; i < fisih.length; i++) {
			if (fisih[i][0] == -1)
				continue;
			int nowX = fisih[i][0];
			int nowY = fisih[i][1];
			int dir = fisih[i][2];
			int initDir = dir;
			while (true) {
				int nextX = nowX + dx[dir];
				int nextY = nowY + dy[dir];
				if (nextX >= 4 || nextX < 0 || nextY >= 4 || nextY < 0 || map[nextX][nextY] == -1) {
					dir += 1;
					dir = dir % 8;
					if (dir == initDir)
						break;
					continue;
				}
				if (map[nextX][nextY] != 0) {
					fisih[map[nextX][nextY]][0] = nowX;
					fisih[map[nextX][nextY]][1] = nowY;
				}
				fisih[i][0] = nextX;
				fisih[i][1] = nextY;
				fisih[i][2] = dir;
				map[nowX][nowY] = map[nextX][nextY];
				map[nextX][nextY] = i;
				break;
			}

		}
	}
}

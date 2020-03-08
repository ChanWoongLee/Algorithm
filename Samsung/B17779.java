package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17779 {// 게리맨더링 2
	// 12:54   2:19  1시간 25분컷
	// 모든 알고리즘은 한번에 안풀린다 
	// 실수가 굉장히 많았다!!!!!!!!!!!!!! 정말정말 많았다
	// 이 실수를 위해 이게 맞나 한번더 되돌어 가야한다
	// 시간의 압박감이 굉장하다 그럴수록 한번더 맞나 확인해보는 습관을 가져야겠다.
	// 이중for문은 사각형을 뜻한다!!!
	static int N;
	static int[][] map;
	static int[][] renderMap;
	static int[] d = new int[2];
	static int d1, d2, x, y;
	static int result = Integer.MAX_VALUE;
	static int[] score = new int[5];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0 - 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		renderMap = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 1; r <= N - 2; r++) {
			for (int c = 2; c <= N - 1; c++) {
				x = r;
				y = c;
				sunyel(N - x, 0);
			}
		}
		System.out.println(result);
	}

	static void sunyel(int end, int cnt) {
		if (cnt == 2) {
			d1 = d[0];
			d2 = d[1];
			if (d1 + d2 > end)
				return;
			if (1 > y - d1)
				return;
			if (y + d2 > N)
				return;
			renderMap = new int[N + 1][N + 1];
			render();
			int res = calanother();
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(renderMap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			result = res < result ? res : result;
			return;
		}
		for (int i = 1; i < end; i++) {
			d[cnt] = i;
			sunyel(end, cnt + 1);
		}
	}

	static int calanother() {
		int min = Integer.MAX_VALUE;
		int max = -1;
		int num = 0;
		for (int i = 1; i < x + d1; i++) {
			for (int j = 1; j <= y; j++) {
				if (renderMap[i][j] == 5)
					continue;
				renderMap[i][j] = 1;
				num += map[i][j];
			}
		}
		max = max < num ? num : max;
		min = min > num ? num : min;
		score[0] = num;
		num = 0;
		for (int i = 1; i <= x + d2; i++) {
			for (int j = y + 1; j <= N; j++) {
				if (renderMap[i][j] == 5)
					continue;
				renderMap[i][j] = 2;
				num += map[i][j];
			}
		}
		max = max < num ? num : max;
		min = min > num ? num : min;
		score[1] = num;
		num = 0;
		for (int i = x + d1; i <= N; i++) {
			for (int j = 1; j < y - d1 + d2; j++) {
				if (renderMap[i][j] == 5)
					continue;
				renderMap[i][j] = 3;
				num += map[i][j];
			}
		}
		max = max < num ? num : max;
		min = min > num ? num : min;
		score[2] = num;
		num = 0;
		for (int i = x + d2 + 1; i <= N; i++) {
			for (int j = y - d1 + d2; j <= N; j++) {
				if (renderMap[i][j] == 5)
					continue;
				renderMap[i][j] = 4;
				num += map[i][j];
			}
		}
		max = max < num ? num : max;
		min = min > num ? num : min;
		score[3] = num;
		num = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (renderMap[i][j] == 0 || renderMap[i][j] == 5) {
					num += map[i][j];
				}
			}
		}
		max = max < num ? num : max;
		min = min > num ? num : min;
		score[4] = num;
		return max - min;
	}

	static void render() {
		int index = 0;
		boolean[][] visit = new boolean[N + 1][N + 1];
		while (index != d1 + 1) {
			renderMap[x + index][y - index] = 5;
			visit[x + index][y - index] = true;
			index++;
		}
		index = 0;
		while (index != d2 + 1) {
			renderMap[x + index][y + index] = 5;
			visit[x + index][y + index] = true;
			index++;
		}
		index = 0;
		while (index != d2 + 1) {
			renderMap[x + d1 + index][y - d1 + index] = 5;
			visit[x + d1 + index][y - d1 + index] = true;
			index++;
		}
		index = 0;
		while (index != d1 + 1) {
			renderMap[x + d2 + index][y + d2 - index] = 5;
			visit[x + d2 + index][y + d2 - index] = true;
			index++;
		}
		boolean five = false;
		;
		for (int i = x + 1; i < x + d1 + d2; i++) {
			for (int j = 1; j <= N; j++) {
				if (renderMap[i][j] == 5) {
					five = five == true ? false : true;
				}
				if (five) {
					renderMap[i][j] = 5;
				}
			}
		}
	}
}

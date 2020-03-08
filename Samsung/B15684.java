package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B15684 {
	// 6시에 시작
	static int[][] dari;
	static int N, H, M;
	static int[] temp;
	static LinkedList<Integer> lis = new LinkedList();
	static int result = Integer.MAX_VALUE;

	// 예외처리가중요
	// 인접한 가로선에 두면 안됨
	// 두 가로 다리 사이 비는 공간은 제외시켜야함
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());// 가로
		dari = new int[H][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			dari[a][b] = 1;
			dari[a][b + 1] = -1;
		}
		if (check()) {
			System.out.println("0");
			System.exit(0);
		}
		dfs(0, 0, 1);
		dfs(0, 0, 2);
		dfs(0, 0, 3);
		System.out.println("-1");
	}

	static boolean check() {
		boolean chec = true;
		for (int cc = 0; cc < N - 1; cc++) {
			int r = 0;
			int c = cc;
			while (r != H) {
				if (dari[r][c] != 2)
					c += dari[r][c];
				r += 1;
			}
			if (c != cc) {
				chec = false;
				break;
			}
		}
		return chec;
	}
	static void dfs(int index, int cnt, int cnt2) {
		if (index >= (N * H))
			return;
		if (cnt == cnt2) {
			if (check()) {
				result = cnt2;
				System.out.println(result);
				System.exit(0);
			}
			return;
		}
		int r = index / N;
		int c = index % N;
		if (c == N - 1 || dari[r][c] != 0 || dari[r][c + 1] != 0) {
			dfs(index + 1, cnt, cnt2);
			return;
		}
		dari[r][c] = 1;
		dari[r][c + 1] = -1;
		dfs(index + 1, cnt + 1, cnt2);
		dari[r][c] = 0;
		dari[r][c + 1] = 0;
		dfs(index + 1, cnt, cnt2);
	}

}

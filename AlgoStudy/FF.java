package AlgoStudy;
import java.util.*;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class FF {

	static int N;
	static int M;
	static int[][] arr;
	static int[][] temp;
	static ArrayList<Pair> A = new ArrayList<>();
	static int[] dir;
	static int min = Integer.MAX_VALUE;
	static int cnt;

	public static void move(int x, int y, int d) {
		int newx;
		int newy;

		if (d == 1) {
			newx = x - 1;
			newy = y;
		} else if (d == 2) {
			newx = x;
			newy = y + 1;
		} else if (d == 3) {
			newx = x + 1;
			newy = y;
		} else {
			newx = x;
			newy = y - 1;
		}

		if (newx < 0 || newy < 0 || newx >= N || newy >= M)
			return;
		if (arr[newx][newy] == 6)
			return;

		if (arr[newx][newy] == 0)
			arr[newx][newy] = 1;

		move(newx, newy, d);

	}

	public static void watch(int x, int y, int type, int d) {
		if (type == 1) {
			move(x, y, d);
		}
		if (type == 2) {
			move(x, y, d);
			move(x, y, (d + 2) % 4);
		}
		if (type == 3) {
			move(x, y, d);
			move(x, y, (d + 1) % 4);
		}
		if (type == 4) {
			move(x, y, d);
			move(x, y, (d + 1) % 4);
			move(x, y, (d + 2) % 4);
		}
		if (type == 5) {
			move(x, y, d);
			move(x, y, (d + 1) % 4);
			move(x, y, (d + 2) % 4);
			move(x, y, (d + 3) % 4);
		}
	}

	public static void btr(int depth) {
		if (depth == A.size() - 1) {

			for (int i = 0; i < A.size(); i++) {
				Pair p = A.get(i);
				watch(p.x, p.y, arr[p.x][p.y], dir[i]);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) {
						cnt++;
					}

					arr[i][j] = temp[i][j];
				}
			}

			min = Math.min(cnt, min);
			cnt = 0;

			return;
		}

		for (int i = 0; i < 4; i++) {
			dir[depth + 1] = i + 1;
			btr(depth + 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				temp[i][j] = arr[i][j];
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					A.add(new Pair(i, j));
				}
			}
		}

		dir = new int[A.size()];

		btr(-1);

		System.out.println(min);

	}

}

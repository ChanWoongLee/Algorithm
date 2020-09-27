package SummerCoding;

public class Line2020_C {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } }));
	}

	// 0123 위 오른쪽 아래 왼쪽
	static int[][] dr = { { 0, -1, 0, 1 }, { -1, 0, 1, 0 }, { 0, 1, 0, -1 }, { 1, 0, -1, 0 } };
	static int[][] dc = { { -1, 0, 1, 0 }, { 0, 1, 0, -1 }, { 1, 0, -1, 0 }, { 0, -1, 0, 1 } };
	static int[][] dirCal = { { 3, 0, 1, 2 }, { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 2, 3, 0, 1 } };

	static public int solution(int[][] maze) {
		int answer = 0;
		int r = 0;
		int c = 0;
		int dir = 1;
		int N = maze.length;
		int result = 0;
		while (true) {
			if (r == N - 1 && c == N - 1)
				break;
			for (int move = 0; move < 4; move++) {
				int nextR = r + dr[dir][move];
				int nextC = c + dc[dir][move];
				if (nextR >= N || nextR < 0 || nextC >= N || nextC < 0 || maze[nextR][nextC] == 1)
					continue;
				r = nextR;
				c = nextC;
				dir = dirCal[dir][move];
				break;
			}
			System.out.println("위치 " + r + " " + c);
			result++;
		}
		return result;
	}
}

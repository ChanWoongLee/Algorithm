package SummerCoding;


public class Programers_방문길이 {

	public static void main(String[] args) {

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public int solution(String dirs) {
		int answer = 0;
		int x = 5;
		int y = 5;
		int nextX = 0;
		int nextY = 0;
		boolean[][][][] visit = new boolean[11][11][11][11];
		for (int i = 0; i < dirs.length(); i++) {
			int beforeX = nextX;
			int beforeY = nextY;
			switch (dirs.charAt(i)) {
			case 'L':
				nextX += dx[0];
				nextY += dy[0];
				break;
			case 'R':
				nextX += dx[1];
				nextY += dy[1];
				break;
			case 'U':
				nextX += dx[2];
				nextY += dy[2];
				break;
			case 'D':
				nextX += dx[3];
				nextY += dy[3];
				break;
			}
			if (nextX < 0 || nextX > 10 || nextY > 11 || nextY < 0) {
				nextX = beforeX;
				nextY = beforeY;
				continue;
			}
			if (!visit[beforeX][beforeY][nextX][nextY] && !visit[nextX][nextY][beforeX][beforeY]) {
				visit[beforeX][beforeY][nextX][nextY] = true;
				visit[nextX][nextY][beforeX][beforeY] = true;
				answer++;
			}
		}
		return answer;
	}
}

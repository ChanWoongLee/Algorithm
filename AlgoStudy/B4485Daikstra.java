package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B4485Daikstra {
	static int N;
	static int[][] RUPE;
	static int[][] DIST;
	static int[] dx = { -1, 0, 1, 0 }; // �� ������ �Ʒ� ����
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		int problem = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			RUPE = new int[N][N];
			DIST = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					RUPE[i][j] = Integer.parseInt(str[j]);
					DIST[i][j] = Integer.MAX_VALUE;
				}
			}
			PriorityQueue<Dot> pq = new PriorityQueue();
			Dot start = new Dot(0, 0, RUPE[0][0]);
			DIST[0][0] = RUPE[0][0];
			pq.add(start);
			while (!pq.isEmpty()) {
				Dot dot = pq.poll();
				if( DIST[dot.x][dot.y] < dot.value) {
					continue;
				}
				for (int i = 0; i < 4; i++) {
					if (dot.x + dx[i] >= 0 && dot.x + dx[i] < N && dot.y + dy[i] < N && dot.y + dy[i] >= 0) {
						// ���� ��ġ�� ���� ��4���� ���� ���� ���� �Ǵ�
						if (DIST[dot.x + dx[i]][dot.y + dy[i]] > DIST[dot.x][dot.y]
								+ RUPE[dot.x + dx[i]][dot.y + dy[i]] ) {
							//������ġ�� ����� �Ÿ��� �̹��� ���� �Ÿ����� ũ�ٸ� , �湮������ ����
							DIST[dot.x + dx[i]][dot.y + dy[i]] = DIST[dot.x][dot.y]
									+ RUPE[dot.x + dx[i]][dot.y + dy[i]];
							pq.add(new Dot(dot.x + dx[i], dot.y + dy[i], RUPE[dot.x + dx[i]][dot.y + dy[i]]));
						}	
					}
				}
			}
			System.out.println("Problem " + problem + ": " + DIST[N-1][N-1]);
			problem++;
		}
	}

}

class Dot implements Comparable<Dot> {
	int x;
	int y;
	int value;

	public Dot(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	@Override
	public int compareTo(Dot arg0) {
		return this.value >= arg0.value ? 1 : -1;
	}

}

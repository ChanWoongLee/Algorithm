package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ��!
public class B3190 {
	// 1 : 46 �н���
	// ���ڸ��� �ùķ��̼� ����
	// 3�� ��
	// 1 �ð� 14 �аɸ�
	// �ùķ��̼������� ū�Ǽ����� ;;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int[][] tail = new int[N][N];
		st = new StringTokenizer(bf.readLine());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}
		Deque<Integer> q = new LinkedList();
		st = new StringTokenizer(bf.readLine());
		int L = Integer.parseInt(st.nextToken());
		ArrayList<Move> m = new ArrayList();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(bf.readLine());
			m.add(new Move(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		// ���� �ޱ� ��
		int result = 0;
		int nowdir = 1, nowR = 0, nowC = 0;
		int tailR = 0, tailC = 0;
		tail[nowR][nowC] = nowdir;
		map[nowR][nowC] = 1;
		int index = 0;
		while (true) {
			result++;
			// �ð��� ���� ���� ��ȯ
			if (m.get(index).time == result-1) {
				nowdir = m.get(index).dir.equals("D") ? nowdir + 1 : nowdir - 1;
				if (nowdir == 4)
					nowdir = 0;
				if (nowdir == -1)
					nowdir = 3;
//			if (turn.front().second == 'L')
//				idx = (idx + 3) % 4;
//			else
//				idx = (idx + 1) % 4; �Ǽ� ���̷��� �̷���
				LinkedList<Integer> ar = new LinkedList();
				index++;
				index = L == index ? 0 : index;
				tail[nowR][nowC] = nowdir;
			}
			int nextR = nowR + dr[nowdir];
			int nextC = nowC + dc[nowdir];
			// �ڱ� �ڽŰ� ���� �΋H���ų� ��
			if ((nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map.length) || map[nextR][nextC] == 1)
				break;

			if (map[nextR][nextC] != 2) { // �տ� ����� ���ٸ�
				int d = tail[tailR][tailC];
				tail[tailR][tailC] = 0;
				map[tailR][tailC] = 0;// ������ ����� ������ ���������
				tailR = tailR + dr[d];
				tailC = tailC + dc[d];// ���ο� ����������

			}
			tail[nextR][nextC] = nowdir;
			map[nextR][nextC] = 1;
			nowR = nextR;
			nowC = nextC;
		}
		System.out.println(result);
	}
}

class Move {
	int time;
	String dir;

	public Move(int t, String d) {
		time = t;
		dir = d;
	}
}

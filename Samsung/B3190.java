package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀!
public class B3190 {
	// 1 : 46 분시작
	// 읽자마자 시뮬레이션 인지
	// 3시 끝
	// 1 시간 14 분걸림
	// 시뮬레이션이지만 큰실수를함 ;;
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
		// 정보 받기 끝
		int result = 0;
		int nowdir = 1, nowR = 0, nowC = 0;
		int tailR = 0, tailC = 0;
		tail[nowR][nowC] = nowdir;
		map[nowR][nowC] = 1;
		int index = 0;
		while (true) {
			result++;
			// 시간에 따라 방향 전환
			if (m.get(index).time == result-1) {
				nowdir = m.get(index).dir.equals("D") ? nowdir + 1 : nowdir - 1;
				if (nowdir == 4)
					nowdir = 0;
				if (nowdir == -1)
					nowdir = 3;
//			if (turn.front().second == 'L')
//				idx = (idx + 3) % 4;
//			else
//				idx = (idx + 1) % 4; 실수 줄이려면 이렇게
				LinkedList<Integer> ar = new LinkedList();
				index++;
				index = L == index ? 0 : index;
				tail[nowR][nowC] = nowdir;
			}
			int nextR = nowR + dr[nowdir];
			int nextC = nowC + dc[nowdir];
			// 자기 자신과 몸이 부딫히거나 벽
			if ((nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map.length) || map[nextR][nextC] == 1)
				break;

			if (map[nextR][nextC] != 2) { // 앞에 사과가 없다면
				int d = tail[tailR][tailC];
				tail[tailR][tailC] = 0;
				map[tailR][tailC] = 0;// 현재의 몸통과 꼬리의 흔적지우고
				tailR = tailR + dr[d];
				tailC = tailC + dc[d];// 새로운 꼬리를저장

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

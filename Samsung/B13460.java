package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13460   {
	// 5시 45분 시작
	static int[] dr = { -1, 0, 1, 0 };// 위 오른쪽 아래 왼쪽
	static int[] dc = { 0, 1, 0, -1 };
	static int result = Integer.MAX_VALUE;
	static boolean[][][][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//for(int k = 0; k < 100; k++) {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		String[][] map = new String[r][c];
		visit = new boolean[11][r][c][r][c]; // 0은 red 1 은 blue
		int R_r = 0, R_c = 0, B_r = 0, B_c = 0;
		for (int i = 0; i < r; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < c; j++) {
				map[i][j] = str[j];
				if (str[j].equals("R")) {
					R_r = i;
					R_c = j;
				} else if (str[j].equals("B")) {
					B_r = i;
					B_c = j;
				}
			}
		}
		recur(R_r, R_c, B_r, B_c, 0, map);
		//st = new StringTokenizer(bf.readLine());
		//System.out.print(Integer.parseInt(st.nextToken()));
		//bf.readLine();
		PriorityQueue<Integer> pq = new PriorityQueue();
		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
		//result = Integer.MAX_VALUE;
		//}
	}

	static void recur(int Rr, int Rc, int Br, int Bc, int count, String[][] map) {
		if (count >= 10)
			return;
		visit[count][Rr][Rc][Br][Bc] = true;

		for (int i = 0; i < 4; i++) {
			int fRr = Rr, fRc = Rc, fBr = Br, fBc = Bc;
			// 해당 i에 맞게 쭉이동
			int goal = 0;
			while (!map[fRr + dr[i]][fRc + dc[i]].equals("#")) {
				fRr += dr[i];
				fRc += dc[i];
				if (map[fRr][fRc].equals("O")) {
					goal = 1;
					break;
				}
			}
			while (!map[fBr + dr[i]][fBc + dc[i]].equals("#")) {
				fBr += dr[i];
				fBc += dc[i];
				if (map[fBr][fBc].equals("O")) {
					goal = 2;
					break;
				}
			}
			if (fRr == fBr && fRc == fBc) {
                if (map[fBr][fRc].equals("O")) continue;
                if (Math.abs(Rr - fRr) + Math.abs(Rc - fRc) > Math.abs(Br - fBr) + Math.abs(Bc - fBc)) {
                    fRr -= dr[i];
                    fRc -= dc[i];
                }
                else {
                    fBr-= dr[i];
                    fBc -= dc[i];
                }
            }


			if (fRr == Rr && fRc == Rc && fBr == Br && fBc == Bc) {
				continue;
			}
			if (visit[count][fRr][fRc][fBr][fBc] == true) {
				continue;
			}
			
			if(goal == 1) {
				result = Math.min(result, count+1);
				return;
			}
			else if(goal == 2) {
				continue;
			}
			recur(fRr, fRc, fBr, fBc, count + 1, map);
		}
	}
}

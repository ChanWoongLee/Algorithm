package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 11½Ã 30ºÐ½ÃÀÛ 
public class S2382 {
	static int N, M, K;
	static ArrayList<mvirus> map[][];
	static mvirus[] vir;
	static int[] dr = { -1, 1, 0, 0 };// »ó ÇÏ ÁÂ ¿ì
	static int[] dc = { 0, 0, -1, 1 };
	static int[] reverse = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N
		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());// N
			M = Integer.parseInt(st.nextToken());// N
			K = Integer.parseInt(st.nextToken());// N
			vir = new mvirus[K + 1];
			map = new ArrayList[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j] = new ArrayList();

			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(bf.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[r][c].add(new mvirus(r, c, num, dir));
			}
			while (M-- > 0) {
				ArrayList<mvirus>[][] temp = new ArrayList[N][N];
				for (int i = 0; i < N; i++)
					for (int j = 0; j < N; j++)
						temp[i][j] = new ArrayList();

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j].size() != 0) {
							mvirus now = map[i][j].get(0);
							now.r += dr[now.dir];
							now.c += dc[now.dir];
							if (now.r == 0 || now.c == 0 || now.r == N - 1 || now.c == N - 1) {
								if (now.num / 2 != 0) {
									now.dir = reverse[now.dir];
									now.num /= 2;
									temp[now.r][now.c].add(now);
								}
							} else // ºóÄ­ÀÌµ¿
								temp[now.r][now.c].add(now);
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (temp[i][j].size() > 1) {
							Collections.sort(temp[i][j], Collections.reverseOrder());
							int dir = temp[i][j].get(0).dir;
							int num = 0;
							for (int s = 0; s < temp[i][j].size(); s++)
								num += temp[i][j].get(s).num;
							temp[i][j].clear();
							temp[i][j].add(new mvirus(i, j, num, dir));
						}
					}
				}
				map = temp;
			}
			for(int i = 0; i <N; i++) {
				for(int j =0; j<N;j++) {
					if(map[i][j].size()!=0) {
						result+= map[i][j].get(0).num;
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}

class mvirus implements Comparable<mvirus> {
	int r, c;
	int num;
	int dir;

	public mvirus(int r, int c, int num, int dir) {
		this.r = r;
		this.c = c;
		this.num = num;
		this.dir = dir;
	}

	@Override
	public int compareTo(mvirus arg0) {
		return this.num - arg0.num;
	}
}

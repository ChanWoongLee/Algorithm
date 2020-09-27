package Inha.Graph;

public class kolon2 {
	static int[] temp;
	static int[] line;
	static int[] dot;
	static boolean res;
	static boolean[] visit;
	public static void main(String[] args) {
//		int [] dots = {1,3,4,5,10,15,16,21,22,30,50,55,60,100,110,120,130,140,150};
//		int [] lines = {1,2,4,10,5,6,7,3};
		int [] dots = {1,2,3,7};
		int [] lines = {1,2};
		System.out.println(solution(dots, lines));
	}

	static int solution(int[] dots, int[] lines) {
		line = lines;
		dot = dots;
		res = false;
		for (int i = 2; i <= lines.length; i++) {
			visit = new boolean[lines.length];
			temp = new int[i];
			dfs(0, 0, i);
			if (res)
				return i;
		}
		return -1;
	}

	static boolean solve() {
		int start = 0;
		for(int a : temp)
			System.out.print(a+" ");
		System.out.println();
		for (int t = 0; t < temp.length; t++) {
			int len = temp[t];
			int i = start + 1;
			for (; i < dot.length; i++) {
				if (dot[i] - dot[start] > len) {
					start = i;
					break;
				}
			}
			if (i == dot.length) {
				for(int a : temp)
					System.out.print(a+" ");
				System.out.println();
				return true;
			}
		}
		return false;
	}

	static void dfs(int index, int cnt, int max) {
		if (res)
			return;
		if (cnt == max) {
			res = solve();
			return;
		}
		for (int i = 0; i < line.length; i++) {
			if(visit[i])
				continue;
			temp[cnt] = line[i];
			visit[i] = true;
			dfs(i + 1, cnt + 1, max);
			visit[i]= false;
			if (res)
				return;
		}
	}
}

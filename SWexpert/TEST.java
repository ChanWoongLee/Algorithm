package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TEST {
	static boolean[] visit;
	static int[] answer;
	static int[] temp;
	static int a,Kk;
	static boolean go = false;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());// N
		Kk = Integer.parseInt(st.nextToken());// N
		visit = new boolean[N];
		answer = new int[N];
		a= 1;
		dfs(0,0);
		for(int i = 0 ; i < answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}

	static void dfs(int index, int cnt) {
        if(go)
            return;
		if (cnt == visit.length) {
			if(a==Kk) {
		        go = true;
		        answer = Arrays.copyOf(temp, temp.length);
			}
			else
				a++;
			return;
		}
		for (int i = 0; i < visit.length; i++) {
			if (visit[i] == false) {
				visit[i] = true;
			    temp[cnt] = i + 1;
				dfs(i, cnt + 1);
				visit[i] = false;
			}
		}
	}
}

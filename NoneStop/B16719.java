package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B16719 {
	static boolean[] visit;
	static ArrayList<Info> outPut;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String origin = st.nextToken();
		visit = new boolean[origin.length()];
		int start = 0;
		outPut = new ArrayList<>();
		dfs(origin,0);
//		while (true) {
//			String[] str = origin.split("");
//			Arrays.sort(str);
//			char target = str[0].charAt(0);
//			int index = 0;
//			boolean change = false;
//			for (int j = start; j < origin.length(); j++) {
//				if (visit[j])
//					continue;
//				if (origin.charAt(j) == target) {
//					index = j;
//					change = true;
//					break;
//				}
//			}
//			if (!change) {
//				start = 0;
//				continue;
//			}
//			ar.add(new Info(target, index));
//			Collections.sort(ar);
//			String output = "";
//			for (Info i : ar)
//				output += i.c + "";
//			System.out.println(output);
//
//			visit[index] = true;
//		}
	}

	static void dfs(String str) {
		String[] strAr = str.split("");
		Arrays.sort(strAr);
		int find = 0;
		char target = strAr[find].charAt(0);
		int idx = 0;
		while(true) {
			
			if(str.charAt(idx) == target && !visit[idx]) {
				visit[idx] = true;
				outPut.add(new Info(target, idx));
				Collections.sort(outPut);
				String output = "";
				for (Info i : outPut)
					output += i.c + "";
				System.out.println(output);
				dfs(str.substring(idx));
				
			}
				
				
			idx++;	
			idx = idx % str.length();
		}
		
		for (int j = idx; j < str.length(); j++) {
			if (visit[j])
				continue;
			if (str.charAt(j) == target) {
				index = j;
				break;
			}
		}
		visit[index] = true;
		
	}
	
	static class Info implements Comparable<Info> {
		char c;
		int idx;

		public Info(char c, int idx) {
			super();
			this.c = c;
			this.idx = idx;
		}

		@Override
		public int compareTo(Info o) {
			return this.idx - o.idx;
		}

	}
}

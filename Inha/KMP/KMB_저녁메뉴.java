package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KMB_저녁메뉴 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		String str = bf.readLine().replace(" ", "");
		str += str;
		String pattern = bf.readLine().replace(" ", "");
		int[] next = initNext(pattern);
		for (int k : next) {
			System.out.print(k + " ");
		}
		System.out.println();
		int cnt = (KMP(str, pattern, initNext(pattern)));
		int gcd = gcd(N, cnt);
		System.out.println(cnt / gcd + "/" + N / gcd);
	}

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static int KMP(String st, String pattern, int[] next) {
		int i, j;
		int cnt = 0;
		for (i = 0, j = 0; i < st.length() && j < pattern.length(); i++, j++) {
			if (st.charAt(i) != pattern.charAt(j)) {
				j = next[j];
			} else if (j == pattern.length() - 1) { // AAAA 중 AA를 올바르게 count 하게하는 구문!!!!!!!!!!!!!!!!!!!!!!!!!
				cnt++;
				j = next[j];
				System.out.println(j);
			}
		}

		return cnt; // 실패시 정확한 length 출력
	}

	static int[] initNext(String pattern) {
		int next[] = new int[pattern.length()];
		next[0] = -1;
		int j = 0;
		for (int i = 1; i < pattern.length(); i++, j++) {
			next[i] = j;
			while (j >= 0 && (pattern.charAt(i) != pattern.charAt(j)))
				j = next[j];
		}

		return next;
	}
}

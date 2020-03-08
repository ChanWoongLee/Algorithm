package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10834 {
	// 최소공배수
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		int result = 0;
		boolean dir = true;
		int res = 1;
		for (int i = 0; i < size; i++) {
			// a : b = c : d bc = ad
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			res = (res/a)*b;
			dir = Integer.parseInt(st.nextToken()) == 1 ? !dir : dir;
		}
		int direction = dir == true ? 0 : 1;
		System.out.println(direction + " " + res);
	}

}

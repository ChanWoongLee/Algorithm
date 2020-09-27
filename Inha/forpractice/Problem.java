package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		s[] num = new s[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			num[i] = new s(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			int tempH = num[i].height;
			String tempN = num[i].name;
			int tempj;
			int j = i-1;
			while (j > 0 && num[j].height > tempH) {
				num[j + 1] = num[j];
				j--;
			}
			num[j + 1] = new s(tempH, tempN);
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(num[i].height + " " + num[i].name);
		}
	}

}

class s {
	int height;
	String name;

	public s(int h, String name) {
		this.height = h;
		this.name = name;
	}
}

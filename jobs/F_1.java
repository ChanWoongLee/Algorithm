package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F_1 {
	static int[] temp;
	static int[] person;
	static boolean finish = false;
	static int num;
	static int need;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int student = Integer.parseInt(st.nextToken());
		int select = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		need = 0;
		temp = new int[select];
		person = new int[student];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < student; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		sunyel(0, 0);
	}

	static void sunyel(int index, int cnt) {
		if (finish)
			return;
		if (cnt == temp.length) {
			need++;
			if (need == num) {
				finish = true;
				for (int i = 0; i < temp.length; i++) {
					result += person[temp[i]];
				}
				System.out.println(result);
			}
			return;
		}
		if (index == person.length)
			return;
		
		temp[cnt] = index;
		sunyel(index + 1, cnt + 1);
		sunyel(index + 1, cnt);
	}
}

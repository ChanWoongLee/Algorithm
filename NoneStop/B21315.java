package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B21315 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		String cardSet = "";
		String origin = "";
		for (int i = 1; i <= N; i++) {
			cardSet += st.nextToken();
			origin += String.valueOf(i);
		}
		for (int first = 1; (int)Math.pow(2, first) < N; first++) {
			for (int second = 1;  (int)Math.pow(2, second) < N; second++) {
				String temp = origin;
				temp = EK(temp, first);
				temp = EK(temp, second);
				System.out.println(temp);
				if(temp.equals(cardSet)) {
					System.out.println(first+" "+second);
					return;
				}
			}
		}
	}

	static String EK(String str, int K) {
		int point = 0;
		int movePoint = 0;
		for (int i = 1; i <= K + 1; i++) {
			if (i == 1) {
				point = (int) Math.pow(2, K) - 1;
				movePoint = str.length() - 1 - point;

				String part1 = str.substring(movePoint);
				String part2 = str.substring(0, movePoint);

				str = part1 + part2;
			} else {
				int nowPoint = (int) Math.pow(2, K - i + 1) - 1;
				movePoint = point - nowPoint;
				
				String part1 = str.substring(movePoint,point+1);
				String part2 = str.substring(0, movePoint);
				String part3 = str.substring(point+1, str.length());
				
				str = part1+part2+part3;
				point = nowPoint;
			}

		}
		return str;
	}

}

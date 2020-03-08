package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeForce1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int tcase = Integer.parseInt(st.nextToken());
		while (tcase-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int a, b, c, r, result = 0;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			if (b < a) {
				int s = b;
				b = a;
				a = s;
			}
			if (a < 0) {
				b = b - a;
				c = c - a;
				a = a - a;
			}
			int[] street = new int[b + 1];
			street[b] = 1;
			for (int i = 0; i < a; i++)
				street[i] = 1;
			if (c >= b) {
				if (c - r < a) {
					System.out.println(0);
					continue;
				} else {
					for (int i = c - r; i < b; i++)
						street[i] = 1;
				}
			} else if (c <= a) {
				if (c + r - 1 > b) {
					System.out.println(0);
					continue;
				} else {
					if(c+r>=1)
					for (int i = 1; i <= c + r ; i++)
						street[i] = 1;
				}
			} else {
				for (int i = 0; i < r * 2; i++)
					street[c - r + i] = 1;
			}
			for (int i = 0; i < street.length; i++)
				if (street[i] == 0)
					result++;

			System.out.println(result);
		}
	}

}

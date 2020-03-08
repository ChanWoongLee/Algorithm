package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14697 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		int[] num = new int[total + 1];
		if(A<=total)
		num[A] = 1;
		if(B<=total)
		num[B] = 1;
		if(C<=total)
		num[C] = 1;
		for (int i = 0; i <= total; i++) {
			if (num[i] == 1) {
				if (A + i <= total)
					num[A + i] = 1;
				if (B + i <= total)
					num[B + i] = 1;
				if (C + i <= total)
					num[C + i] = 1;
			}
		}
		System.out.println(num[total]);
	}

}

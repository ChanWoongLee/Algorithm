package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13302 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int day = Integer.parseInt(st.nextToken());
		int out = Integer.parseInt(st.nextToken());
		int[][] d = new int[2][day];//
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < out; i++) {
			for (int j = 0; j < 2; j++) {
				d[j][Integer.parseInt(st.nextToken())-1] = -1;
			}
		}
	}

}

package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] grade_0 = new int[6];
		int[] grade_1 = new int[6];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bf.readLine());
			if (Integer.parseInt(st.nextToken()) == 1)
				grade_1[Integer.parseInt(st.nextToken())]++;
			else
				grade_0[Integer.parseInt(st.nextToken()) - 1]++;
		}
		int result = 0;
		for (int i = 0; i < 6; i++) {
			result += grade_1[i]/k;
			result += grade_0[i]/k;	
			grade_1[i] -= (grade_1[i]/k) * k;
			grade_0[i] -= (grade_0[i]/k) * k;
		}
		for(int i = 0; i < 6; i++) {
			if(grade_1[i]!=0) result++;
			if(grade_0[i]!=0) result++;
		}
		System.out.println(result);
	}

}

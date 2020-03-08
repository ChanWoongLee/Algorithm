package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B173888 {

	public static void main(String[] args) throws IOException {
		int answer = 0;
		int n = 15;
		int[] num = new int[n+1];
		int[] psum = new int[n+1];
		
		for(int i = 1; i < num.length; i++) {
			num[i] = i;
			psum[i] = psum[i-1] + num[i];
		}
		// i부터 j까지 합은   psum[j] - psum[i-1] 
		for(int i = 1; i < num.length; i++) {
			for(int j = 1; j < num.length; j++) {
				if(psum[j] - psum[i-1] == n) {
					answer++;
					
				}
			}
		}
		System.out.println(answer);
	}
}

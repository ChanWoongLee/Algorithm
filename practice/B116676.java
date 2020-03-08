package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B116676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N= br.readLine();
		char[] one = new char[N.length()];
		for(int i=0; i<one.length; i++) {
			one[i]='1';
		}
		if (Integer.valueOf(N)>=Integer.valueOf(String.valueOf(one)))
			System.out.println(N.length());
		else if(Integer.valueOf(N)==0||Integer.valueOf(N)==1) {
			System.out.println(1);
		}
		else
			System.out.println(N.length()-1);
	}

}

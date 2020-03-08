package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10162 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[] button = {300,60,10};
		int[] result = new int[3];
		for(int i = 0; i < 3; i++) {
			result[i] = num/button[i];
			num -= (num/button[i])*button[i];
		}
		if(num == 0)
			System.out.println(result[0]+" "+result[1]+" "+result[2]);
		else
			System.out.println("-1");
	}

}

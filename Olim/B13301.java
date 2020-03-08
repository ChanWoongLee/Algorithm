package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B13301 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		if(size ==1) {System.out.println(4); System.exit(0);}
		long[] square = new long[size + 1];
		square[1] = 1;
		square[2] = 1;
		for(int i = 3; i <= size; i++) {
			square[i] = square[i-1] + square[i-2];
		}
		System.out.println(2*(square[size] + square[size-1])+2*square[size]);
	}

}

package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B1629again {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		System.out.println(solve(A,B,C));
	}

	public static long solve(long A, long B, long C) {
		if(B==0)
			return 1;
		if(B%2==0) {
			long ret=solve(A,B/2,C);
			return ret*ret;	
		}
		else
			return A*solve(A,B-1,C);
	}
}//변수저장의 중요성!!!@!#@$!@$!@#


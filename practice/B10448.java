package practice;

import java.util.Scanner;

public class B10448 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int[] n = new int[N];
		for (int i = 0; i < N; i++) {
			n[i]=sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
		if(check(n[i])==true)
			System.out.println("1");
		else
			System.out.println("0");
		}
	}
	
	public static boolean check(int n) {
		for (int i = 1; i < 45; i++) {
			for (int j = 1; j < 45; j++) {
				for (int t = 1; t < 45; t++) {
					if(T(i)+T(j)+T(t)>n)
						break;
					if(T(i)+T(j)+T(t)==n) 
						return true;
				}
			}
		}
		return false;
	}
	
	public static int T(int n) {
		return n*(n+1)/2;
	}
}

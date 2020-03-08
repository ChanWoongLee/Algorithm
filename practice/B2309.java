package practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import javax.naming.ldap.SortControl;

public class B2309 {
	static int[] H = new int[9];
	static int[] B = new int[7];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			int height = sc.nextInt();
			H[i]=height;
		}

		com(9,7);

	}

	public static void com(int n,int r) {
		if(r==0) {
			int total=0;
			for (int i = 0; i < B.length; i++) {
				total+=B[i];
			}
			if(total==100) {
				Arrays.sort(B);
				for (int i = 0; i < B.length; i++) {
					System.out.println(B[i]);
				}
			}
		}
		else if(r>n) return;
		else {
			B[r-1]=H[n-1];
			com(n-1,r-1);
			com(n-1,r);
		}
	}

}

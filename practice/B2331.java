package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class B2331 {
	static int[] b = new int[9999];
	static int index = 0;
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int A=sc.nextInt();
		int P=sc.nextInt();
		
		System.out.println(d(A,P));
	}
	
	public static int d(int n,int p) {
		b[index]=n; //������ n b������
		for (int j = index; j>0; j--) {
			if (b[j-1]==n ) {
				return j-1;
			}
		}//������ for���� �׷��� ���� �����߿�!!!
		
		index++;
		int i=0;
		while(true) {
			int k=1;
			for (int j = 0; j < p; j++) {
				k=k*(n%10);
			};
			n=n/10;
			i+=k;
			if(n==0) break;
		}
		return d(i,p);
	}
}

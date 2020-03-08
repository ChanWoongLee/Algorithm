package practice;

import java.util.LinkedList;
import java.util.Scanner;

public class HN {
	public static void main(String[] args) {
		HN hn = new HN();
		LinkedList size = new LinkedList();
		Scanner num = new Scanner(System.in);
		
		int N= num.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int s=hn.hanNumber(i);
			if(s!=0)
				size.push(s);
		}
		System.out.println(size.size());
	}
	
	public int hanNumber(int n) {
		int n1= n%10;
		int n2= (n/10)%10;
		int n3= (n/100)%10;
		
		if(n==1000)
			return 0;
		
		if(n3==0) {
			return n;
		}
		else if((n1-n2==n2-n3))
			return n;
		else
			return 0;
		
	}
}

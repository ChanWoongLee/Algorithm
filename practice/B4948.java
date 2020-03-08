package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B4948 {
	static int[] num = new int[246913];
	static int[] memory = new int[246913];
	
	static public void multi(int n,int result) {
		if((result > 246913)||(result<0))
			return;
		if(memory[result] == 2)
			return;
		memory[result]++;
		for(int i = n; i < 246913; i++) {
			if((result*i < 0)||(result*i > 246913))
				break;
			else
				multi(i, result*i);
		}
	}
	
	public static void main(String[] args) {
		multi(2, 1);
		Scanner sc= new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int count = 0;
			if(n == 1) 
				System.out.println("1");
			else if(n == 0)
				break;
			else {
				for(int i = n+1; i <= n*2; i++) {
					if((memory[i]==1) || memory[i]==0)
						count++;
				}
				System.out.println(count);
			}
		}
	}

}

package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class B1931again {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		meeting[] m = new meeting[N];
		for (int i = 0; i < m.length; i++) {
			m[i]=new meeting(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(m);
		
		int time=m[0].finishTime;
		int count=1;
		for (int i = 1; i < m.length; i++) {
			if (m[i].startTime>=time) {
				count++;
				time=m[i].finishTime;
			}
		}
		System.out.println(count);
	}
}

class meeting implements Comparable<meeting>{
	int startTime = 0;
	int finishTime =0;
	public meeting(int s, int f) {
		startTime=s;
		finishTime=f;
	}
	public int compareTo(meeting m2) {
		if (this.finishTime==m2.finishTime) 
			return this.finishTime-m2.finishTime;
		else
			return this.finishTime - m2.finishTime;
	}
}
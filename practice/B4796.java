package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Spring;

public class B4796 {
	public static void main(String[] args) throws IOException {
		ArrayList<Day> day = new ArrayList<Day>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L;
		int P;
		int V;
		while(true) {
			String[] line= br.readLine().trim().split(" ");
			L = Integer.valueOf(line[0]);//놀수있는 L일
			P = Integer.valueOf(line[1]);//연속되는 P일중
			V = Integer.valueOf(line[2]);//나의 총 휴가일!
			if(V==0&&L==0&&P==0)
				break;
			Day d = new Day(L, P, V);
			day.add(d);
		}
		int index=0;
		while(true) {
			if (index==day.size())
				break;
			int campingDay=(day.get(index).V/day.get(index).P)*day.get(index).L+day.get(index).L;
			System.out.println("Case "+(index+1)+": "+campingDay);
			index++;
		}
	}

	public static class Day{
		int L;
		int P;
		int V;
		public Day(int L, int P, int V) {
			this.L = L;
			this.P = P;
			this.V = V;
		}
	}
}


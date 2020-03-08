package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B15969 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arl = new ArrayList[num];
		for (int i = 0; i < num; i++) {
			arl[i] = new ArrayList();
		}
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(bf.readLine());
			int loc = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			arl[col].add(loc);
		}
		for (int i = 0; i < num; i++) {
			Collections.sort(arl[i]);
		}
		int result = 0;
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < arl[i].size(); j++) {
				if(j == 0) 
					result += arl[i].get(j+1) - arl[i].get(j); 
				else if(j == arl[i].size()-1)
					result += arl[i].get(j) - arl[i].get(j-1);
				else {
					int behind = arl[i].get(j) - arl[i].get(j-1);
					int front = arl[i].get(j+1) - arl[i].get(j);
					result += behind > front ? front : behind;
				}
			}
		}
		System.out.println(result);
	}

}

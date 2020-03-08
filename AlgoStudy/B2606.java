package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B2606 {
	static int[][] a;
	static boolean[] check;
	static int count;
	public static void dfs(int n) {
		if(check[n])
			return;
		check[n] = true;
		count++;
		for (int i = 1; i < a.length; i++) {
			if ((a[n][i] != 0) && !check[i]) {
					dfs(i);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int connect = Integer.parseInt(bf.readLine());
		a = new int[n + 1][n + 1];
		check = new boolean[n + 1];
		for (int i = 0; i < connect ; i++) {
			String[] numString = bf.readLine().split(" ");
			a[Integer.parseInt(numString[0])][Integer.parseInt(numString[1])] = 1;
			a[Integer.parseInt(numString[1])][Integer.parseInt(numString[0])] = 1;
		}
		dfs(1);
		System.out.println(count-1);
	}
}

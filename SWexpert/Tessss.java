package SWexpert;

import java.util.Arrays;

public class Tessss {
	static int[] temp = new int[4];

	public static void main(String[] args) {
		dfs(0,0);
	}

	static void dfs(int index, int cnt) {
		if(index == 4)
			return;
		if (cnt == 4) {
			for(int i =0; i <4; i++)
				System.out.print(temp[i]+" ");
			System.out.println();
			return;
		}
		

		for (int i = 0; i < 4; i++) {
			temp[cnt] = i;
			dfs(index , cnt+1);
		}
	}
}

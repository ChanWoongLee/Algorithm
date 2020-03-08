package practice;

import java.util.Scanner;

public class B9465useDP {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int columns = sc.nextInt();
			int[][] stickers = new int[2][columns];
			int[][] dp = new int[columns][3];
			dpReset(dp,columns);
			for (int j = 0; j < 2; j++) {
				for (int j2 = 0; j2 < columns ; j2++) {
					stickers[j][j2]=sc.nextInt();
				}
			}
			System.out.println(sticker(stickers,dp,0,0,columns));
		}
	}

	
	static int sticker(int[][] s , int [][] dp,int c, int status, int columns) {
		if(c==columns) return 0;
		if(dp[c][status]!=-1) return dp[c][status];
		
		int result= sticker(s, dp, c+1, 0, columns);
		if(status!=1) result = Math.max(result,sticker(s,dp,c+1,1,columns)+s[0][c]);
		if(status!=2) result = Math.max(result,sticker(s,dp,c+1,2,columns)+s[1][c]);
		dp[c][status]=result;
		return result;
		
	}
	
	static void dpReset(int[][] dp, int columns) {
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j]=-1;
			}
		}
	}
	
}

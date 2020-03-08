package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726 {
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(bf.readLine());
		dp = new  int[length+1];
		System.out.println(tiling(length));
	}
	static int tiling(int width) {
		if(width <= 1) return 1;
		
		if(dp[width]!= 0)
			return dp[width];
		
		return dp[width] = (tiling(width-2) + tiling(width-1))%10007;
	}
}

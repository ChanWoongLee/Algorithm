package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1463 {
	static int[] dp ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);// �ּҰ� ã������ ��� �� ũ��
		dp[1] = 0;
		for (int i = 1; i < n; i++) { // ���Ҿ� ������� �Ҽ��ִ� ��� Ƚ�� �����׾ư�
			if (i * 3 <= n && dp[i * 3] > dp[i] + 1) // ���⼭ �߿��Ѱ�  ������ �ִ����� �����Ϸ��� ������ Ŭ���� �ϴ°� �߿�
				dp[i * 3] = dp[i] + 1;
			if (i * 2 <= n && dp[i * 2] > dp[i] + 1)
				dp[i * 2] = dp[i] + 1;
			if(i + 1 <= n && dp[i+1] > dp[i] +1) 
				dp[i+1] = dp[i] + 1;
		}
		System.out.println(dp[n]);
		
		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);// �ּҰ� ã������ ��� �� ũ��
		dp[n] = 1;
		topdown(n);
	}
	
	static int topdown(int n) {
		return n;
		
	}
}

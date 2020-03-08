package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11055 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] LIS = new int[n+1];
		int[] dp = new int[n+1]; // index n ������ ���� �κм�������
		// ��ȭ����   ���� = ���������� �ִ� �κм��� + ���ݰ�!!  -> ��� ������ �ε��� ���� �� ���������� �ִ� �κм��� + �����ε���
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= n; i++) {
			LIS[i] = Integer.parseInt(st.nextToken());
			dp[i] = LIS[i];
		}
		int result = 0;
		if(n == 1) {
			System.out.println(dp[1]);
			return;
		}
		for(int i = 1; i <= n;  i++) {
			for(int j = 0; j < i; j++) {
				if(LIS[i] > LIS[j]	 && dp[i] < dp[j] + LIS[i]) {
					dp[i] = dp[j] + LIS[i];
				}
			}
			result = dp[i] > result ? dp[i] : result;
		}
		System.out.println(result);
	}

}

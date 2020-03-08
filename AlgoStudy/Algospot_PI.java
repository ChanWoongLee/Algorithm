package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 //��� Ʋ���� �𸣰ڴ�....
public class Algospot_PI {
	static int[] num;
	static int[] dp; // index���� ������ �ּ� ����

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		while (testCase-- > 0) {
			String[] str = bf.readLine().split("");
			num = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				num[i] = Integer.parseInt(str[i]);
			}
			dp = new int[str.length+1];
			Arrays.fill(dp, -1);
			System.out.println(memorize(0));
		}
	}

	static int pi(int start, int end) {
		boolean only = true;
		for(int i = start+1; i <= end; i++) {
			if(num[i] != num[start])
				only = false;
		}
		if(only)
			return 1;
		
		boolean progressive = true;
		for (int i = start; i < end; i++) {
			if (num[i + 1] - num[i] != num[start + 1] - num[start])
				progressive = false;
		}
		if (progressive && Math.abs(num[start + 1] - num[start]) == 1)
			return 2;
		if (progressive)
			return 5;
		
		boolean alternating = true; // ������ ���ö�
		for (int i = start; i <= end; i++) {
			if(start % 2 == 0) {
				if (num[i] != num[i % 2 + start]) // ¦���� ��ó�� Ȧ���� �������� ��
					alternating = false;
			}
			else {
				if (num[i] != num[i % 2 + start -1]) // ¦���� ��ó�� Ȧ���� �������� ��
					alternating = false;
			}
		}
		if (alternating)
			return 4;
		
		return 10;
	}

	static int memorize(int begin) {// pi(index) �Լ��� �ǹ� index���� ������ �ּ� ������ return �Ѵ�.
		if (begin == num.length)
			return 0;

		if (dp[begin] != -1)
			return dp[begin];
		dp[begin] = 987654321;
		for (int L = 3; L <= 5; L++) {
			if (begin + L <= num.length)
				dp[begin] = Math.min(dp[begin], memorize(begin + L) + pi(begin, begin + L - 1));
		}
		return dp[begin];
	}
}

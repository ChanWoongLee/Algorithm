package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5015 {
	static int[][] dp = new int[101][101];// dp�� �ǹ� 0 ���� ���ȵ� , -1 �����ȵ�, 1������
	static String str;
	static String[] strCaseAr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str = bf.readLine();
		int strCase = Integer.parseInt(bf.readLine());
		strCaseAr = new String[strCase];
		for (int i = 0; i < strCase; i++) {
			strCaseAr[i] = bf.readLine();
		}

		for (int i = 0; i < strCaseAr.length; i++) {
			dp = new int[101][101];
			if (find(0, 0, i) == 1)
				System.out.println(strCaseAr[i]);
		}
	}

	// static int find(int a, int b, int caseNum) {
	//
	// if (dp[a][b] != 0)
	// return dp[a][b];
	//
	// while (a < str.length() && b < strCaseAr[caseNum].length() && str.charAt(a)
	// == strCaseAr[caseNum].charAt(b)) {
	// a++;
	// b++;
	// }
	//
	// if (a == str.length()) {
	// if (b == strCaseAr[caseNum].length())
	// return dp[a][b] = 1;
	// else
	// return dp[a][b] = -1;
	// }
	//
	// if (str.charAt(a) == '*') {
	// for (int skip = 0; skip + b <= strCaseAr[caseNum].length(); skip++) {
	// if (find(a + 1, b + skip, caseNum) == 1) {
	// dp[a][b] = 1;
	// return dp[a][b];
	// }
	// }
	// }
	// dp[a][b] = 0;
	// return dp[a][b];
	// }
	static int find(int a, int b, int caseNum) {// ���ڿ� ������ �߿�!
		if (dp[a][b] != 0)
			return dp[a][b];

		if (a < str.length() && b < strCaseAr[caseNum].length() && str.charAt(a) == strCaseAr[caseNum].charAt(b)) {
			dp[a][b] = find(a + 1, b + 1, caseNum); // �ǹ̻� �ؼ��� �߿�!!
			return dp[a][b];
		}
		
		if (a == str.length()) {
			if (b == strCaseAr[caseNum].length())
				return dp[a][b] = 1;
			else
				return dp[a][b] = -1;
		}
		if (str.charAt(a) == '*') {
			if (find(a + 1, b, caseNum) == 1 || (b < strCaseAr[caseNum].length() && (find(a, b + 1, caseNum) == 1)))
				return dp[a][b] = 1;
		}

		return -1;

	}
}

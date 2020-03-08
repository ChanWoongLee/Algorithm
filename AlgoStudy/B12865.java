package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {
	static int N;
	static int K;
	static int[][] dp;// dp[i][j] i��° �������� Ž���� ������ , j��ŭ�� ���Ը� ���������� ȹ���� ��ġ�� �ִ밡ġ
	// �̷��� ���ϸ� �ڿ������� �״����� ����, ��ȭ��, �κб��� �� ǥ���� �� �� �ִ� !!! �̴ܰ谡 ���� �߿��ѵ�!!
	// �ϴ� ���� Ž������ ������ �������� �޸������̼��� � �ǹ̷� �������� ��������!!
	// ���? �̷��� �ٵ� �ΰ����� ����-> i��° ���� ������ ��� dp[i][j] = dp[i-1][j - w[i]] + v[i];
	// -> i���� ���� �������� ������� dp[i][j] = dp[i-1][j];
	static int[] weigth;
	static int[] value;

	public static void main(String[] args) throws IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		weigth = new int[N+1];
		value = new int[N+1];
		for(int i = 1; i<= N; i++) {
			st = new StringTokenizer(bf.readLine());
			weigth[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i ++) {
			for(int j =0; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - weigth[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weigth[i]]+value[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}

package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_christmas {
	static int N;
	static int K;
	static int[] doll;
	static int[] pSum;
	static int result1;
	static int result2;
	// K��  ������ �Ѱ��� N��   
	// 1,2 ��  K��� ��ŭ ����
	// 1�� : K���� �ѹ��� �� �� �ִ� ��� ��  
	// -> ��� �κ��տ���  %K �� 0�ΰ�
	// H���� T����
	// (psum[T] - psum[H-1]) % K = 0
	//  (psum[T] - psum[H-1]) % K  = (psum[T]%K - psum[H-1]%k + k )%k = 0
	//  ����  psum[T]%k = psum[H-1]%k �϶� �ѹ��� �����ټ� ���� ����;; 
	
	// 2�� : ������ �ֹ� �� �� ������ ��ġ�� �ʰ� �ִ� ���??
	// index : 0 1 2 3 4 5 6 7 8 9
	// value : 3 5 7 8 9 6 3 3 4 5
	// maxBuy(i)  -> 0���� i��° ���� ������ ��ġ�� �ʴ�  -> i��°�� ������ �Ȼ������� ���� ������ 
	// maxBuy(i) = maxBuy(i-1)  // i��°��  �Ȼ�����
	//             + maxBuy(j-1) +1 
	// psum[j-1] = psum[i]  -> j���� i ����
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		while (testCase-- > 0) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			doll = new int[N + 1];
			pSum = new int[N + 1];
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= N; i++) {
				doll[i] = Integer.parseInt(st.nextToken());
				pSum[i] = pSum[i - 1] + doll[i];
			}

			
			for (int i = 0; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					if ( 0 == (pSum[j] - pSum[i])% K) {
						result1++;
						if(result1 > 20091101)
							result1 = 1;
					}
				}
			}
			
			
			
			
		}
	}

}

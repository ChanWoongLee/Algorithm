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
	// K명  인형의 총개수 N개   
	// 1,2 번  K배수 만큼 가능
	// 1번 : K명에게 한번에 줄 수 있는 방법 수  
	// -> 모든 부분합에서  %K 가 0인것
	// H부터 T까지
	// (psum[T] - psum[H-1]) % K = 0
	//  (psum[T] - psum[H-1]) % K  = (psum[T]%K - psum[H-1]%k + k )%k = 0
	//  따라서  psum[T]%k = psum[H-1]%k 일때 한번에 나눠줄수 있음 ㄷㄷ;; 
	
	// 2번 : 여러번 주문 할 수 있을때 겹치지 않게 최대 몇번??
	// index : 0 1 2 3 4 5 6 7 8 9
	// value : 3 5 7 8 9 6 3 3 4 5
	// maxBuy(i)  -> 0부터 i번째 까지 샀을때 겹치지 않는  -> i번째를 삿을때 안삿을때로 나눌 수있음 
	// maxBuy(i) = maxBuy(i-1)  // i번째를  안샀을때
	//             + maxBuy(j-1) +1 
	// psum[j-1] = psum[i]  -> j부터 i 까지
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

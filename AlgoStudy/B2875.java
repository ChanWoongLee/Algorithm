package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2875 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		for(int i = K ; i >= 0; i--) {
			int newN = N-i;
			int newM = M-(K-i);
			int cuple = Math.min(newN/2, newM);
			if (max < cuple) {
				max = cuple;
			}
		}
		System.out.println(max);
	}
	
	
	

}

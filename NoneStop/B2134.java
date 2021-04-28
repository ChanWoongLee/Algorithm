package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2134 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		long T = Long.parseLong(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		Long[] A = new Long[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		Long[] B = new Long[M];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}
		ArrayList<Long> subA = new ArrayList<>();
		ArrayList<Long> subB = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			long now = A[i];
			subA.add(now);
			for (int j = i + 1; j < N; j++) {
				now += A[j];
				subA.add(now);
			}
		}
		for (int i = 0; i < M; i++) {
			long now = B[i];
			subB.add(now);
			for (int j = i + 1; j < M; j++) {
				now += B[j];
				subB.add(now);
			}
		}
		int startA = 0;
		int startB = 0;
		Collections.sort(subA);
		Collections.sort(subB, (a, b) -> -Long.compare(a, b));
		long sum = 0;
		long ans = 0;
		while (true) {
			if (startA >= subA.size() || startB >= subB.size())
				break;
			long target = T - subB.get(startB);
			if (target == subA.get(startA)) {
				long cntA = 0;
				long cntB = 0;
				long nowA = subA.get(startA);
				long nowB = subB.get(startB);
				while (startA < subA.size() && subA.get(startA) == nowA) {
					cntA++;
					startA++;
				}
				while (startB < subB.size() && subB.get(startB) == nowB) {
					cntB++;
					startB++;
				}
				ans += cntA * cntB;
			} else if (target > subA.get(startA)) {
				startA++;
			} else {
				startB++;
			}
		}
		System.out.println(ans);
	}

}

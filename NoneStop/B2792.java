package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2792 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] ju = new int[m];
		int end = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			ju[i] = Integer.parseInt(st.nextToken());
			end = Math.max(ju[i], end);
		}
		int start = 1;
		int jiltu = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = (start + end) / 2;
			int people = 0;
			int nowJiltu = 0;
			for (int j : ju) {
				if (mid > j) {
					people += 1;
					nowJiltu = Math.max(nowJiltu, j);
				} else {
					people += j / mid;
					nowJiltu = Math.max(nowJiltu, Math.max((j % mid), mid));
				}
			}

			jiltu = Math.min(jiltu, nowJiltu);
			if (people > m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(jiltu);
	}

}

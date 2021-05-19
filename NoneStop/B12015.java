package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(0);
		for (int i = 0; i < n; i++) {
			if (ar.get(ar.size() - 1) < num[i])
				ar.add(num[i]);
			else {
				int start = 0;
				int end = ar.size() - 1;
				int mid = 0;
				while (start < end) {
					mid = (start + end) / 2;
					int now = ar.get(mid);
					
					if(now >= num[i]) {
						end = mid;
					}else
						start = mid+1;
					
				}
				ar.set(end, num[i]);
			}
		}
		System.out.println(ar.size()-1);
	}
}

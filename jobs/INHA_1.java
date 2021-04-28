package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class INHA_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ar.add(Integer.parseInt(bf.readLine()));
		}
		Collections.sort(ar);
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(ar, Integer.parseInt(bf.readLine())));
		}
	}

	public static int binarySearch(ArrayList<Integer> array, int target) {
		int start = 0;
		int end = array.size() - 1;
		int mid = (end + start) / 2;
		while (end - start >= 0) {
			if (array.get(mid) == target) {
				end = mid - 1;
			} else if (array.get(mid) <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = (end + start) / 2;
		}
		if (start >= array.size() || start < 0 || array.get(start) != target)
			return -1;
		return start;
	}

}

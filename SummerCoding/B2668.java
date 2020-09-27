package SummerCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B2668 {
	static ArrayList<Integer> res;
	static boolean[] visit;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		res = new ArrayList<>();
		int n = Integer.parseInt(bf.readLine());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		visit = new boolean[n + 1];
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				if (dfs(i, i)) {
					for (int r : res) {
						result.add(r);
					}
				} else {
					for (int r : res) {
						visit[r] = false;
					}
					visit[i] = false;
				}
				res.clear();
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		for (int r : result) {
			System.out.println(r);
		}
	}

	static boolean dfs(int node, int end) {
		if (end == arr[node]) {
			res.add(arr[node]);
			return true;
		}
		if (!visit[arr[node]]) {
			visit[arr[node]] = true;
			res.add(arr[node]);
			return dfs(arr[node], end);

		}
		return false;
	}
}

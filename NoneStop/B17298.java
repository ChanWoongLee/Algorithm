package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			if (stack.size() == 0)
				stack.add(i);
			else {
				while (!stack.isEmpty() && num[stack.peek() ]< num[i]) {
					ans[stack.pop()] = num[i];
				}
				stack.add(i);
			}
		}
		while(!stack.isEmpty()) {
			ans[stack.pop()]  = -1;
		}
		StringBuffer stb = new StringBuffer();
		for(int i = 0; i < n ; i++) {
			stb.append(ans[i] + " ");
		}
		System.out.println(stb.toString());
	}

}

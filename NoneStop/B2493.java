package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] top = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> index = new Stack<>();
		for (int i = 1; i <= n; i++) {
			if (index.isEmpty()) {
				index.add(i);
				System.out.print("0 ");
			} else {
				if (top[index.peek()] <= top[i]) {
					while (!index.isEmpty() && top[index.peek()] <= top[i]) {
						index.pop();
					}
					if (index.isEmpty())
						System.out.print("0 ");
					else
						System.out.print(index.peek() + " ");
					index.add(i);
				} else {
					System.out.print(index.peek() + " ");
					index.add(i);
				}
			}
		}
	}

}

package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class B1717 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int action = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			int aa = find(a);
			int bb = find(b);
			if(action == 0) {
				union(aa,bb);
			}else {
				if(aa != bb) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}
		}
		

	}

	static int find(int a) {
		if (parent[a] == a)
			return parent[a];
		else {
			return parent[a] = find(parent[a]);
		}
	}

	static void union(int a, int b) {
		int aa = find(a);
		int bb = find(b);
		parent[aa] = bb;
	}
}

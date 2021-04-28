package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15961 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] ar = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			ar[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[d + 1];
		int eat = 0;
		for (int i = 0; i < k; i++) {
			q.add(ar[i]);
			if (visit[ar[i]] == 0)
				eat++;
			visit[ar[i]]++;
		}
		if (visit[c] == 0)
			eat++;

		int ans = eat;

		for (int start = k; start < N; start++) {
			int remove = q.poll();
			visit[remove]--;
			if (visit[remove] == 0)
				eat--;

			q.add(ar[(start + k) % N]);
			if (visit[ar[(start + k) % N]] == 0)
				eat++;
			visit[ar[(start + k) % N]]++;

			if (visit[c] == 0)
				eat++;
			else
				eat--;

			if (ans < eat)
				ans = eat;
		}
		System.out.println(ans);
	}

}

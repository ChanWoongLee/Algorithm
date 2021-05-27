package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17612 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long ans = 0;
		long time = 0;
		PriorityQueue<Customer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> sequence = new PriorityQueue<>();
		for (int i = 1; i <= k; i++) {
			sequence.add(i);
		}
		int cnt = 1;
		Customer now;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int custNo = Integer.parseInt(st.nextToken());
			int goods = Integer.parseInt(st.nextToken());
			if (pq.size() == k) {
				now = pq.poll();
				time = now.outTime;
				ans += now.custNo * cnt;
				cnt++;
				sequence.add(now.index);
				while (!pq.isEmpty() && pq.peek().outTime == time) {
					now = pq.poll();
					ans += now.custNo * cnt;
					cnt++;
					sequence.add(now.index);
				}
			}
			pq.add(new Customer(custNo, time + goods, sequence.poll()));
		}

		while (!pq.isEmpty()) {
			now = pq.poll();
			time = now.outTime;
			ans += now.custNo * cnt;
			cnt++;
		}

		System.out.println(ans);
	}

	static class Customer implements Comparable<Customer> {
		int custNo, index;
		long outTime;

		public Customer(int custNo, long outTime, int index) {
			super();
			this.custNo = custNo;
			this.outTime = outTime;
			this.index = index;
		}

		@Override
		public int compareTo(Customer o) {
			return (int) (this.outTime == o.outTime ? o.index - this.index : this.outTime - o.outTime);
		}

	}
}

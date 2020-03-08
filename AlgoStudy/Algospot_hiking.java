package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Algospot_hiking {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		RMQ rmq1 = null; // 최소
		RMQ rmq2 = null; // 최대
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			t--;
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());// 원래 표지판수
			int q = Integer.parseInt(st.nextToken());// 개방고려 등산로 수
			int[] h = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++)
				h[i] = Integer.parseInt(st.nextToken());// 해발고도

			rmq1 = new RMQ(h); // 해발고도 배열을 그구간에서의 최소값을 저장하도록
			for (int i = 0; i < n; i++)
				h[i] *= -1; // 음수로 바꿔서 최대값을 찾는다 대박이네
			rmq2 = new RMQ(h);
			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				System.out.println(rmq2.query(l, r) * -1 - rmq1.query(l, r));

			}
		}
	}
}

class RMQ {
	private final int INF = 987654321;
	private int n; // 배열의 크기
	private int minRange[];

	public RMQ(int[] arr) {
		n = arr.length;
		minRange = new int[4 * n]; // 트리구간 별 최소값 저장
		init(arr, 0, n - 1, 1);

	}

	private int init(int[] arr, int left, int right, int node) { // 구간 트리 생성
		if (left == right)
			return minRange[node] = arr[left]; // 1의 크기 구간
		int mid = (left + right) / 2;
		int minLeft = init(arr, left, mid, node * 2);
		int minRight = init(arr, mid + 1, right, node * 2 + 1);

		return minRange[node] = min(minLeft, minRight); // 구간별 최소값 저장
	}

	public int min(int a, int b) {
		return (a > b) ? b : a;
	}

	public int query(int left, int right) { // 질문
		return query(left, right, 1, 0, n - 1);
	}

	private int query(int left, int right, int node, int leftNode, int rightNode) {
		if (right < leftNode || left > rightNode)
			return INF;
		if (left <= leftNode && rightNode <= right)
			return minRange[node]; // 구간안에 들어오면 값을 반환.
		int mid = (leftNode + rightNode) / 2;
		return min(query(left, right, node * 2, leftNode, mid), query(left, right, node * 2 + 1, mid + 1, rightNode));
	}
}

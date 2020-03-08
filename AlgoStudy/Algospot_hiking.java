package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Algospot_hiking {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		RMQ rmq1 = null; // �ּ�
		RMQ rmq2 = null; // �ִ�
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			t--;
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());// ���� ǥ���Ǽ�
			int q = Integer.parseInt(st.nextToken());// ������ ���� ��
			int[] h = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++)
				h[i] = Integer.parseInt(st.nextToken());// �ع߰�

			rmq1 = new RMQ(h); // �ع߰� �迭�� �ױ��������� �ּҰ��� �����ϵ���
			for (int i = 0; i < n; i++)
				h[i] *= -1; // ������ �ٲ㼭 �ִ밪�� ã�´� ����̳�
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
	private int n; // �迭�� ũ��
	private int minRange[];

	public RMQ(int[] arr) {
		n = arr.length;
		minRange = new int[4 * n]; // Ʈ������ �� �ּҰ� ����
		init(arr, 0, n - 1, 1);

	}

	private int init(int[] arr, int left, int right, int node) { // ���� Ʈ�� ����
		if (left == right)
			return minRange[node] = arr[left]; // 1�� ũ�� ����
		int mid = (left + right) / 2;
		int minLeft = init(arr, left, mid, node * 2);
		int minRight = init(arr, mid + 1, right, node * 2 + 1);

		return minRange[node] = min(minLeft, minRight); // ������ �ּҰ� ����
	}

	public int min(int a, int b) {
		return (a > b) ? b : a;
	}

	public int query(int left, int right) { // ����
		return query(left, right, 1, 0, n - 1);
	}

	private int query(int left, int right, int node, int leftNode, int rightNode) {
		if (right < leftNode || left > rightNode)
			return INF;
		if (left <= leftNode && rightNode <= right)
			return minRange[node]; // �����ȿ� ������ ���� ��ȯ.
		int mid = (leftNode + rightNode) / 2;
		return min(query(left, right, node * 2, leftNode, mid), query(left, right, node * 2 + 1, mid + 1, rightNode));
	}
}

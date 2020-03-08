package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algospot_treap {
	private int[] shifted = new int[50000];
	private int n;
	private int[] A = new int[50000];

	public class TreapNode { // Ʈ���� ��� �������� �ٸ����� �켱����
								// �켱������ ���� �Ʒ��� ���� ���� ��������
		private int key;
		private double priority;
		private int size;
		private TreapNode left, right;

		public TreapNode(int key) {
			this.key = key;
			priority = Math.random();
			size = 1;
		}

		public void setLeft(TreapNode newNode) {
			left = newNode;
			calcSize();
		}

		public void setRight(TreapNode newNode) {
			right = newNode;
			calcSize();
		}

		public void calcSize() {
			size = 1;
			if (left != null)
				size += left.size;
			if (right != null)
				size += right.size;
		}
	}

	public class Pair<L, R> { // C++�� pair �� �Ȱ���

		private final L left;
		private final R right;

		public Pair(L left, R right) {
			this.left = left;
			this.right = right;
		}

		public L getLeft() {
			return left;
		}

		public R getRight() {
			return right;
		}
	}

	public Pair<TreapNode, TreapNode> split(TreapNode root, int key) {// root�� �켱������ ���ε��� node���� ������
																		// ���� Ʈ���� node�� key���� ���� ������ �ɰ����Ҷ� �� �Լ�
		if (root == null)
			return new Pair(null, null); // ����

		if (root.key < key) {
			Pair<TreapNode, TreapNode> rs = split(root.right, key);
			root.setRight(rs.getLeft());// ������ �ڱ� ���ʾ� �޾Ƶΰ�
			return new Pair(root, rs.getRight());// ��ȯ
		}

		Pair<TreapNode, TreapNode> rs = split(root.left, key);
		root.setLeft(rs.getRight());
		return new Pair(rs.getLeft(), root);
	}// ���� �ű�

	public TreapNode insert(TreapNode root, TreapNode node) { // ���� split�� �̿��ؼ� root�� ���ο� node�� �߰��ϴ� �޼ҵ�
		if (root == null)
			return node;

		if (root.priority < node.priority) {
			Pair<TreapNode, TreapNode> splitted = split(root, node.key);
			// �� ���� ���� �Ʒ��� ���η���
			node.setLeft(splitted.getLeft());
			node.setRight(splitted.getRight());
			return node;
		} else if (node.key < root.key) { // �켱������ root�� ������� �׳� ����
			root.setLeft(insert(root.left, node));
		} else {
			root.setRight(insert(root.right, node));
		}
		return root;
	}

	public TreapNode merge(TreapNode a, TreapNode b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.priority < b.priority) {
			b.setLeft(merge(a, b.left));
			return b;
		}
		a.setRight(merge(a.right, b));
		return a;
	}

	public TreapNode erase(TreapNode root, int key) {
		if (root == null)
			return root; // ����

		if (root.key == key) { // ��Ʈ ���� ������ ������ �ڽ� �ؿ� ���η��ѰŶ� ���� �ڽ� ���η��Ѱ� merge�� �̿��ؼ� ��ħ
								// �̹� ũ�� �񱳴� ���ֱ� ������ �켱���� �񱳸� !! �߿�
			TreapNode ret = merge(root.left, root.right);
			root = null;
			return ret;
		}
		if (key < root.key) { // �ƴҶ� ��ͷ� ��������
			root.setLeft(erase(root.left, key));
		} else {
			root.setRight(erase(root.right, key));
		}
		return root;
	}

	public TreapNode kth(TreapNode root, int k) { // k��° ã��
		int leftSize = 0;
		if (root.left != null)
			leftSize = root.left.size;
		if (k <= leftSize)
			return kth(root.left, k);
		if (k == leftSize + 1)
			return root;
		return kth(root.right, k - leftSize - 1);
		// ���� ����Ʈ���� ũ�⸦ l�̶� �ϸ�
		// k <= l : k��° ���� ���� ����Ʈ��
		// k = l+1 : k��° ���� root
		// k > l+1 : k��° ���� ������ ����Ʈ������ (k-l-1)��° ���
	}

	public int countLessThan(TreapNode root, int key) {
		if (root == null)
			return 0;

		if (key <= root.key)
			return countLessThan(root.left, key);
		int ls = (root.left != null ? root.left.size : 0);
		return ls + 1 + countLessThan(root.right, key);
	}

	public void solve() {
		TreapNode candidates = null;
		for (int i = 0; i < n; i++) {
			candidates = insert(candidates, new TreapNode(i + 1));
		}

		for (int i = n - 1; i >= 0; i--) {

			int larger = shifted[i];
			TreapNode k = kth(candidates, i + 1 - larger);
			A[i] = k.key;
			candidates = erase(candidates, k.key);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int loop = Integer.parseInt(br.readLine());
		while (loop-- > 0) {
			Algospot_treap insertion = new Algospot_treap();

			insertion.n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < insertion.n; i++) {
				insertion.shifted[i] = Integer.parseInt(input[i]);
			}

			insertion.solve();

			for (int i = 0; i < insertion.n; i++) {
				System.out.print(insertion.A[i] + " ");
			}
			System.out.println();
		}
	}
}

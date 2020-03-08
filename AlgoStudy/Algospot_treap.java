package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algospot_treap {
	private int[] shifted = new int[50000];
	private int n;
	private int[] A = new int[50000];

	public class TreapNode { // 트립의 노드 기존노드와 다른점은 우선순위
								// 우선순위로 인해 아래로 갈지 위로 갈지정함
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

	public class Pair<L, R> { // C++의 pair 랑 똑같음

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

	public Pair<TreapNode, TreapNode> split(TreapNode root, int key) {// root의 우선순위가 새로들어온 node보다 낮을때
																		// 기존 트리를 node의 key기준 왼쪽 오른쪽 쪼개야할때 의 함수
		if (root == null)
			return new Pair(null, null); // 기저

		if (root.key < key) {
			Pair<TreapNode, TreapNode> rs = split(root.right, key);
			root.setRight(rs.getLeft());// 낮은거 자기 왼쪽아 달아두고
			return new Pair(root, rs.getRight());// 반환
		}

		Pair<TreapNode, TreapNode> rs = split(root.left, key);
		root.setLeft(rs.getRight());
		return new Pair(rs.getLeft(), root);
	}// 정말 신기

	public TreapNode insert(TreapNode root, TreapNode node) { // 실제 split을 이용해서 root에 새로운 node를 추가하는 메소드
		if (root == null)
			return node;

		if (root.priority < node.priority) {
			Pair<TreapNode, TreapNode> splitted = split(root, node.key);
			// 딱 나눌 두점 아래로 수두룩한
			node.setLeft(splitted.getLeft());
			node.setRight(splitted.getRight());
			return node;
		} else if (node.key < root.key) { // 우선순위가 root가 높을경우 그냥 진행
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
			return root; // 기저

		if (root.key == key) { // 루트 삭제 됬을때 오른쪽 자식 밑에 수두룩한거랑 왼쪽 자식 수두룩한거 merge를 이용해서 합침
								// 이미 크기 비교는 되있기 때문에 우선순위 비교만 !! 중요
			TreapNode ret = merge(root.left, root.right);
			root = null;
			return ret;
		}
		if (key < root.key) { // 아닐땐 재귀로 내려가서
			root.setLeft(erase(root.left, key));
		} else {
			root.setRight(erase(root.right, key));
		}
		return root;
	}

	public TreapNode kth(TreapNode root, int k) { // k번째 찾기
		int leftSize = 0;
		if (root.left != null)
			leftSize = root.left.size;
		if (k <= leftSize)
			return kth(root.left, k);
		if (k == leftSize + 1)
			return root;
		return kth(root.right, k - leftSize - 1);
		// 왼쪽 서브트리의 크기를 l이라 하면
		// k <= l : k번째 노드는 왼쪽 서브트리
		// k = l+1 : k번째 노드는 root
		// k > l+1 : k번째 노드는 오른쪽 서브트리에서 (k-l-1)번째 노드
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

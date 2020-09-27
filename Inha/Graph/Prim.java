package Inha.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

class Node { // 각 노드 정점을 클래스로 표현
	int s, e, v;

	public Node(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}

}

public class Prim {
	static int N;
	static int E;
	static ArrayList<Node>[] nodeList;
	static boolean visit[];
	static int ans;
	static ArrayList<Node> array = new ArrayList<Node>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 0; // 최종 최소 비용 출력을 위한 변수
		N = Integer.valueOf(br.readLine()); // 정점의 개수
		E = Integer.valueOf(br.readLine()); // 간선의 개수
		visit = new boolean[N + 1]; // 방문체크용 배열

		nodeList = new ArrayList[N + 1];
		// 각 노드의 연결상태를 저장하는 ArrayList :

		for (int i = 1; i <= N; i++) { // 각 배열 초기화
			nodeList[i] = new ArrayList<Node>();
		}

		String[] tempStr;
		int start;
		int end;
		int value;
		for (int i = 0; i < E; i++) {
			tempStr = br.readLine().split(" ");
			start = Integer.valueOf(tempStr[0]);
			end = Integer.valueOf(tempStr[1]);
			value = Integer.valueOf(tempStr[2]);
			nodeList[start].add(new Node(start, end, value));
			// s:1, e:2, 비용:2 를 nodeList[1]에 추가
			// 1] 2번노드, 3번노드, 4번노드
			nodeList[end].add(new Node(end, start, value));
			// s:2, e:1, 비용:2 를 nodeList[2]에 추가
			// 2] 1번노드. 3번노드, 7번 노드..
			// .....
		}

		MST();
		System.out.println();
	}

	public static void MST() {
		Comp cp = new Comp(); // 우선순위 큐를 활용해서 Min Heap 을 구현
		PriorityQueue<Node> pq = new PriorityQueue<>(cp); // 비용이 가장 작은 간선을 바로 뽑기 위한 우선순위 큐
		Deque<Integer> dq = new ArrayDeque<>(); // 정점 모두를 방문하는데 쓸 큐
		dq.add(1); // 시작점을 1번으로 지정
		ArrayList<Node> tempList;
		Node tempNode;
		while (!dq.isEmpty()) {
			// 큐에서 하나 빼서 주변의 노드를 다 넣음
			int currentNode = dq.poll(); // 최초 currentNode 는 1
			visit[currentNode] = true; // 해당 노드 방문 처리해서 한 번 방문해서 간선이 연결된 노드는 다시 처리하지 않음
			tempList = nodeList[currentNode]; // nodeList[1] = tempList = [2번노드,3번노드,4번노드]
			for (int i = 0; i < tempList.size(); i++) {
				if (!visit[tempList.get(i).e]) {
					pq.add(tempList.get(i)); // 현재 노드에 연결된 모든 간선을 우선순위큐에 add
				}
			}

			// 가장 작은 간선 빼서 값은 답으로 출력, 노드는 방문 처리
			// 만약 이미 방문한 것 중 작은 값이 나왔을 경우 한번 더 빼서 또 확인
			while (!pq.isEmpty()) { //
				tempNode = pq.poll(); // tempNode 는 현재 까지 진행한 노드에 연결된 간선중 가장 작은 값을 가진 노드
				if (!visit[tempNode.e]) {
					// 선택할 간선에 연결된 정점이 이미 방문한 곳이면 아무것도 하지 않고 첫 방문이면 정점을 연결하고 연결된 간선이 최소 신장트리를 이루는
					// 간선이므로
					// 결과값에 더해줌
					visit[tempNode.e] = true;
					ans += tempNode.v;
					dq.add(tempNode.e); // 연결된 노드를 큐에 넣어줌
					break;
				}
				// 이미 선택되어 방문된 노드에서 최소값이 나왔을 경우 아무것도 안함
			}

		}
		System.out.println(ans);
	}

}

class Comp implements Comparator<Node> { // 비용에 대한 Min Heap을 만들기 위한 우선순위 큐의 Comparator
	@Override
	public int compare(Node arg0, Node arg1) {
		return arg0.v > arg1.v ? 1 : -1;
	}

}
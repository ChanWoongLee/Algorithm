package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1655 {
	// priortyQueue�� ����ϴ°ͱ��� ����
	// �߰����� ��� ã���� ������ ����
	// ȿ���� �鿡�� �׻� � �ڷᱸ���� ���ؼ�, ������ ���ؼ� ��� �κ��� �������ϴ°Ͱ���!!!!!!! ��� �װ������� �ذ��Ϸ����ϸ�
	// ��������.
	// ������ ������ ���ؼ� �����ϴ��� �ؼ� Ǯ �� �ִٴ°� �������..
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int num = 0;
		PriorityQueue<Integer> minheap = new PriorityQueue<>((a, b) -> (a - b));
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> (b - a));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			num = Integer.parseInt(st.nextToken());
			if (minheap.size() == maxheap.size())
				maxheap.add(num);
			else
				minheap.add(num);
			
			if (!maxheap.isEmpty() && !minheap.isEmpty() &&maxheap.peek() > minheap.peek()) {
				int temp = maxheap.poll();
				maxheap.add(minheap.poll());
				minheap.add(temp);
			}
			System.out.println(maxheap.peek());
		}

	}

}

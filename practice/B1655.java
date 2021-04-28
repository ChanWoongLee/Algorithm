package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1655 {
	// priortyQueue를 써야하는것까지 인지
	// 중간값을 어떻게 찾을지 인지를 못함
	// 효율성 면에서 항상 어떤 자료구조를 더해서, 공간을 더해서 라는 부분을 생각못하는것같다!!!!!!! 계속 그공간에서 해결하려고하면
	// 답이읍다.
	// 기존에 공간을 더해서 저장하던가 해서 풀 수 있다는걸 명심하자..
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

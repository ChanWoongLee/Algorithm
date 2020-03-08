package AlgoStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Algosopt_midnum { // pq두 개만들 생각을 못했다. BST 정렬  nlogn 인데 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int length = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long[] A = new long[length];
			A[0] = 1983;
			long sum = 0;
			for (int j = 1; j < length; j++) {
				A[j] = (A[j - 1] * a + b) % 20090711;

			}
			PriorityQueue<Long> lowers = new PriorityQueue<>((c, d) -> -c.compareTo(d));
			PriorityQueue<Long> highers = new PriorityQueue<>();

			for (int j = 0; j < A.length; j++) {
				long number = A[j];
				if(lowers.size() == highers.size())
					highers.add(number);
				else
					lowers.add(number);
				
				if(!highers.isEmpty() && !lowers.isEmpty() && )
				if (lowers.isEmpty() || number < lowers.peek()) { // 최대힙의 크기는 초소힙의 크기와 같거나 하나 크다.
					lowers.add(number);
				} else {
					highers.add(number);
				}
				
				PriorityQueue<Long> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
				PriorityQueue<Long> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
				if (biggerHeap.size() - smallerHeap.size() >= 2) { 
					smallerHeap.add(biggerHeap.poll()); 
				}
				
				sum += getMedian(lowers, highers);
			}
			System.out.println(sum % 20090711);
		}

	}

	private static long getMedian(PriorityQueue<Long> lowers, PriorityQueue<Long> highers) {
		PriorityQueue<Long> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Long> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() == smallerHeap.size()) {
			return lowers.peek();
		} else {
			return biggerHeap.peek();
		}
	}


}
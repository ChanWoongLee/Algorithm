package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11000 {
	// 그 강의실을 재사용할 수 있으므로 강의 정보를 담을 자료구조가 필요하다.
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Room> rooms = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			rooms.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(rooms, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(rooms.get(0).end);
		for(int i =1 ; i < rooms.size(); i++) {
			if(pq.peek() <= rooms.get(i).start) {
				pq.poll();
			}
			pq.add(rooms.get(i).end);
			
		}
		System.out.println(pq.size());
	}

	static class Room {
		int start, end;

		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}

package AlgoStudy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Programers_truck {
	static Queue<truck> q;
	static int qSum;
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		int answer = 0;
		q = new LinkedList();
		qSum = 0;
		int index = 0;
		while (index < truck_weights.length) {
			if (weight >= truck_weights[index] + qSum) {
				q.add(new truck(truck_weights[index], bridge_length-1));
				qSum += truck_weights[index];
				index++;
			} // 다음꺼 들어올 수 있을때
			if(index == truck_weights.length) {
				answer++;
				break;
			}
			oneSecond();
			answer++;
		}
		System.out.println(answer+bridge_length);
	}
	
	static class truck{
		int weight;
		int time;
		public truck(int w, int t) {
			weight = w;
			time = t;
		}
	}
	public static void oneSecond() {
		int size = q.size();
		for(int i = 0; i < size; i++) {
			truck save = q.poll();
			if(save.time == 0)
				qSum-=save.weight;
			else
				q.add(new truck(save.weight, save.time-1));
				
		}
	}
}

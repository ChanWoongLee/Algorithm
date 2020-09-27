package practice;

import java.util.ArrayList;

public class Programers_GPS {

	public static void main(String[] args) {

	}

	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < edge_list.length; i++) {
			graph[edge_list[i][0]].add(edge_list[i][1]);
			graph[edge_list[i][1]].add(edge_list[i][0]);
		}
		for(int i  =)
		return answer;
	}
}

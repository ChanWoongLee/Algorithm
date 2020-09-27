package Inha;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework3_2 {
	static int[] dist;
	static ArrayList<Edge> list;

	public static void main(String[] args) {
		dist = new int[6];
		Arrays.fill(dist, Integer.MAX_VALUE);// ���Ѵ�� ���� �ʱ�ȭ
		list = new ArrayList<Edge>();
		list.add(new Edge(0, 1, 6));
		list.add(new Edge(0, 2, 5));
		list.add(new Edge(0, 3, 5));
		list.add(new Edge(1, 4, -1));
		list.add(new Edge(2, 1, -2));
		list.add(new Edge(2, 4, 1));
		list.add(new Edge(3, 2, -3));
		list.add(new Edge(3, 5, -1));
		list.add(new Edge(4, 5, 3));// ���� ����
		boolean b = bellmanFord(0);
		System.out.println("69 ������ �׷����� ���� �ּҰŸ�(���� node�� 0)");
		System.out.println("���� ����Ŭ ���� : " + b);
		for (int i = 0; i < dist.length; i++)
			System.out.print("0->" + i + " :" + dist[i] + ", ");
		System.out.println();
		System.out.println();
		dist = new int[8];
		Arrays.fill(dist, Integer.MAX_VALUE);// ���Ѵ�� ���� �ʱ�ȭ
		list = new ArrayList<Edge>();
		list.add(new Edge(0, 1, 8));
		list.add(new Edge(0, 3, 11));
		list.add(new Edge(0, 2, 9));
		list.add(new Edge(1, 4, 10));
		list.add(new Edge(2, 1, -15));
		list.add(new Edge(2, 4, 1));
		list.add(new Edge(2, 3, 3));
		list.add(new Edge(3, 5, 8));
		list.add(new Edge(3, 6, 8));
		list.add(new Edge(4, 7, 2));
		list.add(new Edge(5, 7, 5));
		list.add(new Edge(5, 2, 12));
		list.add(new Edge(7, 6, 4));
		b = bellmanFord(0);
		System.out.println("72 ������ �׷����� ���� �ּҰŸ�(���� node�� 0)");
		System.out.println("���� ����Ŭ ���� : " + b);
		for (int i = 0; i < dist.length; i++)
			System.out.print("0->" + i + " :" + dist[i] + ", ");
		System.out.println();
		System.out.println();

		int[][] problem2 = { { 1, 2 }, { 15, 8 }, { 7, 6, 8 }, { 10, 11 }, { 11, 5, 19 }, { 20, 13 }, { 17, },
				{ 1, 3, 8 }, { 18, 13 }, { 10, 4 }, { 3, 6, 7 }, { 0, 4 }, { 11, 19 }, { 12, 18 }, { 9, 3 }, { 4, 1 },
				{ 0, 14 }, { 6, 20 }, { 10, 13 }, { 9, 3 }, { 11, 15 } };
		int[][] weight = { { 2, 4 }, { -3, 6 }, { 13, 22, 10 }, { -1, 13 }, { 23, 1, 13 }, { 33, 10 }, { 5 },
				{ 5, -1, 3 }, { 8, 13 }, { 9, -3 }, { 2, 14, 19 }, { 13, 3 }, { 5, 10 }, { 3, 14 }, { -5, 1 },
				{ -10, 14 }, { -4, 4 }, { 6, 2 }, { 10, -13 }, { 9, -3 }, { 14, -1 } };
		list.clear();
		for (int i = 0; i < problem2.length; i++)
			for (int j = 0; j < problem2[i].length; j++)
				list.add(new Edge(i, problem2[i][j], weight[i][j])); // 1������ ���� �׷����� weight�� �߰��ؼ� ������ �����Ѵ�.
		dist = new int[problem2.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		b = bellmanFord(0);
		System.out.println("21��带 ������ ������ �׷����� ���� �ּҰŸ�(���� node�� 0)");
		System.out.println("���� ����Ŭ ���� : " + b);
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.print("0->" + i + " :�Ұ�, ");
			else
				System.out.print("0->" + i + " :" + dist[i] + ", ");
			if (i == 10)
				System.out.println();
		}

	}

	public static boolean bellmanFord(int start) {
		boolean cycle = false;
		dist[start] = 0; // ������ �ּҰŸ��� 0 ���� ����

		for (int i = 0; i < dist.length; i++) { // �� ��尳����ŭ �ݺ���
			for (int j = 0; j < list.size(); j++) { // ������ ����ŭ for�� �ݺ�
				int s = list.get(j).src;
				int e = list.get(j).dest;
				int w = list.get(j).weight;

				// ������ �ִܰ�ΰ� ���Ѵ밡 �ƴ� ���,
				// ������ �ִܰ�� + ���������� ����ġ�� ������ �ִܰ�κ��� ������
				if (dist[s] != Integer.MAX_VALUE && dist[s] + w < dist[e]) {
					dist[e] = dist[s] + w;
					// v���� ��忡���� �ݺ����� v�� �ݺ� �ϰԵǴµ�
					if (i == dist.length - 1)// ���� v ���� ������ �̷����ٸ� ���� ����Ŭ
						cycle = true;// �̿� ���ؼ��� �������� ���ϰ� ������ ����.
				}
			}
		}

		return cycle;

	}
}

class Edge {
	int src;
	int dest;
	int weight;

	Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}
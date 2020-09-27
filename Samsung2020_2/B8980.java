package Samsung2020_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B8980 {
	// �ڽ� ������ 1���� -> n^2�� �������� -> ���� ���� �Ұ�
	// ��Ž��� dp�� Ư���� �˰������� Ǯ�����
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(bf.readLine());
		Present[] presents = new Present[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			presents[i] = new Present(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(presents);
		int[] destinfo = new int[N + 1];
		Arrays.fill(destinfo, C);
		int truckWeight = 0;
		int result = 0;
		for (int i = 0; i < presents.length; i++) {
			Present now = presents[i];
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for (int j = now.start; j < now.end; j++) {
				if (destinfo[j] < min) {
					min = destinfo[j];
					minIdx = j;
				}
			}
			if (min > now.weight)
				min = now.weight;
			for (int j = now.start; j < now.end; j++) {
				destinfo[j] -= min;
			}
			result += min;

		}
		System.out.println(result);
	}

	static class Present implements Comparable<Present> {
		int start, end, weight;

		public Present(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Present o) {
			return this.end - o.end;
		}

	}
}

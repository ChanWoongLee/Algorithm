package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B1525_fail {
	static int[][] map = new int[3][3];
	static int[] move = { -1, 1, 3, -3 }; // ����, ������ ��, �Ʒ�

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String puzzle = "";
		for (int i = 0; i < 3; i++) {
			String[] str = bf.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				puzzle += str[j];
			}
		}
		ArrayList<String> visit = new ArrayList<>();
		Queue<String> q = new LinkedList<String>();
		q.add(puzzle);
		visit.add(puzzle);
		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			result++;
			for (int s = 0; s < size; s++) {
				String now = q.poll();
				int pos = now.indexOf("0");
				if (pos == 8)
					continue;
				for (int m = 0; m < 4; m++) {
					int nextPos = pos + move[m];
					if (nextPos < 0 || nextPos >= 9)
						continue;
					StringBuilder next = new StringBuilder(now);
					// 9�� �̵��� �����¿� �����ϱ�
					char temp = next.charAt(nextPos);
					next.setCharAt(nextPos, '0'); // �̵��� �ε����� 9��
					next.setCharAt(pos, temp); // ���� 9�ڸ��� �̵��� ���� ����
					if (next.equals("123456780")) {
						System.out.println(result);
						return;
					}
					if (visit.contains(next.toString()))
						continue;
					q.add(next.toString());
					visit.add(next.toString());
				}
			}
		}
		System.out.println("-1");
	}
}

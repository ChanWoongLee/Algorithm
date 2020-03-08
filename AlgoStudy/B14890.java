package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14890 {	
	static int[][] map;
	static boolean[][] load;
	static int RESULT = 0;
	static int N, length;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		length = Integer.parseInt(str[1]);

		load = new boolean[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			str = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			checkRow(i);
		}
		load = new boolean[N][N]; // �࿭ ���� �˻� ,load �ʱ�ȭ�ؾ��ؼ� �����ߵ�
		for (int i = 0; i < N; i++) {
			checkCol(i);
		}
		System.out.println(RESULT);

	}

	static void checkRow(int num) {
		int index = 1;
		int height = map[num][0];
		while (index < N ) {
			if (height == map[num][index]) {// ���̰� ������ ���� �ε��� �˻�
				index++;
				continue;
			}
			else if (height == map[num][index] - 1) {// ���� ���̰� 1 ������ , �ڿ���ġ
				if (index - length >= 0) {// ���� ���� �� �ִ� �Ÿ� üũ , �ȵǸ� ��� break
					for (int i = index - 1; i >= index - length; i--) {
						if (load[num][i] == true || map[num][i] != height) { // �̹� �������ְų�, �ڿ� ���̰� �޶������
							return;
						}
					}
					for (int i = index - 1; i >= index - length; i--) {
						load[num][i] = true;
					}
					height = map[num][index];
					index++;
				} 
				else
					break;
			}
			else if (height == map[num][index] + 1) {// ���� ���̰� 1������ , �տ� ����
				if (index + length - 1 < N) {
					for (int i = index; i < index + length; i++) {
						if(load[num][i] == true || map[num][i] != height-1) {// �̹� �������ְų�, �տ� ���̰� �޶������
							return;
						}
					}
					for(int i = index; i < index + length; i++) {
						load[num][i] = true;
					}
					index += length; // �տ� �̹� ���� ���ΰ��� �˻� ����
					height = map[num][index -1];
				}
				else
					break;
			} 
			else // �������̰� 1�̻��� ���
				break;
		}
		if(index >= N)
			RESULT++;
	}

	static void checkCol(int num) {
		int index = 1;
		int height = map[0][num];
		while (index < N ) {
			if (height == map[index][num]) {// ���̰� ������ ���� �ε��� �˻�
				index++;
				continue;
			}
			else if (height == map[index][num] - 1) {// ���� ���̰� 1 ������ , �ڿ���ġ
				if (index - length >= 0) {// ���� ���� �� �ִ� �Ÿ� üũ , �ȵǸ� ��� break
					for (int i = index - 1; i >= index - length; i--) {
						if (load[i][num] == true || map[i][num] != height) { // �̹� �������ְų�, �ڿ� ���̰� �޶������
							return;
						}
					}
					for (int i = index - 1; i >= index - length; i--) {
						load[i][num] = true;
					}
					height = map[index][num];
					index++;
				} 
				else
					break;
			}
			else if (height == map[index][num] + 1) {// ���� ���̰� 1������ , �տ� ����
				if (index + length - 1 < N) {
					for (int i = index; i < index + length; i++) {
						if(load[i][num] == true || map[i][num] != height-1) {// �̹� �������ְų�, �տ� ���̰� �޶������
							return;
						}
					}
					for(int i = index; i < index + length; i++) {
						load[i][num] = true;
					}
					index += length; // �տ� �̹� ���� ���ΰ��� �˻� ����
					height = map[index-1][num];
				}
				else
					break;
			} 
			else // �������̰� 1�̻��� ���
				break;
		}
		if(index >= N)
			RESULT++;
	}
}

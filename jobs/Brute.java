package jobs;

public class Brute {
	static int[] temp;
	static boolean[] visit;

	public static void main(String[] args) {
		int a = 3;
		temp = new int[3];
		visit = new boolean[3];
		johap(0, 1);
	}

	static void sunyel(int n) {
		if (n == 3) {// ���ȣ���� n�� �ϰڴ� �� ���ڸ������� �Լ��� �����ϰڴ�
						// �ڸ��������� index�� n�� ����
			for (int i = 0; i < 3; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i <= 2; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			temp[n] = i + 1;
			sunyel(n + 1);
			visit[i] = false;
		}
	}

	static void johap(int n, int value) {
		if (n == 3) {
			for (int i = 0; i < 3; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			return;
		}
		if (value == 5)
			return;
		temp[n] = value;
		johap(n + 1, value);
		johap(n, value + 1);
	}
}

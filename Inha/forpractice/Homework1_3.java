package Inha;

class pair {
	int num;
	char c;

	public pair(int num, char c) {
		this.num = num;
		this.c = c;
	}
}

public class Homework1_3 {

	public static void main(String[] args) {
		System.out.println("12151611_������_����1");
		System.out.println("shell, bitonic, odd-even-merge sort��  stable Ȯ��");
		pair[] test = new pair[16];
		int A = 65;
		for (int i = 0; i < test.length; i++)
			test[i] = new pair((int) (Math.random() * 10), (char) A++);// test �� 0~9 ������ ������ ä���

		System.out.println("�ʱ�迭");
		for (pair p : test) {
			System.out.print("(" + p.num + "," + p.c + ") ");
		}
		System.out.println();
		System.out.println();
		pair[] num1_shell = new pair[test.length];
		for (int i = 0; i < test.length; i++) {
			num1_shell[i] = new pair(test[i].num, test[i].c);
		}
		pair[] num1_bitonic = new pair[test.length];
		for (int i = 0; i < test.length; i++) {
			num1_bitonic[i] = new pair(test[i].num, test[i].c);
		}
		pair[] num1_oddeven = new pair[test.length];
		for (int i = 0; i < test.length; i++) {
			num1_oddeven[i] = new pair(test[i].num, test[i].c);
		}
		ShellSort(num1_shell, num1_shell.length);
		bitonicSort(num1_bitonic, 0, num1_bitonic.length, true);
		oddEvenMergeSort(num1_oddeven, 0, num1_oddeven.length);

		System.out.println("shell sort���Ľ�");
		for (pair p : num1_shell) {
			System.out.print("(" + p.num + "," + p.c + ") ");
		}
		System.out.println();
		System.out.println("bitonic sort���Ľ�");
		for (pair p : num1_bitonic) {
			System.out.print("(" + p.num + "," + p.c + ") ");
		}
		System.out.println();
		System.out.println("odd-even-merge sort���Ľ�");
		for (pair p : num1_oddeven) {
			System.out.print("(" + p.num + "," + p.c + ") ");
		}

	}

	public static void ShellSort(pair[] num, int size) {
		int interval = 0;
		for (int h = 1; h < size; h = 3 * h + 1) {// interval �� ���ϴ� �����̴�.
			interval = h;// 1 4 13 40 121 ... �� h���� ȭ�Ͽ��� num �ٷι��� h�� �ʱ� interval�� �����Ѵ�.
		}
		for (; interval > 0; interval /= 3) {// �ִ� interval���� ... 40 13 4 1���� �����ϸ鼭 ����
			for (int i = interval; i < size; i++) {// interval ���� �迭 ������ i�� 1�� Ŀ���µ�
													// �̶� i �� interval �������� �迭�� �˻��� �� �ڸ��� �����ϴ� insertionsort�� �����Ѵ�.
				for (int j = i; j - interval >= 0; j -= interval) {
					if (num[j].num > num[j - interval].num)// insertionsort�� ���ؼ� �ڱ⺸�� ū value�� �ִ� ���� index�̹Ƿ� break�Ѵ�.
						break;
					else {
						int temp = num[j].num;
						num[j].num = num[j - interval].num;
						num[j - interval].num = temp; // �� ����� num[j]�� �ڱ⺸�� ū���� ���ö����� �ڸ��� �������� �ű��.

						char tempc = num[j].c;
						num[j].c = num[j - interval].c;
						num[j - interval].c = tempc;
					}
				}
			}
		}
	}

	public static void bitonicSort(pair num[], int low, int cnt, boolean isAscending) {
		if (cnt > 1) {
			// cnt �� ���� bitonic sort�� ������ ����
			int k = cnt / 2;

			// �տ� ������ isAscending�� true�� ������������
			bitonicSort(num, low, k, true);
			// �ڿ� ������ isAscending�� false�� ������������
			bitonicSort(num, low + k, k, false);

			// true�� isAscending�� ���� ������ �ݹ� ���� �������� �����Ѱ� ������������ ����
			bitonicMerge(num, low, cnt, isAscending);
		}

	}

	public static void bitonicMerge(pair num[], int low, int cnt, boolean isAscending) {
		// cnt�� �ϳ����� Ŭ�� ������ �ǹ̰� �����Ƿ� cnt >1 �϶� ����
		if (cnt > 1) {
			int k = cnt / 2;
			for (int i = low; i < low + k; i++) {
				// ���� ������ �� �κ��� �� idex�� �ݳѾ index�ͺ��Ѵ�.
				if ((num[i].num > num[i + k].num && isAscending == true)
						|| (num[i].num < num[i + k].num && isAscending == false)) {
					int temp = num[i].num;
					num[i].num = num[i + k].num;
					num[i + k].num = temp;// ���� �պκ��� ���� ũ�ٸ� �ڷ� �����ش�.

					char tempc = num[i].c;
					num[i].c = num[i + k].c;
					num[i + k].c = tempc;
				}
			}
			bitonicMerge(num, low, k, isAscending);
			bitonicMerge(num, low + k, k, isAscending);// bitonicsort�� ���� ��ó�� merge ���� �ѹ��� �ƴ϶� ������ ������ merge�� �������ش�.
		}
	}

	public static void oddEvenMergeSort(pair[] num, int start, int end) {
		if (end > 1) {
			int m = end / 2;
			oddEvenMergeSort(num, start, m);
			oddEvenMergeSort(num, start + m, m);// bitonic sort�� ����ϰ� ���� ���ʹ� ���� ������ �����ش�.
			oddEvenMerge(num, start, end, 1);// ���� merge�� �����ش�.
		}
	}

	public static void oddEvenMerge(pair[] num, int start, int end, int distance) {
		int m = distance * 2;// distance�� 2�� �������� Ŀ���� �ȴ�.
		if (m < end) {// m�� end ���� ������
			oddEvenMerge(num, start, end, m); // even ����
			oddEvenMerge(num, start + distance, end, m); // odd ������ ����Ѵ�. ( distance�� ������ 1�̹Ƿ� )

			for (int i = start + distance; i + distance < start + end; i += m)// i�� start+disnace���� m���� Ŀ���鼭 num�� ���Ѵ�.
				if (num[i].num > num[i + distance].num) {// ���� i�� ���� ������ i���� ũ��
					int temp = num[i].num;
					num[i].num = num[i + distance].num;
					num[i + distance].num = temp;

					char tempc = num[i].c;
					num[i].c = num[i + distance].c;
					num[i + distance].c = tempc;
				}
		} else if (num[start].num > num[start + distance].num) {// end�� 2�϶� �׳� �ѹ��� �񱳸� �ʿ��ϴϱ� ���������� �°� ����
			int temp = num[start].num;
			num[start].num = num[start + distance].num;
			num[start + distance].num = temp;

			char tempc = num[start].c;
			num[start].c = num[start + distance].c;
			num[start + distance].c = tempc;
		}
	}
}

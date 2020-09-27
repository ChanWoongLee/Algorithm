package SummerCoding;

public class Programers_���ڰ��� {
	// 3 : 34
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7,10}));
	}
	// �ð��� ���� times Ƚ������ ���� ���ߵ�  -> �׷��� times�� ��� ���� �����Ҳ��� ??
	// ������������ �� ������
	// �ѽð��� ������ times �� ���� ��ŭ�� ������ ����ϱ� �̷������� �̺�Ž���� ����!!!!
	static public long solution(int n, int[] times) {
		long left = 0;
		long right = Long.MAX_VALUE;
		long middle = 0;
		long people = 0;
		while (left <= right) {
			people = 0;
			middle = (left + right) / 2;
			for (int i = 0; i < times.length; i++) {
				people += middle / times[i];
				if (people > n)
					break;
			}
			if (people >= n) {
				right = middle - 1;
			} else if (people < n) {
				left = middle + 1;
			}
		}

		return left;
	}
}

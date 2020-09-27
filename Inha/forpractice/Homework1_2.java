package Inha;

import java.util.Arrays;

public class Homework1_2 {

	public static void main(String[] args) {
		System.out.println("12151611_������_����1");
		System.out.println("quick sort  vs  median-of-three quick sort");

		for (int i = 0; i < 100; i++) {
			int[] num4 = new int[16777216];
			for (int j= 0; j < num4.length; j++)
				num4[j] = (int) (Math.random() * 100000000);// num4 �� 0~99999999 ������ ������ ä���

			int[] forquick = new int[num4.length];
			forquick = Arrays.copyOf(num4, num4.length);
			int[] formquick = new int[num4.length];
			formquick = Arrays.copyOf(num4, num4.length);

			long startTime = System.currentTimeMillis(); // ���� �ý��� �ð��� �и������������
			QuickSort(forquick, 0, forquick.length - 1);
			long finishTime = System.currentTimeMillis();
			System.out.println("QuickSort ���Ľð� : " + (finishTime - startTime) + "ms");

			startTime = System.currentTimeMillis(); // ���� �ý��� �ð��� �и������������
			MQuickSort(formquick, 0, formquick.length - 1);
			finishTime = System.currentTimeMillis();
			System.out.println("Median-of-three-QuickSort ���Ľð� : " + (finishTime - startTime) + "ms");
			System.out.println(
					"\n----------------------------------------------------------------------------------------------------------------");
		}


	}

	static void MQuickSort(int[] num, int start, int end) {
		if (start >= end)
			return;

		int one = num[start];// ù��°��
		int two = num[(start + end) / 2];// �߰���
		int three = num[end];// ��������
		int pivot = 0;

		// �Ʒ� ������ �� �� ���߿� �߰����� index�� pivot���� �����ϴ� �����̴�.
		if (one > two && one < three || one < two && one > three)
			pivot = start;
		else if (two > one && two < three || two < one && two > three)
			pivot = (start + end) / 2;
		else
			pivot = end;

		int temp = num[end];
		num[end] = num[pivot];
		num[pivot] = temp;// pivot�� ��ġ�� �� ������ �Ű��ش�.
		pivot = end; // pivot�� index���� ������ �Ű��ش�.

		int i = start;// i�� start ����
		int j = end - 1;// j�� �Ǻ� ���� ����
		while (true) {
			for (; i <= j; i++) {
				if (num[i] > num[pivot])// i�� ������Ű�鼭 pivot���� ū value�� index�� ã�´�.
					break;
			}
			for (; j >= i; j--) {
				if (num[j] < num[pivot])// j�� ���� ��Ű�鼭 pivot���� ���� value�� index�� ã�´�.
					break;
			}
			if (i < j) {// ���� j�� i �� ���� ���� �ʾҴٸ� i�� j�� ���� �ٲ��ְ� �� ������ �ݺ��Ѵ�.
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			} else// i�� j�� ������ٸ� ��ó�ش�.
				break;
		}

		temp = num[i];// i�� j�� ������ �������� i�� ������ pivot���� ���� ���� �ְ� �����ʿ��� pivot���� ū�����ֵ�.
		num[i] = num[pivot];
		num[pivot] = temp;// ���� i�� pivot�� �ڸ��� �ٲ��ָ� pivot�� �ش� �迭���� �ڽ��� �ڸ��� ã�� ���̴�.
		MQuickSort(num, start, i - 1);// pivot ������
		MQuickSort(num, i + 1, end);// pivot ���� �迭�� ���� quickSort�� �ٽ� �������ش�.
	}

	static void QuickSort(int[] num, int start, int end) {
		if (start >= end)
			return;

		int pivot = end;
		int temp = 0;
		int i = start;// i�� start ����
		int j = end - 1;// j�� �Ǻ� ���� ����
		while (true) {
			for (; i <= j; i++) {
				if (num[i] > num[pivot])// i�� ������Ű�鼭 pivot���� ū value�� index�� ã�´�.
					break;
			}
			for (; j >= i; j--) {
				if (num[j] < num[pivot])// j�� ���� ��Ű�鼭 pivot���� ���� value�� index�� ã�´�.
					break;
			}
			if (i < j) {// ���� j�� i �� ���� ���� �ʾҴٸ� i�� j�� ���� �ٲ��ְ� �� ������ �ݺ��Ѵ�.
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			} else// i�� j�� ������ٸ� ��ó�ش�.
				break;
		}

		temp = num[i];// i�� j�� ������ �������� i�� ������ pivot���� ���� ���� �ְ� �����ʿ��� pivot���� ū�����ֵ�.
		num[i] = num[pivot];
		num[pivot] = temp;// ���� i�� pivot�� �ڸ��� �ٲ��ָ� pivot�� �ش� �迭���� �ڽ��� �ڸ��� ã�� ���̴�.
		QuickSort(num, start, i - 1);// pivot ������
		QuickSort(num, i + 1, end);// pivot ���� �迭�� ���� quickSort�� �ٽ� �������ش�.
	}
}

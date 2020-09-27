package Inha;

import java.util.Arrays;

public class Homework1_2 {

	public static void main(String[] args) {
		System.out.println("12151611_이찬웅_과제1");
		System.out.println("quick sort  vs  median-of-three quick sort");

		for (int i = 0; i < 100; i++) {
			int[] num4 = new int[16777216];
			for (int j= 0; j < num4.length; j++)
				num4[j] = (int) (Math.random() * 100000000);// num4 을 0~99999999 까지의 난수로 채우기

			int[] forquick = new int[num4.length];
			forquick = Arrays.copyOf(num4, num4.length);
			int[] formquick = new int[num4.length];
			formquick = Arrays.copyOf(num4, num4.length);

			long startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
			QuickSort(forquick, 0, forquick.length - 1);
			long finishTime = System.currentTimeMillis();
			System.out.println("QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");

			startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
			MQuickSort(formquick, 0, formquick.length - 1);
			finishTime = System.currentTimeMillis();
			System.out.println("Median-of-three-QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");
			System.out.println(
					"\n----------------------------------------------------------------------------------------------------------------");
		}


	}

	static void MQuickSort(int[] num, int start, int end) {
		if (start >= end)
			return;

		int one = num[start];// 첫번째값
		int two = num[(start + end) / 2];// 중간값
		int three = num[end];// 마지막값
		int pivot = 0;

		// 아래 과정은 위 세 값중에 중간값인 index를 pivot으로 설정하는 과정이다.
		if (one > two && one < three || one < two && one > three)
			pivot = start;
		else if (two > one && two < three || two < one && two > three)
			pivot = (start + end) / 2;
		else
			pivot = end;

		int temp = num[end];
		num[end] = num[pivot];
		num[pivot] = temp;// pivot의 위치를 맨 끝으로 옮겨준다.
		pivot = end; // pivot의 index마저 끝으로 옮겨준다.

		int i = start;// i는 start 부터
		int j = end - 1;// j는 피봇 이전 부터
		while (true) {
			for (; i <= j; i++) {
				if (num[i] > num[pivot])// i를 증가시키면서 pivot보다 큰 value의 index를 찾는다.
					break;
			}
			for (; j >= i; j--) {
				if (num[j] < num[pivot])// j를 감소 시키면서 pivot보다 작은 value의 index를 찾는다.
					break;
			}
			if (i < j) {// 만약 j와 i 가 교차 하지 않았다면 i와 j의 값을 바꿔주고 위 과정을 반복한다.
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			} else// i와 j가 교차됬다면 멈처준다.
				break;
		}

		temp = num[i];// i와 j가 교차된 지점에서 i의 왼쪽은 pivot보다 작은 값이 있고 오른쪽에는 pivot보다 큰값이있따.
		num[i] = num[pivot];
		num[pivot] = temp;// 따라서 i와 pivot의 자리를 바꿔주면 pivot은 해당 배열에서 자신의 자리를 찾은 셈이다.
		MQuickSort(num, start, i - 1);// pivot 이전과
		MQuickSort(num, i + 1, end);// pivot 이후 배열로 나눠 quickSort를 다시 실행해준다.
	}

	static void QuickSort(int[] num, int start, int end) {
		if (start >= end)
			return;

		int pivot = end;
		int temp = 0;
		int i = start;// i는 start 부터
		int j = end - 1;// j는 피봇 이전 부터
		while (true) {
			for (; i <= j; i++) {
				if (num[i] > num[pivot])// i를 증가시키면서 pivot보다 큰 value의 index를 찾는다.
					break;
			}
			for (; j >= i; j--) {
				if (num[j] < num[pivot])// j를 감소 시키면서 pivot보다 작은 value의 index를 찾는다.
					break;
			}
			if (i < j) {// 만약 j와 i 가 교차 하지 않았다면 i와 j의 값을 바꿔주고 위 과정을 반복한다.
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			} else// i와 j가 교차됬다면 멈처준다.
				break;
		}

		temp = num[i];// i와 j가 교차된 지점에서 i의 왼쪽은 pivot보다 작은 값이 있고 오른쪽에는 pivot보다 큰값이있따.
		num[i] = num[pivot];
		num[pivot] = temp;// 따라서 i와 pivot의 자리를 바꿔주면 pivot은 해당 배열에서 자신의 자리를 찾은 셈이다.
		QuickSort(num, start, i - 1);// pivot 이전과
		QuickSort(num, i + 1, end);// pivot 이후 배열로 나눠 quickSort를 다시 실행해준다.
	}
}

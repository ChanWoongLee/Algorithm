package Inha;

import java.util.Arrays;

public class Homework {

	public static void main(String[] args) {
		System.out.println("Sort가 잘되는지 확인");
		int[] test = new int[32];
		for (int i = 0; i < test.length; i++)
			test[i] = (int) (Math.random() * 100);// test 을 0~99 까지의 난수로 채우기
		int[] test_selection = new int[test.length];
		test_selection = Arrays.copyOf(test, test.length);
		int[] test_quick = new int[test.length];
		test_quick = Arrays.copyOf(test, test.length);
		int[] test_shell = new int[test.length];
		test_shell = Arrays.copyOf(test, test.length);
		int[] test_bitonic = new int[test.length];
		test_bitonic = Arrays.copyOf(test, test.length);
		int[] test_oeMerge = new int[test.length];
		test_oeMerge = Arrays.copyOf(test, test.length);// 난수로 채워진 test를 깊은복사로 정렬할 각 동일한 배열을 생성

		System.out.print("초기 random value 배열: ");
		for (int i : test)
			System.out.print(i + " ");
		System.out.println();
		SelectionSort(test_selection);
		System.out.print("SelectionSort: ");
		for (int i : test_selection)
			System.out.print(i + " ");
		System.out.println();
		QuickSort(test_quick, 0, test_quick.length - 1);
		System.out.print("QuickSort : ");
		for (int i : test_quick)
			System.out.print(i + " ");
		System.out.println();
		ShellSort(test_shell, test_shell.length);
		System.out.print("ShellSort : ");
		for (int i : test_shell)
			System.out.print(i + " ");
		System.out.println();
		bitonicSort(test_bitonic, 0, test_bitonic.length, true);
		System.out.print("BitonicSort : ");
		for (int i : test_bitonic)
			System.out.print(i + " ");
		System.out.println();
		oddEvenMergeSort(test_oeMerge, 0, test_oeMerge.length);
		System.out.print("Odd-even-mergeSort : ");
		for (int i : test_oeMerge)
			System.out.print(i + " ");
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------");
		int[] num1 = new int[16384];
		for (int i = 0; i < num1.length; i++)
			num1[i] = (int) (Math.random() * 10000);// num1 을 0~9999 까지의 난수로 채우기
		int[] num2 = new int[524288];
		for (int i = 0; i < num2.length; i++)
			num2[i] = (int) (Math.random() * 1000000);// num2 을 0~999999 까지의 난수로 채우기
		int[] num3 = new int[2097152];
		for (int i = 0; i < num3.length; i++)
			num3[i] = (int) (Math.random() * 10000000);// num3 을 0~9999999 까지의 난수로 채우기
		int[] num4 = new int[16777216];
		for (int i = 0; i < num4.length; i++)
			num4[i] = (int) (Math.random() * 100000000);// num4 을 0~99999999 까지의 난수로 채우기
		int[] num5 = new int[4];
		for (int i = 0; i < num5.length; i++)
			num5[i] = (int) (Math.random() * 1000000000);// num5 을 0~999999999 까지의 난수로 채우기
		
		// 아래의 과정들은 num1,2,3,4에 저장된 난수를 정렬을위해 또다른 배열에 깊은 복사를해 저장해 원래의 배열의 값이 바뀌어도 변화가
		// 없도록 했다.
		int[] num1_selection = new int[num1.length];
		num1_selection = Arrays.copyOf(num1, num1.length);
		int[] num1_quick = new int[num1.length];
		num1_quick = Arrays.copyOf(num1, num1.length);
		int[] num1_shell = new int[num1.length];
		num1_shell = Arrays.copyOf(num1, num1.length);
		int[] num1_bitonic = new int[num1.length];
		num1_bitonic = Arrays.copyOf(num1, num1.length);
		int[] num1_oeMerge = new int[num1.length];
		num1_oeMerge = Arrays.copyOf(num1, num1.length);

		int[] num2_selection = new int[num2.length];
		num2_selection = Arrays.copyOf(num2, num2.length);
		int[] num2_quick = new int[num2.length];
		num2_quick = Arrays.copyOf(num2, num2.length);
		int[] num2_shell = new int[num2.length];
		num2_shell = Arrays.copyOf(num2, num2.length);
		int[] num2_bitonic = new int[num2.length];
		num2_bitonic = Arrays.copyOf(num2, num2.length);
		int[] num2_oeMerge = new int[num2.length];
		num2_oeMerge = Arrays.copyOf(num2, num2.length);

		int[] num3_selection = new int[num3.length];
		num3_selection = Arrays.copyOf(num3, num3.length);
		int[] num3_quick = new int[num3.length];
		num3_quick = Arrays.copyOf(num3, num3.length);
		int[] num3_shell = new int[num3.length];
		num3_shell = Arrays.copyOf(num3, num3.length);
		int[] num3_bitonic = new int[num3.length];
		num3_bitonic = Arrays.copyOf(num3, num3.length);
		int[] num3_oeMerge = new int[num3.length];
		num3_oeMerge = Arrays.copyOf(num3, num3.length);

		int[] num4_selection = new int[num4.length];
		num4_selection = Arrays.copyOf(num4, num4.length);
		int[] num4_quick = new int[num4.length];
		num4_quick = Arrays.copyOf(num4, num4.length);
		int[] num4_shell = new int[num4.length];
		num4_shell = Arrays.copyOf(num4, num4.length);
		int[] num4_bitonic = new int[num4.length];
		num4_bitonic = Arrays.copyOf(num4, num4.length);
		int[] num4_oeMerge = new int[num4.length];
		num4_oeMerge = Arrays.copyOf(num4, num4.length);
		
		int[] num5_selection = new int[num5.length];
		num5_selection = Arrays.copyOf(num5, num5.length);
		int[] num5_quick = new int[num5.length];
		num5_quick = Arrays.copyOf(num5, num5.length);
		int[] num5_shell = new int[num5.length];
		num5_shell = Arrays.copyOf(num5, num5.length);
		int[] num5_bitonic = new int[num5.length];
		num5_bitonic = Arrays.copyOf(num5, num5.length);
		int[] num5_oeMerge = new int[num5.length];
		num5_oeMerge = Arrays.copyOf(num5, num5.length);

		System.out.println("N = 16384");
		long startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
		SelectionSort(num1_selection);
		long finishTime = System.currentTimeMillis();
		System.out.println("SelectionSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		QuickSort(num1_quick, 0, num1_quick.length - 1);
		finishTime = System.currentTimeMillis();
		System.out.println("QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		ShellSort(num1_shell, num1_shell.length);
		finishTime = System.currentTimeMillis();
		System.out.println("ShellSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		bitonicSort(num1_bitonic, 0, num1_bitonic.length, true);
		finishTime = System.currentTimeMillis();
		System.out.println("BitonicSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		oddEvenMergeSort(num1_oeMerge, 0, num1_oeMerge.length);
		finishTime = System.currentTimeMillis();
		System.out.println("Odd-even-mergeSort 정렬시간 : " + (finishTime - startTime) + "ms");
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------");

		System.out.println("N = 524288");
		startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
		SelectionSort(num2_selection);
		finishTime = System.currentTimeMillis();
		System.out.println("SelectionSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		QuickSort(num2_quick, 0, num2_quick.length - 1);
		finishTime = System.currentTimeMillis();
		System.out.println("QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		ShellSort(num2_shell, num2_shell.length);
		finishTime = System.currentTimeMillis();
		System.out.println("ShellSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		bitonicSort(num2_bitonic, 0, num2_bitonic.length, true);
		finishTime = System.currentTimeMillis();
		System.out.println("BitonicSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		oddEvenMergeSort(num2_oeMerge, 0, num2_oeMerge.length);
		finishTime = System.currentTimeMillis();
		System.out.println("Odd-even-mergeSort 정렬시간 : " + (finishTime - startTime) + "ms");
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------");

		System.out.println("N = 2097152");
		startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
		SelectionSort(num3_selection);
		finishTime = System.currentTimeMillis();
		System.out.println("SelectionSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		QuickSort(num3_quick, 0, num3_quick.length - 1);
		finishTime = System.currentTimeMillis();
		System.out.println("QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		ShellSort(num1_shell, num3_shell.length);
		finishTime = System.currentTimeMillis();
		System.out.println("ShellSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		bitonicSort(num3_bitonic, 0, num3_bitonic.length, true);
		finishTime = System.currentTimeMillis();
		System.out.println("BitonicSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		oddEvenMergeSort(num3_oeMerge, 0, num3_oeMerge.length);
		finishTime = System.currentTimeMillis();
		System.out.println("Odd-even-mergeSort 정렬시간 : " + (finishTime - startTime) + "ms");
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------");

		System.out.println("N = 16777216");
		startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
		//SelectionSort(num4_selection);
		finishTime = System.currentTimeMillis();
		System.out.println("SelectionSort 정렬시간 : 너무 느려서 측정 불가");

		startTime = System.currentTimeMillis();
		QuickSort(num4_quick, 0, num4_quick.length - 1);
		finishTime = System.currentTimeMillis();
		System.out.println("QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		ShellSort(num4_shell, num4_shell.length);
		finishTime = System.currentTimeMillis();
		System.out.println("ShellSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		bitonicSort(num4_bitonic, 0, num4_bitonic.length, true);
		finishTime = System.currentTimeMillis();
		System.out.println("BitonicSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		oddEvenMergeSort(num4_oeMerge, 0, num4_oeMerge.length);
		finishTime = System.currentTimeMillis();
		System.out.println("Odd-even-mergeSort 정렬시간 : " + (finishTime - startTime) + "ms");
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------");
		
		System.out.println("N = 67108864‬");
		startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
		//SelectionSort(num5_selection);
		finishTime = System.currentTimeMillis();
		System.out.println("SelectionSort 정렬시간 : 너무 느려서 측정 불가");

		startTime = System.currentTimeMillis();
		QuickSort(num5_quick, 0, num5_quick.length - 1);
		finishTime = System.currentTimeMillis();
		System.out.println("QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		ShellSort(num5_shell, num5_shell.length);
		finishTime = System.currentTimeMillis();
		System.out.println("ShellSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		bitonicSort(num5_bitonic, 0, num5_bitonic.length, true);
		finishTime = System.currentTimeMillis();
		System.out.println("BitonicSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		oddEvenMergeSort(num5_oeMerge, 0, num5_oeMerge.length);
		finishTime = System.currentTimeMillis();
		System.out.println("Odd-even-mergeSort 정렬시간 : " + (finishTime - startTime) + "ms");
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------");

	}

	public static void SelectionSort(int[] num) {
		for (int i = 0; i < num.length; i++) {// i가 0~end 까지 순차적으로 증가하면서 최소 value를 가진 index를 찾는다.
			int minInx = i;// 먼저 현재 i의 위치를 최소 index라 하고
			for (int j = i + 1; j < num.length; j++) {// i부터 end까지 j를 증가시킨다.
				if (num[minInx] > num[j]) {// 그과정중 minindex보다 작은 value를 가진 index j가나오면
					minInx = j;// minindex를 j로 최신화
				}
			}
			int temp = num[i];
			num[i] = num[minInx];
			num[minInx] = temp;// minindex값과 i를 바꿔주어 최소값을 i자리에 오게한다.
		}
	}

	static void QuickSort(int[] num, int start, int end) {
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
		QuickSort(num, start, i - 1);// pivot 이전과
		QuickSort(num, i + 1, end);// pivot 이후 배열로 나눠 quickSort를 다시 실행해준다.
	}

	public static void ShellSort(int[] num, int size) {
		int interval = 0;
		for (int h = 1; h < size; h = 3 * h + 1) {// interval 을 구하는 과정이다.
			interval = h;// 1 4 13 40 121 ... 인 h정렬 화일에서 num 바로밑의 h를 초기 interval로 지정한다.
		}
		for (; interval > 0; interval /= 3) {// 최대 interval에서 ... 40 13 4 1까지 감소하면서 진행
			for (int i = interval; i < size; i++) {// interval 부터 배열 끝까지 i는 1씩 커지는데
													// 이때 i 가 interval 간격으로 배열을 검사해 들어갈 자리를 결정하는 insertionsort를 진행한다.
				for (int j = i; j - interval >= 0; j -= interval) {
					if (num[j] > num[j - interval])// insertionsort에 의해서 자기보다 큰 value가 있는 다음 index이므로 break한다.
						break;
					else {
						int temp = num[j];
						num[j] = num[j - interval];
						num[j - interval] = temp; // 비교 대상힌 num[j]는 자기보다 큰값이 나올때까지 자리를 왼쪽으로 옮긴다.
					}
				}
			}
		}
	}

	public static void bitonicSort(int num[], int low, int cnt, boolean isAscending) {
		if (cnt > 1) {
			int k = cnt / 2;

			// sort in ascending order since dir here is 1
			bitonicSort(num, low, k, true);

			// sort in descending order since dir here is 0
			bitonicSort(num, low + k, k, false);

			// Will merge wole sequence in ascending order
			// since dir=1.
			bitonicMerge(num, low, cnt, isAscending);
		}

	}

	public static void bitonicMerge(int num[], int low, int cnt, boolean isAscending) {
		if (cnt > 1) {
			int k = cnt / 2;
			for (int i = low; i < low + k; i++) {
				if ((num[i] > num[i + k] && isAscending == true) || (num[i] < num[i + k] && isAscending == false)) {
					// Swapping elements
					int temp = num[i];
					num[i] = num[i + k];
					num[i + k] = temp;
				}
			}
			bitonicMerge(num, low, k, isAscending);
			bitonicMerge(num, low + k, k, isAscending);
		}
	}

	public static void oddEvenMergeSort(int[] num, int start, int end) {
		if (end > 1) {
			int m = end / 2;
			oddEvenMergeSort(num, start, m);
			oddEvenMergeSort(num, start + m, m);
			oddEvenMerge(num, start, end, 1);
		}
	}

	/**
	 * lo is the starting position and n is the length of the piece to be merged, r
	 * is the distance of the elements to be compared
	 */
	public static void oddEvenMerge(int[] num, int start, int end, int distance) {
		int m = distance * 2;
		if (m < end) {
			oddEvenMerge(num, start, end, m); // even subsequence
			oddEvenMerge(num, start + distance, end, m); // odd subsequence
			for (int i = start + distance; i + distance < start + end; i += m)
				if (num[i] > num[i + distance]) {
					int temp = num[i];
					num[i] = num[i + distance];
					num[i + distance] = temp;
				}
		} else if (num[start] > num[start + distance]) {
			int temp = num[start];
			num[start] = num[start + distance];
			num[start + distance] = temp;
		}
	}
}

package Inha;

import java.util.Arrays;

public class Homework1 {

	public static void main(String[] args) {
		System.out.println("12151611_이찬웅_과제1");
		System.out.println("각 함수에 대해 Sort가 잘되는지 확인");
		int[] test = new int[32];
		for (int i = 0; i < test.length; i++)
			test[i] = (int) (Math.random() * 100);// test 을 0~99 까지의 난수로 채우기
		int[] test_selection = new int[test.length];
		test_selection = Arrays.copyOf(test, test.length);// selection sort를 할 배열
		int[] test_quick = new int[test.length];
		test_quick = Arrays.copyOf(test, test.length); // quicksort를 할 배열
		int[] test_shell = new int[test.length];
		test_shell = Arrays.copyOf(test, test.length);// shell sort를 할 배열
		int[] test_bitonic = new int[test.length];
		test_bitonic = Arrays.copyOf(test, test.length);// bitonic sort를 할 배열
		int[] test_oeMerge = new int[test.length];
		test_oeMerge = Arrays.copyOf(test, test.length);// odd even merge sort를 할 배열
		// 난수로 채워진 test를 깊은복사로 정렬할 각 동일한 배열을 생성
		System.out.print("초기 random value 배열: ");
		for (int i : test)
			System.out.print(i + " ");
		System.out.println();
		SelectionSort(test_selection);// selection sort 배열 시작
		System.out.print("SelectionSort: ");
		for (int i : test_selection)
			System.out.print(i + " ");
		System.out.println();
		QuickSort(test_quick, 0, test_quick.length - 1);// quick sort 배열 시작
		System.out.print("QuickSort : ");
		for (int i : test_quick)
			System.out.print(i + " ");
		System.out.println();
		ShellSort(test_shell, test_shell.length);// shell sort 배열 시작
		System.out.print("ShellSort : ");
		for (int i : test_shell)
			System.out.print(i + " ");
		System.out.println();
		bitonicSort(test_bitonic, 0, test_bitonic.length, true);// bitonic sort 배열 시작
		System.out.print("BitonicSort : ");
		for (int i : test_bitonic)
			System.out.print(i + " ");
		System.out.println();
		oddEvenMergeSort(test_oeMerge, 0, test_oeMerge.length);// odd even merge sort 배열 시작
		System.out.print("Odd-even-mergeSort : ");
		for (int i : test_oeMerge)
			System.out.print(i + " ");
		// test 배열을 복사받은 각각의 배열은 위와같이 sort함수에 들어가 sort 하게되고 걸린 시간을 출력한다.
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
		int[] num5 = new int[67108864];
		for (int i = 0; i < num5.length; i++)
			num5[i] = (int) (Math.random() * 1000000000);// num5 을 0~999999999 까지의 난수로채우기
		int[] num6 = new int[134217728];
		for (int i = 0; i < num6.length; i++)
			num6[i] = (int) (Math.random() * 1000000000);// num5 을 0~999999999 까지의 난수로 채우기

		// 아래의 과정들은 num1,2,3,4,5,6에 저장된 난수를 각각의 정렬을 위해 만든 또 다른 배열에 깊은 복사를 하는 과정이다.
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

		int[] num6_selection = new int[num6.length];
		num6_selection = Arrays.copyOf(num6, num6.length);
		int[] num6_quick = new int[num6.length];
		num6_quick = Arrays.copyOf(num6, num6.length);
		int[] num6_shell = new int[num6.length];
		num6_shell = Arrays.copyOf(num6, num6.length);
		int[] num6_bitonic = new int[num6.length];
		num6_bitonic = Arrays.copyOf(num6, num6.length);
		int[] num6_oeMerge = new int[num6.length];
		num6_oeMerge = Arrays.copyOf(num6, num6.length);
		
		// 성능 비교 시작
		System.out.println("N = 16384");
		long startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로 반환
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
		ShellSort(num3_shell, num3_shell.length);
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
		// SelectionSort(num4_selection);
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
		// SelectionSort(num5_selection); 너무느려서 제외
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
		oddEvenMergeSort(num5_oeMerge, 0, num5_oeMerge.length);
		finishTime = System.currentTimeMillis();
		System.out.println("Odd-even-mergeSort 정렬시간 : " + (finishTime - startTime) + "ms");
		startTime = System.currentTimeMillis();
		bitonicSort(num5_bitonic, 0, num5_bitonic.length, true);
		finishTime = System.currentTimeMillis();
		System.out.println("BitonicSort 정렬시간 : " + (finishTime - startTime) + "ms");

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------");

		System.out.println("N = 134217728");
		startTime = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드단위로
		// SelectionSort(num5_selection); 너무느려서 제외
		finishTime = System.currentTimeMillis();
		System.out.println("SelectionSort 정렬시간 : 너무 느려서 측정 불가");

		startTime = System.currentTimeMillis();
		QuickSort(num6_quick, 0, num6_quick.length - 1);
		finishTime = System.currentTimeMillis();
		System.out.println("QuickSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		ShellSort(num6_shell, num6_shell.length);
		finishTime = System.currentTimeMillis();
		System.out.println("ShellSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		bitonicSort(num6_bitonic, 0, num6_bitonic.length, true);
		finishTime = System.currentTimeMillis();
		System.out.println("BitonicSort 정렬시간 : " + (finishTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		oddEvenMergeSort(num6_oeMerge, 0, num6_oeMerge.length);
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
			pivot = end; // 결국 피봇은 처음 중간 마지막 중에 중앙값의 인덱스를 취하게된다.

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
			// cnt 는 현재 bitonic sort를 진행할 길이
			int k = cnt / 2;

			// 앞에 반쪽은 isAscending을 true로 오름차순정렬
			bitonicSort(num, low, k, true);
			// 뒤에 반쪽은 isAscending을 false로 내림차순정렬
			bitonicSort(num, low + k, k, false);

			// true인 isAscending에 따라 위에서 반반 오른 내림으로 정렬한것 오름차순으로 정렬
			bitonicMerge(num, low, cnt, isAscending);
		}

	}

	public static void bitonicMerge(int num[], int low, int cnt, boolean isAscending) {
		// cnt가 하나보다 클때 정렬의 의미가 있으므로 cnt >1 일때 진행
		if (cnt > 1) {
			int k = cnt / 2; // merge또한 반으로 나눠가면서 진행
			for (int i = low; i < low + k; i++) {// 오른 차순이 된 부분을 한 idex씩 반넘어서 index와비교한다.
				if (isAscending == (num[i] > num[i + k])) {// 만약 isAscending이 true라고 하면 앞에있는게 더클때 뒤와 바꿔준다.
					int temp = num[i];
					num[i] = num[i + k];
					num[i + k] = temp;// swap하는 코드이다.
				}
			}
			bitonicMerge(num, low, k, isAscending);// merge 시 오름차순과 내림차순이 된 배열을 이용해 isAscending에 따라 원하는대로 배열한다.
			bitonicMerge(num, low + k, k, isAscending);// bitonicsort로 나눈 것처럼 merge 또한 한번이 아니라 반으로 나눠서 merge를 진행해준다.
		}

	}

	public static void oddEvenMergeSort(int[] num, int start, int end) {
		if (end > 1) {
			int m = end / 2;
			oddEvenMergeSort(num, start, m);
			oddEvenMergeSort(num, start + m, m);// bitonic sort와 동일하게 먼저 앞쪽반 뒤쪽 반으로 나눠준다.
			oddEvenMerge(num, start, end, 1);// 다음 merge로 합쳐준다.
		}
	}

	public static void oddEvenMerge(int[] num, int start, int end, int distance) {
		int m = distance * 2;// distance는 2의 제곱으로 커지게 된다.
		if (m < end) {// m이 end 내에 있을때
			oddEvenMerge(num, start, end, m); // even 순서
			oddEvenMerge(num, start + distance, end, m); // odd 순서를 담당한다. ( distance의 시작은1이므로 )

			for (int i = start + distance; i + distance < start + end; i += m)// i는start+disnace부터 m으로 커지면서 num을 비교한다.
				compare(num, i, i + distance);// 만약 i가 다음 순서의 i보다 크면 스왑
		} else {// distance의 2배가 end보다 클때
			compare(num, start, start + distance);// 그냥 start 와 start+distace의 value 한번의 비교만 해주면된다.
		}
	}

	public static void compare(int[] num, int i, int j) {
		if (num[i] > num[j]) {// 앞에있는 값이 더크면 자리를 바꿔준다. (오름 차순을 위해)
			int t = num[i];// swap하는 구문이다. 
			num[i] = num[j];
			num[j] = t;
		}

	}
}

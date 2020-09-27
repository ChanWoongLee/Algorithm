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
		System.out.println("12151611_이찬웅_과제1");
		System.out.println("shell, bitonic, odd-even-merge sort의  stable 확인");
		pair[] test = new pair[16];
		int A = 65;
		for (int i = 0; i < test.length; i++)
			test[i] = new pair((int) (Math.random() * 10), (char) A++);// test 을 0~9 까지의 난수로 채우기

		System.out.println("초기배열");
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

		System.out.println("shell sort정렬시");
		for (pair p : num1_shell) {
			System.out.print("(" + p.num + "," + p.c + ") ");
		}
		System.out.println();
		System.out.println("bitonic sort정렬시");
		for (pair p : num1_bitonic) {
			System.out.print("(" + p.num + "," + p.c + ") ");
		}
		System.out.println();
		System.out.println("odd-even-merge sort정렬시");
		for (pair p : num1_oddeven) {
			System.out.print("(" + p.num + "," + p.c + ") ");
		}

	}

	public static void ShellSort(pair[] num, int size) {
		int interval = 0;
		for (int h = 1; h < size; h = 3 * h + 1) {// interval 을 구하는 과정이다.
			interval = h;// 1 4 13 40 121 ... 인 h정렬 화일에서 num 바로밑의 h를 초기 interval로 지정한다.
		}
		for (; interval > 0; interval /= 3) {// 최대 interval에서 ... 40 13 4 1까지 감소하면서 진행
			for (int i = interval; i < size; i++) {// interval 부터 배열 끝까지 i는 1씩 커지는데
													// 이때 i 가 interval 간격으로 배열을 검사해 들어갈 자리를 결정하는 insertionsort를 진행한다.
				for (int j = i; j - interval >= 0; j -= interval) {
					if (num[j].num > num[j - interval].num)// insertionsort에 의해서 자기보다 큰 value가 있는 다음 index이므로 break한다.
						break;
					else {
						int temp = num[j].num;
						num[j].num = num[j - interval].num;
						num[j - interval].num = temp; // 비교 대상힌 num[j]는 자기보다 큰값이 나올때까지 자리를 왼쪽으로 옮긴다.

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

	public static void bitonicMerge(pair num[], int low, int cnt, boolean isAscending) {
		// cnt가 하나보다 클때 정렬의 의미가 있으므로 cnt >1 일때 진행
		if (cnt > 1) {
			int k = cnt / 2;
			for (int i = low; i < low + k; i++) {
				// 오른 차순이 된 부분을 한 idex씩 반넘어서 index와비교한다.
				if ((num[i].num > num[i + k].num && isAscending == true)
						|| (num[i].num < num[i + k].num && isAscending == false)) {
					int temp = num[i].num;
					num[i].num = num[i + k].num;
					num[i + k].num = temp;// 만약 앞부분의 값이 크다면 뒤로 보내준다.

					char tempc = num[i].c;
					num[i].c = num[i + k].c;
					num[i + k].c = tempc;
				}
			}
			bitonicMerge(num, low, k, isAscending);
			bitonicMerge(num, low + k, k, isAscending);// bitonicsort로 나눈 것처럼 merge 또한 한번이 아니라 반으로 나눠서 merge를 진행해준다.
		}
	}

	public static void oddEvenMergeSort(pair[] num, int start, int end) {
		if (end > 1) {
			int m = end / 2;
			oddEvenMergeSort(num, start, m);
			oddEvenMergeSort(num, start + m, m);// bitonic sort와 비슷하게 먼저 앞쪽반 뒤쪽 반으로 나눠준다.
			oddEvenMerge(num, start, end, 1);// 다음 merge로 합쳐준다.
		}
	}

	public static void oddEvenMerge(pair[] num, int start, int end, int distance) {
		int m = distance * 2;// distance는 2의 제곱으로 커지게 된다.
		if (m < end) {// m이 end 내에 있을때
			oddEvenMerge(num, start, end, m); // even 순서
			oddEvenMerge(num, start + distance, end, m); // odd 순서를 담당한다. ( distance의 시작은 1이므로 )

			for (int i = start + distance; i + distance < start + end; i += m)// i는 start+disnace부터 m으로 커지면서 num을 비교한다.
				if (num[i].num > num[i + distance].num) {// 만약 i가 다음 순서의 i보다 크면
					int temp = num[i].num;
					num[i].num = num[i + distance].num;
					num[i + distance].num = temp;

					char tempc = num[i].c;
					num[i].c = num[i + distance].c;
					num[i + distance].c = tempc;
				}
		} else if (num[start].num > num[start + distance].num) {// end가 2일때 그냥 한번의 비교만 필요하니까 오름차순에 맞게 스왑
			int temp = num[start].num;
			num[start].num = num[start + distance].num;
			num[start + distance].num = temp;

			char tempc = num[start].c;
			num[start].c = num[start + distance].c;
			num[start + distance].c = tempc;
		}
	}
}

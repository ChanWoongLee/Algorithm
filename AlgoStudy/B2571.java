package AlgoStudy;

import java.util.Scanner;

public class B2571 {
	static int[] N;
	static int[] result;

	public static void merge(int start, int end) {
		if(start == end)
			return;
		int mid = (start + end) / 2;
		merge(start, mid);
		merge(mid+1, end);

		int point1 = start;// 끝은 미드+1 넘으면 over
		int point2 = mid+1;// 끝은 end+1 넘으면 over
		int index = start;
		for(int i = 0; i <= end-start; i++) {
			if(N[point1] < N[point2]) { // 앞쪽이 큰경우
				result[index] = N[point1];
				point1++;
				index++;
				if(point1 > mid) {
					int finish = end - point2;
					for(int j = 0; j <= finish; j++) {
						result[index] = N[point2];
						point2++;
						index++;
					}
					break;
				}
			}
			else {// 뒤쪽이 큰경우
				result[index] = N[point2];
				point2++;
				index++;
				if(point2 > end) {
					int finish = mid - point1;
					for(int j = 0; j <= finish; j++) {
						result[index] = N[point1];
						point1++;
						index++;
					}
					break;
				}
			}
			
		}
		
		for(int i = 0; i < N.length; i++) {// 핵심 정렬된거 N에다 계속 업데이트
			N[i] = result[i];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		N = new int[num];
		result = new int[num];
		for (int i = 0; i < num; i++) {
			N[i] = sc.nextInt();
			result[i] = N[i];
		} // N에 입력받은 수 배열로 입력
		
		merge(0, N.length - 1);
		
		for(int n : result) {
			System.out.println(n);
		}
	}

}

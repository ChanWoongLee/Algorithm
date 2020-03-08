package AlgoStudy;

import java.util.Scanner;

public class B1427 {
	static int[] N;
	static int[] result;

	public static void merge(int start, int end) {
		if(start == end)
			return;
		int mid = (start + end) / 2;
		merge(start, mid);
		merge(mid+1, end);

		int point1 = start;// ���� �̵�+1 ������ over
		int point2 = mid+1;// ���� end+1 ������ over
		int index = start;
		for(int i = 0; i <= end-start; i++) {
			if(N[point1] > N[point2]) { // ������ ū���
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
			else {// ������ ū���
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
		
		for(int i = 0; i < N.length; i++) {// ���ĵȰ� N���� ��� ������Ʈ
			N[i] = result[i];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		char[] numToChar = num.toCharArray();
		N = new int[num.length()];
		result = new int[num.length()];
		for (int i = 0; i < N.length; i++) {
			N[i] = Integer.parseInt(String.valueOf(numToChar[i]));
			result[i] = Integer.parseInt(String.valueOf(numToChar[i]));
		} // N�� �Է¹��� �� �迭�� �Է�
		
		merge(0, N.length - 1);
		
		for(int n : result) {
			System.out.print(n);
		}
	}

}

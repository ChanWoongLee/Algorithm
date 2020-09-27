package Inha;

public class NNsort {

	public static void main(String[] args) {
		// 오름 차순 기준
		int[] num = { 1, 2, 5, 8, 7, 9, 6, 5, 4, 3, 2 };
		BubbleSort(num);
		for (int a : num)
			System.out.print(a + " ");
		System.out.println();
		
		int[] num2 = { 1, 2, 5, 8, 7, 9, 6, 5, 4, 3, 2 };
		InsertionSort(num2);
		for (int a : num2)
			System.out.print(a + " ");
		System.out.println();
		
		int[] num3 = { 1, 2, 5, 8, 7, 9, 6, 5, 4, 3, 2 };
		SelectionSort(num3);
		for (int a : num3)
			System.out.print(a + " ");
		System.out.println();
	}

	public static void BubbleSort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}

			}
		}
	}

	public static void InsertionSort(int[] num) {
		for (int i = 1; i < num.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (num[j + 1] > num[j])
					break;
				else {
					int temp = num[j + 1];
					num[j + 1] = num[j];
					num[j] = temp;
				}
			}
		}
	}
	
	public static void SelectionSort(int[] num) {
		for(int i = 0; i < num.length; i++) {
			int minInx = i;
			for(int j = i+1; j < num.length; j++) {
				if(num[minInx] > num[j]) {
					minInx = j;
				}
			}
			int temp = num[i];
			num[i] = num[minInx];
			num[minInx] = temp;
		}
	}
}

package practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fuck {//힙솔트와 거의 흡사함

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int N=sc.nextInt();
		int []  card = new int [N];
		for (int i = 0; i < card.length ; i++) {
			card[i]=sc.nextInt();
					//r.nextInt(10);
		}
		if(N==2)
			System.out.println(card[0]+card[1]);
		else if(N==1)
			System.out.println(card[0]);
		else
			System.out.println(popAndPlus(card));
	}
	static long  popAndPlus(int[] a) {
		buildMaxHeap(a, a.length-1);
		int result=0;
		for (int i = 1; i < a.length-2; i++) {
		int plus = a[0]+a[1];
		result+=plus;
		a[0]=a[a.length-i];
		a[1]=a[a.length-i-1];
		a[a.length-i-1]=plus;
		buildMaxHeap(a,a.length-i-1);// a를  a.length-i 이후를 빼고 정렬하라
		System.out.println(Arrays.toString(a));
		System.out.println(result);
		}

		return 	result+=2*(a[0]+a[1])+a[2];
	}
	static void buildMaxHeap(int[]a,int n) {
		for (int i = n; i >= 0 ; i--) {
			heapify(a, i,n); // n 포함 까지 정렬하라
		}
	}
	static void heapify(int[] a, int motherNode,int n) {
		int leftChild = motherNode*2+1;
		int rightChild = leftChild+1;
		int smallest = 0 ;
		
		if(rightChild<=n && a[rightChild] <= a[motherNode])
			smallest = rightChild;
		else if (rightChild<=n &&leftChild<=n && a[rightChild]>a[leftChild])
			smallest= leftChild;
		else
			smallest=motherNode;
		
		if (leftChild <= n && a[leftChild] <= a[motherNode])
			smallest = leftChild;
		else
			smallest=motherNode;
		
		if(smallest!=motherNode) {
			swap(a,smallest,motherNode);
			heapify(a,smallest,n);
		}
	}
	static void swap(int[] a, int b, int c){
		int temp =a[b] ;
		a[b]=a[c];
		a[c]=temp;
	}
}

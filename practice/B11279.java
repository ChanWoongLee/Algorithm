package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class B11279 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		long[] h = new long[k];
		ArrayList<Long> ans = new ArrayList<Long>();
		int index=0;
		
		for (int i = k; i >0 ; i--) {
			long value = sc.nextLong();
			if (value==0) {
				if(index==0)
					ans.add((long) 0);
				else {
					bulidMaxHeap(h, index+1);
					ans.add(h[0]);
					for (int j = 0; j < index; j++) {
						h[j]=h[j+1];
					}
					h[index]=0;
					index--;
				}
			}
			else {
				h[index]=value;
				index++;
			}
		}
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	
	 static void bulidMaxHeap(long[] h, int n) {
		for (int i = n ; i >=0; i--) {
			heapify(h,i,n+1);
		}
	}
	 
	static void heapify(long[] h , int index, int n) {// i 이전 노드는 힙하게하되 n이상 노드는 건들지말것!

		int leftChild = index*2+1;
		int rightChild =leftChild +1 ;
		int large1=0;
		if(leftChild>=n&&rightChild>=n) return;
		
		if(h[leftChild]>h[index]) 
			large1=leftChild;
		else
			large1=index;
		
		if(rightChild<n && h[rightChild]>h[large1])
			large1=rightChild;
		
		if(large1!=index) {
			swap(h,large1,index);
			heapify(h,large1,n);
		}
		if(large1==index)return;

			
	}
	
	static void swap(long[] h ,int i, int j) {
		long save=0;
		save=h[i];
		h[i]=h[j];
		h[j]=save;
	}
}


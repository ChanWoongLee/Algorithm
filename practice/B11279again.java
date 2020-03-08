package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class B11279again {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		long[] h = new long[k];
		ArrayList<Long> ans = new ArrayList<Long>();
		int count=0;
		for (int i = k; i >0 ; i--) {
			long value = sc.nextLong();
			if (value==0) {
				if (count==0) {
					ans.add((long) 0);
				}
				else {
					 bulidMaxHeap(h);
					 ans.add(h[0]);
					 h[0]=0;
				}
			}
			else {
				h[count]=value;
				count++;
			}				
		}
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}

	}
	static void bulidMaxHeap(long[] h) {
		for (int i = h.length-1 ; i >=0; i--) {
			heapify(h,i);
		}
	}

	static void heapify(long[] h , int index) {// i 이전 노드는 힙하게하되 n이상 노드는 건들지말것!

		int leftChild = index*2+1;
		int rightChild =leftChild +1 ;
		int large1=0;
		if(leftChild>=h.length&&rightChild>=h.length) return;

		if(h[leftChild]>h[index]) 
			large1=leftChild;
		else
			large1=index;

		if(rightChild<h.length && h[rightChild]>h[large1])
			large1=rightChild;

		if(large1!=index) {
			swap(h,large1,index);
			heapify(h,large1);
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

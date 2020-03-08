package AlgoStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1427useHeap {
	//static int[] Num;
	static int heapNum;
	//static int n;
	public static void makeHeap(int index, int[] Num, int n) {
		if((index * 2 +2 > heapNum-1) && (index * 2 + 1 > heapNum-1)) {
			return;
		}// 자식 없음
		
		
		makeHeap(index * 2 +1, Num, n); // 왼쪽 자식검사
		makeHeap(index * 2 +2, Num, n); // 오른쪽 자식검사

		 
		if(index * 2 + 2 > heapNum -1) { //자식하나
			if(Num[index] < Num[index * 2 +1])
				valueSwap(Num,index, index * 2 + 1);			
		}
		else { // 자식 둘 
			if(Num[index] < Num[index * 2 + 1]) {
				if(Num[index * 2 +1] < Num[index * 2 + 2]) 
					valueSwap(Num,index, index * 2 + 2);
				else
					valueSwap(Num,index, index * 2 + 1);
			}
			else if(Num[index] < Num[index * 2 + 2]) {
				valueSwap(Num,index, index * 2 +2 );
			}
			
		}
	}
	public static void valueSwap(int[] Num,int a, int b) {
		int save = Num[a];
		Num[a] = Num[b];
		Num[b] = save;
	}

	public static void heapSort(int[] Num, int n) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < n ; i++) {
			makeHeap(0, Num, n);
			valueSwap(Num,0, heapNum-1);
			bw.write(String.valueOf(Num[heapNum-1])+"\n");
			heapNum--;
		}
		bw.flush(); bw.close();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] Num = new int[n];
		for(int i = 0; i < n; i++) {
			Num[i] = Integer.parseInt(bf.readLine());
		} // heap 이라  배열로 표현가능
		//heapNum = n;
		heapSort(Num,n);
	}

}

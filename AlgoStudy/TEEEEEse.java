package AlgoStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TEEEEEse {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int length = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long[] A = new long[length];
			A[0] = 1983;
			long sum = 0;
			for (int j = 1; j < length; j++) {
				A[j] = (A[j - 1] * a + b) % 20090711;

			}
		}
	}
	
	public static class Merge {

		 final static int MAX=10;   //정렬할 수의 갯수
		 int[] a = { 10,1,9,2,8,3,7,4,6,5 }; //a의 배열의 정렬할 임의의 값을 넣어준다.
		 int[] b = new int[MAX];    //b의 배열은 정렬된 값을 저장.
		 
		 public void merge(int first, int mid, int last){
		  int left_index_start = first;   // 왼쪽편 처음
		  int left_index_end = mid;    // 왼쪽편 마지막
		  int right_index_start = mid + 1;  // 오른쪽편 처음
		  int right_index_end = last;    // 오른편 마지막
		  int index = left_index_start;   // 정렬할 인덱스의 처음

		  for (; index <= right_index_end; index++)
		   if (left_index_start <= left_index_end
		     && right_index_start > right_index_end
		     || a[left_index_start] < a[right_index_start])
		    b[index] = a[left_index_start++];
		   else
		    b[index] = a[right_index_start++];
		  for (index = first; index <= last; index++)
		   a[index] = b[index];
		 }
		 
		 public void mergeSort(int first, int last){
		  if(last>first){
		   int mid = (first+last)/2;
		   mergeSort(first, mid);
		   mergeSort(mid+1, last);
		   merge(first, mid, last);
		  }
		 }
		 
		}
}

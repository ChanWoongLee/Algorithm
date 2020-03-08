package practice;


import java.util.Scanner;

public class B11047 {
	
	public static void main(String[] args) {
		//BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc2 = new Scanner(System.in);
		//String[] line = sc.readLine().trim().split(" ");
		//int N=Integer.parseInt(line[0]);
		//int K=Integer.parseInt(line[1]);
		int N=sc2.nextInt();
		int K=sc2.nextInt();
		int[] A = new int[K];
		for (int i = 0; i < N; i++) {
			A[i]=sc2.nextInt();
		}
		int count=0;
		while(true) {
			count+=(K/A[N-1]);
			K%=A[N-1];
			if(K==0)
				break;
			N--;
		}
		System.out.println(count);
	}
}

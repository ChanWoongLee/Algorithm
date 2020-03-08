package practice;

import java.util.Arrays;
import java.util.Scanner;

public class B2850_my {//그리디 방식이용

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();//나무개수
		int M = sc.nextInt();// 집에 가져가야하는 나무
		int[] tree = new int[N];
		for (int i = 0; i <N; i++) {
			tree[i]=sc.nextInt();
		}
		Arrays.sort(tree);
		int H=0;
		int needM=M;
		int d=1;
		int treeH=0;
		while(true) {
			if(N==1) {
				if(needM%d!=0)
					H=tree[N-1]-needM/d-1;
				else
					H=tree[N-1]-needM/d;
				break;
			}
			treeH=(tree[N-1]-tree[N-2])*d;//그리디한 트리개수는 배열그래프의 넓이
			if(treeH>=needM) {//포함되면
				if(needM%d!=0)//x축으로 나눈다음에 나머지있으면 그리디하게  나무 밑으로 한센치더
					H=tree[N-1]-needM/d-1;
				else//아니면 깔끔하게 
					H=tree[N-1]-needM/d;
				break;
			}
			else//포함되지않으면 니드엠에 배열그래프의 넓이 지우고 다시시작
				needM-=(tree[N-1]-tree[N-2])*d;
			d++;//x 축 증가
			N--;//배열 밑으로 검사
		}
		System.out.println(H);
	}

}

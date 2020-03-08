package practice;

import java.util.Scanner;

public class B1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k=1;//묶음 저격수
		int i=1;//숫사 저격수    -> 이 두개의 변수 설정이 관건
		int count = 1;// 
		while(true) {
			if(N==count)
				break;
			i--;// 묶음에서 숫자가 하나씩 줄어들고 1까지니까
			if(i==0) {// 0 까지가면
				k++;// 묶음의 앞자리 최대수를  하나늘려주고
				i=k; // i한테 보내줘서 다시 1씩 줄어들게만듬
			} 
			count++;// 카운터를 증가시켜  N 까지 오게만든다!
		}//결국 그 순서에 맞는  몇번째 묶음과 묶음의 최대수(k)와  분모 or 분자가 숫자(i) 를 구할수 있다. 
		//이렇게 할수 있는 이유는 분모 분자 반대로되있고 동일한 수의 규칙 때문임
		if((k+1)%2==0) 
			System.out.println(i+"/"+(k+1-i));
		else
			System.out.println((k+1-i)+"/"+i);
	}
}//지렸다;

package practice;

import java.util.Scanner;

public class B1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k=1;//���� ���ݼ�
		int i=1;//���� ���ݼ�    -> �� �ΰ��� ���� ������ ����
		int count = 1;// 
		while(true) {
			if(N==count)
				break;
			i--;// �������� ���ڰ� �ϳ��� �پ��� 1�����ϱ�
			if(i==0) {// 0 ��������
				k++;// ������ ���ڸ� �ִ����  �ϳ��÷��ְ�
				i=k; // i���� �����༭ �ٽ� 1�� �پ��Ը���
			} 
			count++;// ī���͸� ��������  N ���� ���Ը����!
		}//�ᱹ �� ������ �´�  ���° ������ ������ �ִ��(k)��  �и� or ���ڰ� ����(i) �� ���Ҽ� �ִ�. 
		//�̷��� �Ҽ� �ִ� ������ �и� ���� �ݴ�ε��ְ� ������ ���� ��Ģ ������
		if((k+1)%2==0) 
			System.out.println(i+"/"+(k+1-i));
		else
			System.out.println((k+1-i)+"/"+i);
	}
}//���ȴ�;

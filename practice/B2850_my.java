package practice;

import java.util.Arrays;
import java.util.Scanner;

public class B2850_my {//�׸��� ����̿�

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();//��������
		int M = sc.nextInt();// ���� ���������ϴ� ����
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
			treeH=(tree[N-1]-tree[N-2])*d;//�׸����� Ʈ�������� �迭�׷����� ����
			if(treeH>=needM) {//���ԵǸ�
				if(needM%d!=0)//x������ ���������� ������������ �׸����ϰ�  ���� ������ �Ѽ�ġ��
					H=tree[N-1]-needM/d-1;
				else//�ƴϸ� ����ϰ� 
					H=tree[N-1]-needM/d;
				break;
			}
			else//���Ե��������� �ϵ忥�� �迭�׷����� ���� ����� �ٽý���
				needM-=(tree[N-1]-tree[N-2])*d;
			d++;//x �� ����
			N--;//�迭 ������ �˻�
		}
		System.out.println(H);
	}

}

package SummerCoding;


public class Programers_�߱����� {

	public static void main(String[] args) {
		System.out.println(solution(3, new int[] { 1, 1 }));
	}
	// �� �̷��� �Ѱɱ� ......
	// �ϴ��� ����ū�ſ��� 1�� �����ϴ� ���������� �ϼ�
	// �������� ������..
	// �����ѵ� ū�ź��� 1������ ��� �������� �� �����ؾߵ� ;;
	// �� ��ɻ����ϴ°� ���ϴµ� ���� �켱������ �ֱ淡 �׷�������� ??
	// �׳� ū�� �������� ���� �ȵɱ� ?? �Ȱ����ǵ�!!!!!!
	// 
	static public long solution(int n, int[] works) {
		long answer = 0;
		while (n != 0) {
			int max = 0;
			for (int i = 0; i < works.length; i++) {
				max = max < works[i] ? works[i] : max;
			}
			if (max == 0)
				return 0;
			for (int i = 0; i < works.length; i++) {
				if (max == works[i] && n>0) {
					works[i]--;
					n--;
				}
			}
		}
		for(int i = 0; i < works.length; i++)
			answer += works[i]*works[i];

		return answer;
	}
}

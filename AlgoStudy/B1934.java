package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testcase = Integer.parseInt(st.nextToken());
		while(testcase-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int gcd = gcd(Math.max(a, b),Math.min(a, b));
			System.out.println((a/gcd)*(b/gcd)*gcd);
		}
	}
	
	static int gcd(int a,int b) {//a�� b�� ���� �������� r�̶� �ϸ�(��, a>b), a�� b�� �ִ������� b�� r�� �ִ������� ����.  -> ��Ŭ���� ȣ����  *���ͳ� ����
		while(b>0) {
			int save = a;
			a = b;
			b = save%b;
		}
		return a;
	}
}

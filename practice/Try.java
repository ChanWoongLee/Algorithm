package practice;

public class Try {

	public static void main(String[] args) {
		int n=12;
		int k=n;
		for (int i = 1; i < 4; i++) {
			k=n/(10^i)%10;
			n=n+k;
		}
		int d=(int) (123/(Math.pow(10, 2))%10);
		System.out.println(d);
	}

}

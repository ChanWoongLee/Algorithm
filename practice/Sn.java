package practice;

public class Sn {
	static int[] box = new int[10000];
	public static void main(String[] args) {
		Sn dd = new Sn();
		for (int i = 1; i < 10000; i++) {
			dd.d(i);
		}
		for (int i = 1; i < 10000; i++) {
			if(box[i]==0)
				System.out.println(i);	
			}
	}

	public void d(int n) {
		int k=n;
		while(true) {
			while(true) {
				k=k+n%10;
				n=n/10;
				if(n==0)
					break;
			}
			if(k>9999)
				break;
			if(box[k]==1)
				box[k]=2;
			else
				box[k]=1;
			n=k;
		}

	}
}


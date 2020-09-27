package Inha;

public class BubbleSort {
	public static void main(String[] args) {
		item[] a = new item[6];
		a[0] = new item(4, "a");
		a[1] = new item(4, "b");
		a[2] = new item(6, "c");
		a[3] = new item(2, "d");
		a[4] = new item(1, "e");
		a[5] = new item(3, "f");

		BubbleSort(a);
		
		for(item i: a) {
			System.out.println(i.key+" "+ i.str);
		}
	}

	public static void BubbleSort(item[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i].key > num[j].key) {
					int temp = num[i].key;
					String tempstr = num[i].str;
					num[i]= new item(num[j].key, num[j].str);
					num[j] =new item(temp, tempstr);
				}

			}
			for(item ii: num) {
				System.out.print(ii.key+","+ ii.str+" ");
			}System.out.println();
		}
	}
}

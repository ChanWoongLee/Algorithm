import java.util.Scanner;
 
public class ch {
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
 
        int N = s.nextInt();
         
        // �׽�Ʈ ���̽� 1~10��
        for (int i = 1; i <= N; i++) {
            int num = s.nextInt();  // �׽�Ʈ���̽� ��ȣ
            int[] array = new int[1000]; // 1000�� �л� ���� ������ �迭
             
            for (int j = 0; j < 1000; j++) { // 1000�� �л� ���� ����
                array[j] = s.nextInt();
            }
             
            // ī������ �迭 ���� 0~100
            int[] countarray = new int[101];
             
            for (int j = 0; j < 1000; j++) {
                countarray[array[j]]++;  // ī�����ϴ� �κ�
            }
 
            int result = 0;
            int temp = 0;
             
            for (int j = 100; j >=0 ; j--) {
                if(result < countarray[j]) {
                    result = countarray[j];
                    temp = j;
                }
            }
             
            System.out.println("#"+num+" "+temp);
                 
        } // end of for
         
         
         
         
    } // end of main
 
}// end of class
import java.util.Scanner;
 
public class ch {
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
 
        int N = s.nextInt();
         
        // 테스트 케이스 1~10개
        for (int i = 1; i <= N; i++) {
            int num = s.nextInt();  // 테스트케이스 번호
            int[] array = new int[1000]; // 1000명 학생 점수 저장할 배열
             
            for (int j = 0; j < 1000; j++) { // 1000명 학생 점수 저장
                array[j] = s.nextInt();
            }
             
            // 카운팅할 배열 선언 0~100
            int[] countarray = new int[101];
             
            for (int j = 0; j < 1000; j++) {
                countarray[array[j]]++;  // 카운팅하는 부분
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
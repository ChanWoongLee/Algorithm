package AlgoStudy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.Scanner;

public class B17256new {
   static String[][] load;
   static int[][] dp; //dp[x][y]  x행 y행까지의 최대 수 or 최소 수
   static int max =0;
   static int min = 0;
   
   public static int maxdp(int x, int y) {
      if(x==0 && y==0)
         return Integer.parseInt(load[0][0]);
//      if(dp[x][y] !=0)
//         return dp[x][y];
      int one = 0, two=0, three=0, four=0;
      
      if(y-2 >=0) {
         if(load[x][y-1] .equals("+")) {
            one =maxdp(x,y-2)+Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("-")) {
            one =maxdp(x,y-2)-Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("*")) {
            one =maxdp(x,y-2)*Integer.parseInt(load[x][y]);
         }
      }
      else
         one = -1;
      
      if(x-1 >=0 && y-1 >=0) {
         if(load[x][y-1] .equals("+")) {
            two =maxdp(x-1,y-1)+Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("-")) {
            two =maxdp(x-1,y-1)-Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("*")) {
            two =maxdp(x-1,y-1)*Integer.parseInt(load[x][y]);
         }
         
         if(load[x-1][y] .equals("+")) {
            three =maxdp(x-1,y-1)+Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y-1] .equals("-")) {
            three =maxdp(x-1,y-1)-Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y-1] .equals("*")) {
            three =maxdp(x-1,y-1)*Integer.parseInt(load[x][y]);
         }
      }
      else {
         three = -1;
         two = -1;
      }
      
      if(x-2 >=0) {
         if(load[x-1][y] .equals("+")) {
            four =maxdp(x-2,y)+Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y] .equals("-")) {
            four =maxdp(x-2,y)-Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y] .equals("*")) {
            four =maxdp(x-2,y)*Integer.parseInt(load[x][y]);
         }
      }
      else
         four = -1;
      return Math.max(Math.max(Math.max(one, two), three), four);
   }
   
   public static int mindp(int x, int y) {
      if(x==0 && y==0)
         return Integer.parseInt(load[0][0]);
      int one = 6500, two=6500, three=6500, four=6500;
      
      if(x-2 >=0) {
         if(load[x-1][y] .equals("+")) {
            four =mindp(x-2,y)+Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y] .equals("-")) {
            four =mindp(x-2,y)-Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y] .equals("*")) {
            four =mindp(x-2,y)*Integer.parseInt(load[x][y]);
         }
      }
      else
         four = 6500;
      
      if(y-2 >=0) {
         if(load[x][y-1] .equals("+")) {
            one =mindp(x,y-2)+Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("-")) {
            one =mindp(x,y-2)-Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("*")) {
            one =mindp(x,y-2)*Integer.parseInt(load[x][y]);
         }
      }
      else
         one = 6500;
      
      if(x-1 >=0 && y-1 >=0) {
         if(load[x][y-1] .equals("+")) {
            two =mindp(x-1,y-1)+Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("-")) {
            two =mindp(x-1,y-1)-Integer.parseInt(load[x][y]);
         }
         else if(load[x][y-1] .equals("*")) {
            two =mindp(x-1,y-1)*Integer.parseInt(load[x][y]);
         }
         
         if(load[x-1][y] .equals("+")) {
            three =mindp(x-1,y-1)+Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y-1] .equals("-")) {
            three =mindp(x-1,y-1)-Integer.parseInt(load[x][y]);
         }
         else if(load[x-1][y-1] .equals("*")) {
            three =mindp(x-1,y-1)*Integer.parseInt(load[x][y]);
         }
      }
      else {
         three = 6500;
         two = 6500;
      }
      return Math.min(Math.min(Math.min(one, two), three), four);
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      load = new String[n][n];
      dp = new int[n][n];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            load[i][j] = sc.next();
         }
      }
      
      System.out.println(maxdp(n-1,n-1)+" "+ mindp(n-1,n-1));
   }

}
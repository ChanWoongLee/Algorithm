package Samsung;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// ����� Ÿ���� ���Ѵ�.
// 9��Ÿ�ڱ��� �ƴµ� 3�ƿ��� �ƴϸ� 1������ �ٽ�
// 1: ��Ÿ, 2: 2��Ÿ, 3: 3��Ÿ, 4: Ȩ��, 0: �ƿ�
// ���� �����ϴ� ������ 1�� ������ 4��Ÿ��
/*
** Main
*/
// ����Ž��
// 1. perm Ÿ�� �����
// 2. ���� ����
// 3. �ִ� ã��


public class B17281_re {
    static int N, player_input[][], playerArr[], maxScore;
    static int visited[];

    static public void setPlayer(int idx) {
        if(idx == 10) {
            // startGame
            // playerArr[4] = 1;
            for(int i : playerArr)
            	System.out.print(i+" ");
            System.out.println();
        	//startGame(playerArr);
            return;
        }

        for(int i=2; i<10; i++) {
            if(visited[i]==1) continue;
            if(idx==4) idx++; 

            visited[i] = 1;
            playerArr[idx] = i;
            setPlayer(idx+1);
            visited[i] = 0;
        }
    }

    static public void startGame(int number[]) {
        int order = 1;
        int outCnt;
        int bat[] = new int[3];
        int score = 0;
        int res = 0;

        for(int turn=1; turn<=N; turn++) {
            outCnt = 0;
            bat[0] = 0;
            bat[1] = 0;
            bat[2] = 0;

            while(outCnt < 3) {
                if(order==10) order = 1;

                res = player_input[turn][number[order]];
                if(res == 0) {
                    outCnt++;
                } else if(res == 1) {
                    score += bat[2];
                    bat[2] = bat[1];
                    bat[1] = bat[0];
                    bat[0] = 1;
                } else if(res == 2) {
                    score += bat[2] + bat[1];
                    bat[2] = bat[0];
                    bat[1] = 1;
                    bat[0] = 0;
                } else if(res == 3) {
                    score += bat[2] + bat[1] + bat[0];
                    bat[2] = 1;
                    bat[1] = 0;
                    bat[0] = 0;
                } else if(res == 4) {
                    score += bat[2] + bat[1] + bat[0] + 1;
                    bat[2] = 0;
                    bat[1] = 0;
                    bat[0] = 0;
                }

                order += 1;
            }
        }

        maxScore = Math.max(maxScore, score);
    }

    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        player_input = new int[N+1][10];
        playerArr = new int[] {0,0,0,0,1,0,0,0,0,0};
        visited = new int[10];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                player_input[i][j] = Integer.parseInt(st.nextToken());        
            }
        }

        setPlayer(1);

        System.out.println(maxScore);
    }
}
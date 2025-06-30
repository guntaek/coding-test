package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'W') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

//        for(boolean[] b : map) {
//            for(boolean b1 : b) {
//                System.out.print(b1 + " ");
//            }
//            System.out.println();
//        }


        boolean flag;
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < M; i++) {
            flag = i % 2 != 0;

            for (int j = 0; j < N; j++) {
                if (map[i][j] == flag) {
                    c1++;
                }
                flag = !flag;
            }
        }

        for (int i = 0; i < M; i++) {
            flag = i % 2 == 0;

            for (int j = 0; j < N; j++) {
                if (map[i][j] == flag) {
                    c2++;
                }
                flag = !flag;
            }
        }

        System.out.println((M*N) - Math.max(c1, c2));
    }

}
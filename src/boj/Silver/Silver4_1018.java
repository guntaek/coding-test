package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int min = 64;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int c1 = 0;
                int c2 = 0;

                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (map[x][y] != 'W') c1++;
                            if (map[x][y] != 'B') c2++;
                        } else {
                            if (map[x][y] != 'B') c1++;
                            if (map[x][y] != 'W') c2++;
                        }
                    }
                }

                min = Math.min(min, Math.min(c1, c2));
            }
        }

        System.out.println(min);
    }
}

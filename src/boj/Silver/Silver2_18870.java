package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] x = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i][0] = i;
            x[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x, (o1, o2) -> o1[1] - o2[1]);

        x[0][2] = 0;
        int n = 1;
        for (int i = 1; i < N; i++) {
            if (x[i][1] == x[i-1][1]) {
                x[i][2] = x[i-1][2];
                continue;
            }

            x[i][2] = n;
            n++;
        }

        Arrays.sort(x, (o1, o2) -> o1[0] - o2[0]);

        StringBuilder sb = new StringBuilder();
        for (int[] a : x) {
            sb.append(a[2]).append(" ");
        }

        System.out.println(sb);
    }
}

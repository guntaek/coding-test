package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_15666 {
    static int N, M;
    static int[] src;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        pick = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(src);

        dfs(0);

        System.out.println(sb);

    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int num : pick) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;

        for (int i = 0; i < N; i++) {
            if (src[i] == prev) continue;
            pick[depth] = src[i];
            prev = src[i];
            dfs(depth + 1);
        }
    }
}

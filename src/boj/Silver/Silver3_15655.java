package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver3_15655 {
    static int[] src;
    static int[] tgt;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        src = new int[N];
        tgt = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(src);

        comb(0, 0);

        System.out.println(sb);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == tgt.length) {
            for (int i : tgt) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        if (srcIdx == src.length) return;

        tgt[tgtIdx] = src[srcIdx];
        comb(srcIdx + 1, tgtIdx + 1);
        comb(srcIdx + 1, tgtIdx);
    }
}

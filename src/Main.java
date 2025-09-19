import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] src;
    static int[] pick;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        pick = new int[M];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }

//        for (int i = 0; i < N; i++) {
//            src[i] = i + 1;
//        }

        Arrays.sort(src);

//        dfs(0, 0);
        dfs(0, 0);

        System.out.println(sb);

    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int n : pick) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;

        for (int i = start; i < N; i++) {
            if (src[i] == prev) continue;
            pick[depth] = src[i];
            prev = src[i];
            dfs(i, depth + 1);
        }
    }
}
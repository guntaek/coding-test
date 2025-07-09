package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 100000;
        boolean[] visited = new boolean[max + 1];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int time = cur[1];

            if (pos == K) {
                System.out.println(time);
                return;
            }

            int[] dx = {pos - 1, pos + 1, pos * 2};

            for (int d : dx) {
                if (d < 0 || d > max) continue;
                if (visited[d]) continue;

                visited[d] = true;
                queue.add(new int[]{d, time + 1});

            }
        }

    }
}

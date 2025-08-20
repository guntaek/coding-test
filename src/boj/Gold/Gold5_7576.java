package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_7576 {

    static int M, N;
    static int[][] map;
    static boolean[][] rotten;
    static int count;

    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        rotten = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    rotten[i][j] = true;
                }
                if (map[i][j] == -1) {
                    rotten[i][j] = true;
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!rotten[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs() {

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nCount = cur[2] + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !rotten[nx][ny] && map[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny, nCount});
                    rotten[nx][ny] = true;
                    count = nCount;
                }
            }
        }

    }
}
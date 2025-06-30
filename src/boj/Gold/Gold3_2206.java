package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Gold3_2206 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] tempVisited;
    static int min = Integer.MAX_VALUE;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        bfsToFindWall(0, 0, 1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    static void bfsToFindWall(int x, int y, int count) {
        visited[x][y] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, count});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (map[cur[0]][cur[1]] == 1) {
                tempVisited = new boolean[N][M];
                bfsToFindShortestPath(cur[0], cur[1], cur[2] + 1);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cur[2] + 1});
                }
            }

        }

    }

    static void bfsToFindShortestPath(int x, int y, int count) {
        tempVisited[x][y] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, count});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N-1 && cur[1] == M-1) {
                min = Math.min(min, cur[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && !tempVisited[nx][ny]) {
                    tempVisited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cur[2] + 1});
                }
            }

        }
    }
}

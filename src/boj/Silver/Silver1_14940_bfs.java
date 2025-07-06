package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_14940_bfs {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] answer;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if (k == 1) answer[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        int startX = -1, startY = -1;
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < m; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//
//                if (map[i][j] == 2) {
//                    startX = i;
//                    startY = j;
//                }
//
//                // 미리 갈 수 없는 곳은 0으로, 그 외는 -1로 초기화
//                if (map[i][j] == 0) {
//                    answer[i][j] = 0;
//                } else {
//                    answer[i][j] = -1;
//                }
//            }
//        }
//
//        bfs(startX, startY);
//
//        // 출력
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                int nCount = cur[2] + 1;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != 0) {
                    queue.offer(new int[]{nx, ny, nCount});
                    visited[nx][ny] = true;
                    answer[nx][ny] = nCount;
                }
            }
        }

    }
}

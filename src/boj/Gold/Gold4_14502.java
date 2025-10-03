package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_14502 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static int[][] copy;
    static List<int[]> empty = new ArrayList<>();
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    empty.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        int max = 0;

        for (int i = 0; i < empty.size() - 2; i++) {
            for (int j = i + 1; j < empty.size() - 1; j++) {
                for (int k = j + 1; k < empty.size(); k++) {

                    copy = new int[N][M];
                    for (int q = 0; q < N; q++) {
                        copy[q] = map[q].clone();
                    }

                    copy[empty.get(i)[0]][empty.get(i)[1]] = 1;
                    copy[empty.get(j)[0]][empty.get(j)[1]] = 1;
                    copy[empty.get(k)[0]][empty.get(k)[1]] = 1;

                    bfs();

                    max = Math.max(max, count(copy));
                }
            }
        }

        System.out.println(max);
    }

    static void bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int[] pos : virus) {
            queue.offer(new int[]{pos[0], pos[1]});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < N && ny < M && nx >= 0 && ny >= 0 && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static int count(int[][] map) {
        int cnt = 0;

        for (int[] arr : map) {
            for (int n : arr) {
                if (n == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

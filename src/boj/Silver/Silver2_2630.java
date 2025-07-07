package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_2630 {
    static int[][] paper;
    static int blue;
    static int white;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count(paper);

        System.out.println(white);
        System.out.println(blue);

    }

    static void count(int[][] p) {
        int length = p.length;

        if (check(p)) {
            if (p[0][0] == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            if (length == 1) return;
            count(copy(p, 0, 0));
            count(copy(p, 0, length / 2));
            count(copy(p, length / 2, 0));
            count(copy(p, length / 2, length / 2));
        }
    }

    static int[][] copy(int[][] p, int x, int y) {
        int length = p.length / 2;
        int[][] result = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result[i][j] = p[i+x][j+y];
            }
        }

        return result;
    }

    static boolean check(int[][] p) {
        int color = p[0][0];

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}

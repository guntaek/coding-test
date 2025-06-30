package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze1_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K == 0 || N == K) {
            System.out.println(1);
            return;
        }

        System.out.println(comb(N, K));
    }
    static int comb(int N, int K) {
        int[] factorial = new int[11];
        factorial[1] = 1;
        for (int i = 2; i <= 10; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        return factorial[N] / (factorial[N-K] * factorial[K]);
    }
}

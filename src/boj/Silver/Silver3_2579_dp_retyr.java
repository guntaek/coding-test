package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_2579_dp_retyr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];
        for (int i = 0; i < n; i++) {
            stairs[i + 1] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = stairs[1];
        dp[2] = dp[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i-1]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}

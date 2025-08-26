package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = N - i;

            String s = i + "";
            char[] digits = s.toCharArray();
            for (char digit : digits) {
                num -= (digit - '0');
            }

            if (num == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}

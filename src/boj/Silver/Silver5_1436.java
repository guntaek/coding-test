package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver5_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        int n = 0;

        while (count < N) {
            n++;
            String s = n + "";

            if (s.contains("666")) {
                count++;
            }

        }

        System.out.println(n);
    }
}
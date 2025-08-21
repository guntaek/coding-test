package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_17626_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 223; i++) {
            if (Math.pow(i, 2) == n) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 1; i <= 223; i++) {
            for (int j = 1; j <= 223; j++) {
                if (Math.pow(i, 2) + Math.pow(j, 2) == n) {
                    System.out.println(2);
                    return;
                }
            }
        }

        for (int i = 1; i <= 223; i++) {
            for (int j = 1; j <= 223; j++) {
                for (int p = 1; p <= 223; p++) {
                    if (Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(p, 2) == n) {
                        System.out.println(3);
                        return;
                    }
                }
            }
        }

        System.out.println(4);
    }
}

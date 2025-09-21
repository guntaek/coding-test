package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long r = 31;
        long M = 1234567891;
        long hash = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            int value = str.charAt(i) - 'a' + 1;

            hash = (hash + value * pow) % M;

            pow = (pow * r) % M;
        }

        System.out.println(hash);
    }
}

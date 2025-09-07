package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        input = input.trim();

        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            String[] words = input.split(" ");
            System.out.println(words.length);
        }

        br.close();
    }
}

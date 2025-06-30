package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Silver4_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] tokens = br.readLine().toCharArray();

            for (char token : tokens) {
                switch (token) {
                    case '(':
                        stack.push(token);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.poll();
                        } else {
                            stack.push(token);
                        }
                        break;
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }

        System.out.println(sb.toString());
    }
}

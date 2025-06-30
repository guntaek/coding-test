package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Silver4_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i < N+1; i++) {
            deque.addFirst(i);
        }

        while (deque.size() != 1) {
            deque.pollLast();

            int next = deque.pollLast();
            deque.addFirst(next);
        }

        System.out.println(deque.poll());
    }
}

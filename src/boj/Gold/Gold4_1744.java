package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        PriorityQueue<Integer> plus = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) plus.add(num);
            else minus.add(num);
        }

        int sum = 0;

        while (!plus.isEmpty()) {

            if (plus.peek() == 1) {
                plus.poll();
                sum++;
                continue;
            }
            int a = plus.poll();
            if (plus.isEmpty()) {
                sum += a;
                break;
            }

            if (plus.peek() == 1) {
                plus.poll();
                sum += a+1;
                continue;
            }
            int b = plus.poll();

            sum += a*b;
        }

        while (!minus.isEmpty()) {

            int a = minus.poll();
            if (minus.isEmpty()) {
                sum += a;
                break;
            }
            int b = minus.poll();
            sum += a*b;
        }

        System.out.println(sum);
    }
}

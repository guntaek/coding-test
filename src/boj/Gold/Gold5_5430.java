package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Gold5_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> queue = new ArrayDeque<>();

            if (n != 0) {
                String arr = br.readLine();
                String nums = arr.substring(1, arr.length() - 1);
                String[] nArr = nums.split(",");

                for (String num : nArr) {
                    queue.offer(Integer.parseInt(num));
                }

            } else {
                br.readLine();
            }

            boolean reverse = true;
            boolean isEmpty = false;

            for (char c : p) {
                switch (c) {
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':
                        if (queue.isEmpty()) {
                            isEmpty = true;
                            break;
                        }
                        if (reverse) {
                            queue.pollFirst();
                        } else {
                            queue.pollLast();
                        }
                        break;
                }
            }

            if (isEmpty) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (reverse) {
                while (!queue.isEmpty()) {
                    sb.append(queue.pollFirst());
                    if (!queue.isEmpty()) {
                        sb.append(",");
                    }
                }
            } else {
                while (!queue.isEmpty()) {
                    sb.append(queue.pollLast());
                    if (!queue.isEmpty()) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]");

            System.out.println(sb);

        }
    }
}

package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Silver4_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(queue.getFirst()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(queue.getLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}

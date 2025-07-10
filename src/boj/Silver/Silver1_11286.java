package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Silver1_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                    sb.append("0\n");
                } else if (minHeap.isEmpty()) {
                    sb.append(maxHeap.poll()).append("\n");
                } else if (maxHeap.isEmpty()) {
                    sb.append(minHeap.poll()).append("\n");
                } else {
                    if (Math.abs(maxHeap.peek()) == Math.abs(minHeap.peek())) {
                        sb.append(maxHeap.poll()).append("\n");
                    } else if (Math.abs(maxHeap.peek()) < Math.abs(minHeap.peek())) {
                        sb.append(maxHeap.poll()).append("\n");
                    } else if (Math.abs(maxHeap.peek()) > Math.abs(minHeap.peek())) {
                        sb.append(minHeap.poll()).append("\n");
                    }
                }
            } else if (x < 0) {
                maxHeap.offer(x);
            } else {
                minHeap.offer(x);
            }
        }
        System.out.println(sb);
    }
}

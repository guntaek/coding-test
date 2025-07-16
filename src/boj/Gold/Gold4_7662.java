package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "I":
                        maxHeap.offer(n);
                        minHeap.offer(n);
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        break;
                    case "D":
                        while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
                            maxHeap.poll();
                        }
                        while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
                            minHeap.poll();
                        }
                        if (n == 1) {
                            if (!maxHeap.isEmpty()) {
                                map.put(maxHeap.peek(), map.get(maxHeap.peek()) - 1);
                                maxHeap.poll();
                            }
                        } else {
                            if (!minHeap.isEmpty()) {
                                map.put(minHeap.peek(), map.get(minHeap.peek()) - 1);
                                minHeap.poll();
                            }
                        }
                        break;
                }

            }

            while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
                minHeap.poll();
            }

            if (maxHeap.isEmpty()) {
                System.out.println("EMPTY");
                continue;
            }

            System.out.println(maxHeap.peek() + " " + minHeap.peek());

        }
    }
}

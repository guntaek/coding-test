package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold5_13549_retry {

    static class Node implements Comparable<Node> {
        int v, c;

        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }

    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = 100001;

    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 1));
        for (int i = 0; i <= 100000; i++) {
            if (i > 0) graph.get(i).add(new Node(i - 1, 1));
            if (i < 100000) graph.get(i).add(new Node(i + 1, 1));
            if (i * 2 <= 100000) graph.get(i).add(new Node(i * 2, 0));
        }

        dijkstra(N);

        System.out.println(dist[K]);

    }

    static void dijkstra(int start) {
        dist = new int[100001];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curV = cur.v;
            int curC = cur.c;

            if (curC > dist[curV]) continue;

            for (Node next : graph.get(cur.v)) {
                int nextV = next.v;
                int nextC = dist[cur.v] + next.c;

                if (nextC < dist[nextV]) {
                    dist[nextV] = nextC;
                    pq.offer(new Node(nextV, nextC));
                }
            }
        }
    }
}

//// 방법 1: 0-1 BFS (Deque 사용) - 가장 효율적
//public class Main {
//    static class Node {
//        int pos, time;
//
//        Node(int pos, int time) {
//            this.pos = pos;
//            this.time = time;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        // 수빈이가 동생보다 뒤에 있으면 뒤로만 갈 수 있음
//        if (N >= K) {
//            System.out.println(N - K);
//            return;
//        }
//
//        System.out.println(bfs01(N, K));
//    }
//
//    static int bfs01(int N, int K) {
//        int MAX = 100001;
//        boolean[] visited = new boolean[MAX];
//        Deque<Node> dq = new ArrayDeque<>();
//
//        dq.offer(new Node(N, 0));
//        visited[N] = true;
//
//        while (!dq.isEmpty()) {
//            Node cur = dq.poll();
//
//            if (cur.pos == K) {
//                return cur.time;
//            }
//
//            // 순간이동 (0초) - 덱의 앞쪽에 추가
//            int teleport = cur.pos * 2;
//            if (teleport < MAX && !visited[teleport]) {
//                visited[teleport] = true;
//                dq.addFirst(new Node(teleport, cur.time));
//            }
//
//            // 뒤로 걷기 (1초) - 덱의 뒤쪽에 추가
//            int walkBack = cur.pos - 1;
//            if (walkBack >= 0 && !visited[walkBack]) {
//                visited[walkBack] = true;
//                dq.addLast(new Node(walkBack, cur.time + 1));
//            }
//
//            // 앞으로 걷기 (1초) - 덱의 뒤쪽에 추가
//            int walkForward = cur.pos + 1;
//            if (walkForward < MAX && !visited[walkForward]) {
//                visited[walkForward] = true;
//                dq.addLast(new Node(walkForward, cur.time + 1));
//            }
//        }
//
//        return -1;
//    }
//}

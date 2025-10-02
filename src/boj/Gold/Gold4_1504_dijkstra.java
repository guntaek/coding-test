package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_1504_dijkstra {
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

    static int V, E;
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        int start_v1 = dist[v1];
        int start_v2 = dist[v2];

        dijkstra(v1);
        int v1_v2 = dist[v2];
        int v1_N = dist[V];

        dijkstra(v2);
        int v2_v1 = dist[v1];
        int v2_N = dist[V];

        int path1 = start_v1 + v1_v2 + v2_N;  // 1->v1->v2->N
        int path2 = start_v2 + v2_v1 + v1_N;  // 1->v2->v1->N

        if (start_v1 >= INF || v1_v2 >= INF || v2_N >= INF) path1 = INF;
        if (start_v2 >= INF || v2_v1 >= INF || v1_N >= INF) path2 = INF;

        int answer = Math.min(path1, path2);
        System.out.println(answer >= INF ? -1 : answer);

    }

    static void dijkstra(int start) {
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.c > dist[cur.v]) {
                continue;
            }

            for (Node next : graph.get(cur.v)) {
                int nv = next.v;
                int nc = dist[cur.v] + next.c;

                if (nc < dist[nv]) {
                    dist[nv] = nc;
                    pq.offer(new Node(nv, nc));
                }
            }
        }
    }
}

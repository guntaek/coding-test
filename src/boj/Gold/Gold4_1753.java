package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_1753 {

    static class Node {
        int vertex, cost;

        Node(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }
    }

    static int V, E;
    static List<List<Node>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF").append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.cost - v2.cost);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = (Node) pq.poll();
            int curVertex = current.vertex;
            int curCost = current.cost;

            if (curCost > dist[curVertex]) {
                continue;
            }

            for (Node next : graph.get(curVertex)) {
                int nextVertex = next.vertex;
                int nextCost = dist[curVertex] + next.cost;

                if (nextCost < dist[nextVertex]) {
                    dist[nextVertex] = nextCost;
                    pq.offer(new Node(nextVertex, nextCost));
                }
            }
        }
    }
}

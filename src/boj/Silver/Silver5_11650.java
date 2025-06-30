package boj.Silver;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Silver5_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] point = new int[2];
            point[0] = Integer.parseInt(st.nextToken());
            point[1] = Integer.parseInt(st.nextToken());
            pq.add(point);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            bw.write(point[0] + " " + point[1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

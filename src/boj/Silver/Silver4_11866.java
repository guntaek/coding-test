package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Silver4_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }


        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int n = 1;
        while (dq.size() > 1) {
            if (n % K == 0) {
                sb.append(dq.poll()).append(", ");
                n++;
                continue;
            }
            dq.offer(dq.poll());
            n++;
        }
        sb.append(dq.poll()).append(">");

        System.out.println(sb);
    }
}

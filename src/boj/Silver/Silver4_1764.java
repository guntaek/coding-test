package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver4_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> notHear = new HashSet<>();
        HashSet<String> notSee = new HashSet<>();

        for (int i = 0; i < N; i++) {
            notHear.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            notSee.add(br.readLine());
        }

        Set<String> notHearSee = new HashSet<>();
        notHearSee.addAll(notHear);

        notHearSee.retainAll(notSee);

        StringBuilder sb = new StringBuilder();
        sb.append(notHearSee.size()).append('\n');

        List<String> list = new ArrayList<>(notHearSee);
        Collections.sort(list);

        for (String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}

package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Silver5_11723_bitmask_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add" :
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove" :
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check" :
                    if (set.contains(Integer.parseInt(st.nextToken()))) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle" :
                    int n = Integer.parseInt(st.nextToken());
                    if (set.contains(n)) {
                        set.remove(n);
                    } else {
                        set.add(n);
                    }
                    break;
                case "all" :
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty" :
                    set = new HashSet<>();
                    break;
            }
        }

        System.out.println(sb);
    }
}
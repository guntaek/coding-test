package boj.Silver;

import java.io.*;
import java.util.*;

public class Silver5_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] members = new String[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            members[i] = new String[] {String.valueOf(i), age, name};
        }

        Arrays.sort(members, (o1, o2) -> {
            int age1 = Integer.parseInt(o1[1]);
            int age2 = Integer.parseInt(o2[1]);

            if (age1 == age2) {
                int order1 = Integer.parseInt(o1[0]);
                int order2 = Integer.parseInt(o2[0]);

                return order1 - order2;
            }

            return age1 - age2;
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String[] m : members) {
            bw.write(m[1] + " " + m[2] + "\n");
        }

        bw.flush();
        bw.close();
    }
}

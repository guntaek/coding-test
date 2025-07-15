package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold5_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] schedule = new int[N][3];

        int maxEnd = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = end - start;

            maxEnd = Math.max(maxEnd, end);

            schedule[i] = new int[]{start, end, time};
        }

        Arrays.sort(schedule, (o1, o2) -> o1[2] - o2[2]);

        for (int[] i : schedule) {
            System.out.println(i[0] + " " + i[1] + " " + i[2]);
        }

//        int count = 0;
//        boolean[] booked = new boolean[maxEnd + 1];
//
//        for (int i = 0; i < N; i++) {
//            int[] book = schedule[i];
//
//            if (booked[start])
//        }

    }
}

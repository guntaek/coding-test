package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Silver2_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] counting = new int[8001];

        long sum = 0;
        int min = 4001, max = -4001;

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            counting[numbers[i] + 4000]++;
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        Arrays.sort(numbers);

        sb.append(Math.round((double) sum / N)).append('\n');

        sb.append(numbers[N / 2]).append('\n');

        int maxFreq = 0;
        for (int freq : counting) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int mode = 0, count = 0;
        for (int i = 0; i < 8001; i++) {
            if (counting[i] == maxFreq) {
                mode = i - 4000;
                if (++count == 2) break;
            }
        }
        sb.append(mode).append('\n');

        sb.append(max - min);

        System.out.print(sb);
    }
}

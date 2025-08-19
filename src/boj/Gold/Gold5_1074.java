package boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold5_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) + 1;
        int c = Integer.parseInt(st.nextToken()) + 1;

        int length = (int)Math.pow(2, N);

        int count = 0;

        while (length != 1) {

            if (r <= length / 2 && c <= length / 2) {

            } else if (r <= length / 2 && c > length / 2) {
                count += (int)Math.pow(length / 2, 2);
                c -= length / 2;
            } else if (r > length / 2 && c <= length / 2) {
                count += (int)Math.pow(length / 2, 2) * 2;
                r -= length / 2;
            } else if (r > length / 2 && c > length / 2) {
                count += (int)Math.pow(length / 2, 2) * 3;
                r -= length / 2;
                c -= length / 2;
            }

            length /= 2;

        }

        System.out.println(count);

    }
}

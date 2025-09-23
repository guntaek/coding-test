package boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String result = "";

        boolean isAscending = true;
        for (int i = 0; i < 8; i++) {
            if (arr[i] != i + 1) {
                isAscending = false;
                break;
            }
        }

        boolean isDescending = true;
        for (int i = 0; i < 8; i++) {
            if (arr[i] != 8 - i) {
                isDescending = false;
                break;
            }
        }

        if (isAscending) {
            result = "ascending";
        } else if (isDescending) {
            result = "descending";
        } else {
            result = "mixed";
        }

        System.out.println(result);
    }
}

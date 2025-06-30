package boj.Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_2805 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        int[] trees = new int[N];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            trees[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int minHeight = 0;
//        int maxHeight = Arrays.stream(trees).max().orElse(0);
//
//        while (minHeight <= maxHeight) {
//            int middleHeight = (minHeight + maxHeight) / 2;
//            int sum = 0;
//
//            for (int height : trees) {
//                if (height > middleHeight) sum += height - middleHeight;
//            }
//
//            if (sum >= M) {
//                minHeight = middleHeight + 1;
//            } else {
//                maxHeight = middleHeight - 1;
//            }
//        }
//
//
//        System.out.println(maxHeight);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        // 이진 탐색
        int low = 0;
        int high = max;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            if (total >= M) {
                result = mid; // 가능한 경우 저장
                low = mid + 1; // 더 높은 절단기 높이 시도
            } else {
                high = mid - 1; // 너무 많이 잘랐음 → 낮추기
            }
        }

        System.out.println(result);
    }
}

package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold4_3151 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;

        for(int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    if(arr[left] == arr[right]) {
                        int n = right - left + 1;
                        count += n * (n - 1) / 2;
                        break;
                    } else {
                        int leftCount = 1;
                        int rightCount = 1;
                        while(left + 1 < right && arr[left] == arr[left + 1]) {
                            leftCount++;
                            left++;
                        }
                        while(right - 1 > left && arr[right] == arr[right - 1]) {
                            rightCount++;
                            right--;
                        }
                        count += leftCount * rightCount;
                        left++;
                        right--;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}

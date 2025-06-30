package boj.Gold;

import java.util.Scanner;

public class Gold2_1701_KMP_retry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int maxLen = 0;

        // 모든 접미사에 대해 LPS 계산해서 최댓값 저장
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(i);               // i번째부터 끝까지 부분 문자열
            maxLen = Math.max(maxLen, getLPSMax(sub));   // 그 부분 문자열의 LPS 중 최대값
        }

        System.out.println(maxLen);  // 결과 출력
    }

    // KMP에서 사용하는 LPS(Longest Prefix which is also Suffix) 배열을 구해서 최대값 반환
    public static int getLPSMax(String s) {
        int[] lps = new int[s.length()];  // LPS 배열
        int len = 0;                      // 이전 접두사의 길이
        int i = 1;                        // 현재 위치
        int max = 0;                      // 최대 LPS 길이

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                // 현재 문자와 이전 접두사 다음 문자가 같다면
                len++;                  // 접두사 길이 증가
                lps[i] = len;           // 현재 위치에 접두사 길이 저장
                max = Math.max(max, len); // 최대값 갱신
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];  // 실패한 만큼 되돌아가기
                } else {
                    lps[i] = 0;          // 일치한 것이 없으면 0
                    i++;
                }
            }
        }

        return max;
    }
}

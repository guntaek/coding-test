import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        solution("KAKAO");
    }

    static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        // 1. 사전 초기화 (A-Z를 1-26번으로)
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }

        int dictIdx = 27; // 다음 사전 색인 번호
        int idx = 0; // 현재 문자열 인덱스

        while (idx < msg.length()) {
            String w = "";
            String c = "";

            // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w 찾기
            int j = idx;
            while (j < msg.length()) {
                String temp = msg.substring(idx, j + 1);
                if (dict.containsKey(temp)) {
                    w = temp;
                    j++;
                } else {
                    c = msg.substring(j, j + 1);
                    break;
                }
            }

            // 3. w에 해당하는 색인 번호 출력
            answer.add(dict.get(w));

            // 4. 입력에서 처리되지 않은 다음 글자가 있다면 w+c를 사전에 등록
            if (!c.isEmpty()) {
                dict.put(w + c, dictIdx++);
            }

            // 5. 입력에서 w 제거
            idx += w.length();
        }

        // List를 배열로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

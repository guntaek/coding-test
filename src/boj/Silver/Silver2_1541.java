package boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Silver2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
                list.add(Character.toString(c));
            }
        }
        list.add(sb.toString());

        int answer = Integer.parseInt(list.get(0));

        boolean flag = false;
        int temp = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals("+")) continue;
            if (list.get(i).equals("-")) {
                if (flag) {
                    answer -= temp;
                    temp = 0;
                }
                flag = true;
            } else {
                if (flag) {
                    temp += Integer.parseInt(list.get(i));
                } else {
                    answer += Integer.parseInt(list.get(i));
                }
            }
        }

        answer -= temp;

        System.out.println(answer);

    }
}

import problem.Baek4779;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Baek4779 baek4779 = new Baek4779();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;  // 빈 줄 방지

            int N = Integer.parseInt(line.trim());
            int strlen = (int) Math.pow(3, N);

            List<String> target = new ArrayList<>();
            for (int i = 0; i < strlen; i++) {
                target.add("-");
            }

            List<String> result = baek4779.solution(target, N, 0);

            // 출력
            StringBuilder sb = new StringBuilder();
            for (String s : result) sb.append(s);
            System.out.println(sb.toString());
        }
    }
}

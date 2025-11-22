import java.io.*;

import static problem.Baek4779.solution;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) { // EOF 처리
            if (line.trim().isEmpty()) continue;

            int N = Integer.parseInt(line.trim());
            int strlen = (int) Math.pow(3, N);

            // 1. StringBuilder로 기본 세팅 (모두 '-'로 채움)
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strlen; i++) {
                sb.append("-");
            }

            // 2. 재귀 함수 호출 (0번 인덱스부터 전체 길이만큼)
            solution(sb, 0, strlen);

            // 3. 결과 출력
            System.out.println(sb.toString());
        }
    }
}

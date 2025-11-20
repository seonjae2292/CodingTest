package problem;

import java.util.ArrayList;
import java.util.List;

// 3^n 공백
public class Baek4779 {
    public List<String> solution(List<String> str, int N, int count) {
        if(N == 0) {
            List<String> st = new ArrayList<>();
            st.add("-");
            return st;
        }

        if (count == 0) {
            for (int i = 0; i < str.size(); i++) {
                if ((i + 1) % 2 == 0) { // 짝수 일 때
                    str.set(i, " ");
                }
            }
        } else {
            // 시작 인덱스 : Math.pow(3, count);
            for (int i = (int) Math.pow(3, count); i < str.size() - 3; i += 3 * (count + 1)) {
                for (int j = i; j < i + (int) Math.pow(3, count); j++) {
                    if (j + (int) Math.pow(3, count) >= str.size()) return str;
                    str.set(j, " ");
                }
            }
        }
        count += 1;

        if (N == count) return str;

        return solution(str, N, count);
    }
}

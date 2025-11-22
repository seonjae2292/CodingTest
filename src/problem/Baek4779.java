package problem;

// 3^n 공백
public class Baek4779 {
    public static void solution(StringBuilder sb, int start, int size) {
        if (size == 1) { // 종료 조건
            return;
        }

        int newSize = size / 3;

        // 가운데 구간을 공백으로 변경
        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        // 왼쪽, 오른쪽 재귀 호출
        solution(sb, start, newSize);
        solution(sb, start + 2 * newSize, newSize);
    }
}

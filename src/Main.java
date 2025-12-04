import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static problem.Baek2667.solution;

public class Main {
    static int[][] map; // 입력 기록
    static boolean[][] visited; // 방문 기록
    static int count; // 집 개수
    static int N;
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 하나씩 순회하면서 인접한 집들 방문
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 집이 있어야 하고 방문한적 없어야한다.
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    solution(i, j, visited, count, N, map);
                    resultList.add(count);
                }
            }
        }

        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (int c : resultList) {
            System.out.println(c);
        }
    }
}

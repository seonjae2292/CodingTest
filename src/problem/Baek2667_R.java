package problem;

import java.util.List;

public class Baek2667_R {
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void solution(
            int x, int y,
            int[][] map, boolean[][] visited,
            List<Integer> resultList, int N) {
        visited[x][y] = true; // 방문 체크
        count++;

        // 상 하 좌 우 연결되어 있는지 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = x + dy[i];

            // 지도 보다 크거나 작으면 안된다.
            if (nx >= 0 && ny >= 0 && nx < N & ny < N) {
                // 집이 있어야 하고 방문한적 없어야한다.
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    solution(nx, ny, map, visited, resultList, N);
                }
            }
        }
    }
}

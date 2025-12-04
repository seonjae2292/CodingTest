package problem;

public class Baek2667 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void solution(int x, int y, boolean[][] visited, int count, int N, int[][] map) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 집의 위치는 N을 벗어나면 안된다
            // 0보다 작으면 안된다
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 집이 있어야한다.
                // 방문한적 없어야한다.
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    solution(nx, ny, visited, count, N, map);
                }
            }
        }
    }
}

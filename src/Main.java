import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 기준 반복
        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken()); // 가로 -> 열의 수
            int N = Integer.parseInt(st.nextToken()); // 세로 -> 행의 수
            int K = Integer.parseInt(st.nextToken()); // 배추 좌표 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }
            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] == 1 && !visited[y][x]) {
                        dfs(x, y, N, M);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int x, int y, int N, int M) {
        visited[y][x] = true;

        // 상 하 좌 우 비교니까 4번 반복
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && ny < N && nx < M) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx, ny, N, M);
                }
            }
        }
    }
}

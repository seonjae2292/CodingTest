import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isCompleted = true;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }

                if (map[i][j] == 0) {
                    isCompleted = false;
                }
            }
        }

        if (isCompleted) {
            System.out.println(0);
            return;
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > result) {
                    result = map[i][j];
                }
            }
        }

        System.out.println(result - 1);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    map[nx][ny] = map[curr[0]][curr[1]] + 1;
                }
            }
        }
    }
}

// M : 상자 가로 칸의 수, N : 상자 세로 칸의 수
// 익은 : 1, 익지 않은 : 0, 없는 : -1
// 출발 지점이 여러개 : map 초기화 할 때 미리 저장해야 한다.

// 출력
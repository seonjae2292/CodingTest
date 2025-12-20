import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static boolean isCompleted = true;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        // 3차원 배열 생성
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    // 시작점으로 사용되는 것들 저장
                    if (map[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }

                    if (map[i][j][k] == 0) {
                        isCompleted = false;
                    }
                }
            }
        }

        if (isCompleted) {
            System.out.println(0);
            return;
        }

        bfs();

        // 0이 남아있는지 탐색
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[i][j][k] > result) {
                        result = map[i][j][k];
                    }
                }
            }
        }

        System.out.println(result - 1);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int j = 0; j < 6; j++) {
                int nz = curr[0] + dz[j];
                int nx = curr[1] + dx[j];
                int ny = curr[2] + dy[j];

                if(nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) continue;

                if (map[nz][nx][ny] == 0) {
                    queue.add(new int[]{nz, nx, ny});
                    map[nz][nx][ny] = map[curr[0]][curr[1]][curr[2]] + 1;
                }
            }
        }
    }
}

// 시작 점이 여러개이다.
// 이동할 수 있는 좌표 구하기
// 기준이 되는 곳의 값에 +1 해야한다.
// 가장 큰 값을 골라야 한다.
// 모두 익어있는 상태
// 모두 익지 못하는 상태
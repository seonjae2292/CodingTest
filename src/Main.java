import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean isCompleted = true;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) isCompleted = false;
                if(map[i][j] == 1) queue.add(new int[]{i, j});
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
                if(map[i][j] > result) {
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
                int tX = curr[0] + dx[i];
                int tY = curr[1] + dy[i];

                if(tX < 0 || tY < 0 || tX >= N || tY >= M) continue;

                if (map[tX][tY] == 0) {
                    queue.add(new int[]{tX, tY});
                    map[tX][tY] = map[curr[0]][curr[1]] + 1;
                }
            }
        }
    }
}
// 모든 토마토들이 다 익는 최소 일수
// 상자의 가로 칸의 수 : M 열
// 상자의 세로 칸의 수 : N 행
// 1 : 익은, 0 : 익지 않은, -1 : 없는
// 0 다수의 시작점 -> 행렬을 저장할 때 1 이면 좌표를 queue에 넣어 놓는다

// 출력
// 0 모두 익어 있으면 0
// 모두 익지 못하는 상황이면 -1
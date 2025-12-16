import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};
    static List<int[]> start = new ArrayList<>();
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
                int target = Integer.parseInt(st.nextToken());
                map[i][j] = target;

                // 시작점으로 사용할 좌표 기록
                if(target == 1 && start.isEmpty()) {
                    start.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > result) {
                    result = map[i][j];
                }
            }
        }
        System.out.println(result);
    }
//
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start.getFirst());

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 이동하는 위치에 존재해야하고 이미 방문했으면 안된다.
                if (map[nx][ny] != -1 && map[nx][ny] != 1) {
                    queue.add(new int[]{nx, ny});
                    map[nx][ny] = map[curr[0]][curr[1]] + 1;
                }
            }
        }
    }
}

// 며칠이 지나면 다 익게 되는지 최소 일수
// 1 : 익은, 0 : 익지 않은, -1 : 없는
// 모두 익은 return 0, 모두 익지 못함 return -1

// 시작점을 어디로 잡아야함? -> 시작점을 저장하는 변수 필요
// 며칠이 걸리는지 어떻게 알 수 있지.
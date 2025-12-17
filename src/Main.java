import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};
    static List<int[]> start = new ArrayList<>();
    static int result = 0;
    static boolean isComplete = true;

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

                if(target == 1) {
                    start.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == -1) continue;
                if(map[i][j] == 0) {
                    isComplete = false;
                    break;
                }
            }
        }

        // 모든 토마토가 익어 있을 경우
        if(isComplete) {
            System.out.println(0);
            return;
        };

        bfs();

        // 토마토가 모두 익지 못하는 상황
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 가장 큰 값 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > result) result = map[i][j];
            }
        }

        System.out.println(result - 1);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] next : start) {
            queue.add(next);
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 아직 익지 않은 토마토여야한다.
                if (map[nx][ny] == 0) {
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

// 시작점이 여러개임
// 동시에 출발해야하나? 만약 동시에 출발해야 한다면 코드로 어떻게 구현하지
// -> 동시 출발은 아닌거 같음
// ->
// 모든 토마토가 익었다는걸 어떻게 확인할 수 있지? 모두 익지 못하는 상황을 어떻게 확인할 수 있지
// -> 이걸 어떻게 코드로 표현하지

// 모든 토마토가 익을 수 없는 환경을 0의 상하좌우가 다 막혀있는 상황
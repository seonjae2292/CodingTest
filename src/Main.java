import java.io.*;
import java.util.*;

public class Main {
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 기록
    static int count;
    static List<Integer> resultList = new ArrayList<>(); // 각 단지별 집의 개수
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 순회
        // 연결되어 있는 집을 찾기 위해
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 집이 있어야 하고 방문한적 없어야 한다.
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;

                    // 지도의 (i, j) 순회하며 집이 있으면 연결되어 있는 집 찾기
                    solution(i, j);
                    resultList.add(count);
                }
            }
        }

        System.out.println(resultList.size());
        Collections.sort(resultList);
        for (int item : resultList) {
            System.out.println(item);
        }
    }

    public static void solution(int x, int y) {
        visited[x][y] = true; // 방문 체크
        count++;

        // 상 하 좌 우 연결되어 있는지 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 보다 크거나 작으면 안된다.
            if (nx >= 0 && ny >= 0 && nx < N & ny < N) {
                // 집이 있어야 하고 방문한적 없어야한다.
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    solution(nx, ny);
                }
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int[][] move = {{-1, 2}, {-2, 1}, { -1, -2}, {-2, -1},
            {1, 2}, {2, 1}, {1, -2}, {2, -1}};
    static int[][] map;
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            map = new int[size][size];

            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int aX = Integer.parseInt(st.nextToken());
            int aY = Integer.parseInt(st.nextToken());

            bfs(X, Y, aX, aY, size);
        }

        for (int num : resultList) {
            System.out.println(num);
        }
    }

    public static void bfs(int X, int Y, int aX, int aY, int size) {
        if(X == aX && Y == aY) {
            resultList.add(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X, Y});

        // 첫 방문 체크
        map[X][Y] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];

            // 나이트가 이돌할 수 있는 좌표 모두 순회
            for (int i = 0; i < 8; i++) {
                int[] d = move[i];

                int dX = cX + d[0];
                int dY = cY + d[1];

                // 범위 유효성 검사
                if (dX < 0 || dY < 0 || dX >= size || dY >= size) continue;

                if (map[dX][dY] == 0) {
                    map[dX][dY] = map[cX][cY] + 1;
                    queue.add(new int[]{dX, dY});

                    if (aX == dX && aY == dY) {
                        resultList.add(map[aX][aY] - 1);
                    }
                }
            }
        }
    }
}


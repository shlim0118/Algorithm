import java.io.*;
import java.util.*;

public class Main {

    private static int[][] farm;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean isFull = true;
    private static Queue<int[]> q = new LinkedList<>();
    private static int m, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        farm = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
                if (farm[i][j] == 0) {
                    isFull = false;
                }
                if (farm[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        if (isFull) {
            System.out.println(0);
            return;
        }
        int result = bfs();
        System.out.println(result);

    }

    private static int bfs() {
        int count = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (!visited[nx][ny] && farm[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            farm[nx][ny] = 1;
                        }
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (farm[i][j] == 0) {
                    return -1;
                }
            }
        }
        return count;
    }

}

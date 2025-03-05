import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 나무의 수
        M = Integer.parseInt(st.nextToken());   // 나무의 길이

        tree = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) max = tree[i];
        }

        int left = 0;
        int right = max;
        long height = 0;     // 절단기의 높이

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            // 잘린 나무길이를 계산
            for (int t : tree) {
                if (t > mid) sum += t - mid;
            }
            if (sum >= M) {
                height = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(height);
    }

}

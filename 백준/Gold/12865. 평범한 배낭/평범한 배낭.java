import java.io.*;
import java.util.*;

public class Main {

    private static int n, capacity;
    private static int[] dp, weight, value;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        capacity = Integer.parseInt(st.nextToken());
        weight = new int[n + 1];
        value = new int[n + 1];
        dp = new int[capacity + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j - weight[i] >= 0; j--) {
                // j값을 내림차순으로 하여 이전 dp[i]의 값이 포합되지 않도록
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[capacity]);
    }


}

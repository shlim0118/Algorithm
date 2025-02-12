import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] wine, dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        wine = new int[n+1];
        dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = wine[1];
        
        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = wine[1] + wine[2];
        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[n]);

    }

}




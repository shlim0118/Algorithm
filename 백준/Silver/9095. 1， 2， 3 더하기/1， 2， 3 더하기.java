import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int k = 4; k <= n; k++) {
                dp[k] = dp[k - 1] + dp[k - 2] + dp[k - 3];
            }
            System.out.println(dp[n]);
        }
    }

}

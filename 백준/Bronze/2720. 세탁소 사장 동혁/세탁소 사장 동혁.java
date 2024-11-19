import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  = Integer.parseInt(st.nextToken());
        int[] divisor = {25, 10, 5, 1};     // 쿼터, 다임, 니켈, 페니


        while (T > 0) {
            int fee = Integer.parseInt(br.readLine());    // 요금
            int[] change = {0, 0, 0, 0};                  // 잔돈

            for (int i = 0; i < change.length; i++) {
                change[i] = (fee / divisor[i]) ;          // 가장 높은 단위부터 요금에 대한 몫을 구함
                fee = fee % divisor[i];                   // 계산 후 나머지를 요금에 저장.
            }

            for (int k : change) {
                System.out.print(k + " ");
            }

            System.out.println();
            T--;
        }

    }


}
/*

 */
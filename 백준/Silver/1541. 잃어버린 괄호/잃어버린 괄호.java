import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /** '-' 뒤에 있는 숫자가 클수록 식의 값은 최소가 된다.
         * 1. 입력받은 문자열을 '-'를 구분자로 하여 나눈다.
         * 2. '-'로 나눈 문자열을 '+'를 구분자로 나눈 후 더한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;

        while (minus.hasMoreTokens()) {         // '-' 구분자로 입력받은 문자열을 나눈다.
            int tmp = 0;
            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

            while (plus.hasMoreTokens()) {      // '+' 구분자로 입력받은 문자열을 나눈 후 각 수들을 더한다.
                int result = Integer.parseInt(plus.nextToken());
                tmp += result;
//                System.out.println("result = " + result);
            }
            if (sum == Integer.MAX_VALUE) {     // 식의 첫번째 수인지 체크
                sum = tmp;
            } else {                            // 아니라면 합계에서 '+' 구분자로 나누고 더한 값을 빼 준다.
                sum -= tmp;
            }
        }
        System.out.println(sum);

    }

}

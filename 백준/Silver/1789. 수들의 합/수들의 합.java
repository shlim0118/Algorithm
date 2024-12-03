

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        int number = 1;

        while (true) {
            if (S >= number) {
                S -= number;
                number++;
            } else {
                break;
            }

        }
        System.out.println(number - 1);

    }

}

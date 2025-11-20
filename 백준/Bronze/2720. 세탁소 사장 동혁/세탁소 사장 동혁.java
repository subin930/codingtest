import java.util.*;
import java.io.*;

/*
    Quarter: 0.25달러 -> 25센트
    Dime: 0.1 -> 10센트
    Nickel: 0.05 -> 5센트
    Penny: 0.01 -> 1센트
    1달러 = 100센트
 */
public class Main {
    public static int[] money = {25, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; ++i) {
            int cur = Integer.parseInt(br.readLine());

            for(int j = 0; j < money.length; ++j) {
                if(cur <= 0) {
                    sb.append("0 ");
                    continue;
                }

                int answer = cur / money[j];

                cur -= (money[j] * answer);

                sb.append(answer);
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

import java.util.*;
import java.io.*;

/*
    A: 5분 -> 60*5 = 300초
    B: 1분 -> 60초
    C: 10초 -> 10초
 */
public class Main {
    public static int[] buttons = {300, 60, 10};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < buttons.length; ++i) {
            if(T <= 0) {
                sb.append("0 ");
                continue;
            }

            int answer = T / buttons[i];
            T -= answer * buttons[i];

            sb.append(answer);
            sb.append(" ");
        }

        if(T > 0) bw.write("-1");
        else bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

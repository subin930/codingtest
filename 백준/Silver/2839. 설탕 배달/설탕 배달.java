import java.util.*;
import java.io.*;

/*
    3kg, 5kg -> 3kg 개수가 최소가 되어야 함
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        while(N >= 0) {
            if(N % 5 == 0) {
                answer += (N / 5);
                break;
            }

            answer ++;
            N -= 3;
        }

        if(N < 0) bw.write("-1");
        else bw.write(String.valueOf(answer));

        bw.flush();
        br.close();
        bw.close();
    }
}

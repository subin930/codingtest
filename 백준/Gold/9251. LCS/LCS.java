import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String text1 = br.readLine();
        String text2 = br.readLine();

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i = 1; i < text1.length() + 1; ++i) {
            for(int j = 1; j < text2.length() + 1; ++j) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        bw.write(dp[text1.length()][text2.length()] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

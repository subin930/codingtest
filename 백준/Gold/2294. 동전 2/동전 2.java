import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]); //동전 종류
        int k = Integer.parseInt(arr[1]); //목표 가치


        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; ++i) set.add(Integer.parseInt(br.readLine()));

        ArrayList<Integer> l = new ArrayList<>(set);
        l.sort(Collections.reverseOrder()); //내림차순

        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);
        dp[k] = 0;

        for(int i = 0; i < l.size(); ++i) {
            for(int j = k; j > 0; --j) {
                if(dp[j] > -1) {
                    int idx = j - l.get(i);
                    int val = dp[j] + 1;

                    if(idx >= 0 && (dp[idx] == -1 || dp[idx] > val)) dp[idx] = val;
                }
            }
        }

//        for(int i = 0; i <= k; ++i) System.out.printf(dp[i] +" ");
//        System.out.println();

        bw.write(dp[0] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

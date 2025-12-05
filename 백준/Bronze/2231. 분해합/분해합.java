import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean flag = false;
        int result = 0;

        for(int i = N / 2; i < N; ++i) {
            flag = check(i, N);

            if(flag){
                result = i;
                break;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check(int n, int N) {
        int sum = n;

        for(char c : String.valueOf(n).toCharArray()) {
            sum += (c - '0');
        }

        return sum == N;
    }
}

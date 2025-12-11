import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N; //세로
    public static int M; //가로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        int[][] arr = new int[N][M];
        ArrayList<int[]> empty = new ArrayList<>();

        for(int i = 0; i < N; ++i) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j) {
                int num = Integer.parseInt(str2.nextToken());
                arr[i][j] = num;

                if(num == 0) {
                    empty.add(new int[] {i, j});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        //빈 배열 탐색
        for(int i = 0; i < empty.size() - 2; ++i) {
            int[] a = empty.get(i);
            for(int j = i + 1; j < empty.size() - 1; ++j) {
                int[] b = empty.get(j);
                for(int k = j + 1; k < empty.size(); ++k) {
                    int[] c = empty.get(k);

                    int[][] newArr = new int[N][M];
                    arrCopy(arr, newArr);

                    newArr[a[0]][a[1]] = 1;
                    newArr[b[0]][b[1]] = 1;
                    newArr[c[0]][c[1]] = 1;

                    int cnt = searchEmpty(newArr);

                    if(cnt > max) max = cnt;

//                    printArr(newArr);
                }
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
    static void printArr(int[][] arr) {
        for(int i = 0; i < N;++i) {
            for(int j = 0; j < M;++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void arrCopy(int[][] arr, int[][] newArr) {
        for(int i = 0; i < N; ++i) {
            newArr[i] = Arrays.copyOf(arr[i], M);
        }
    }
    static int searchEmpty(int[][] arr) {
        //바이러스 퍼트리기
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                if(arr[i][j] == 2) virus(arr, i, j);
            }
        }

        //count
        int cnt = 0;
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                if(arr[i][j] == 0) ++cnt;
            }
        }

        return cnt;
    }

    static void virus(int[][] arr, int i, int j) {
        if(i > N - 1 || j > M - 1 || i < 0 || j < 0) return;
        else if(arr[i][j] != 2) return;

        //상
        if(i > 0 && arr[i - 1][j] == 0) {
            arr[i - 1][j] = 2;
            virus(arr, i - 1, j);
        }

        //하
        if(i < N - 1 && arr[i + 1][j] == 0) {
            arr[i + 1][j] = 2;
            virus(arr, i + 1, j);
        }

        //좌
        if(j > 0 && arr[i][j - 1] == 0) {
            arr[i][j - 1] = 2;
            virus(arr, i, j - 1);
        }

        //우
        if(j < M - 1 && arr[i][j + 1] == 0) {
            arr[i][j + 1] = 2;
            virus(arr, i, j + 1);
        }
    }
}

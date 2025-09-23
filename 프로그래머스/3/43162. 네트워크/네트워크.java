class Solution { 
    public void checkBlock(int[][] check, int[][] computers, int n, int i) {
        for(int j = 0; j < n; ++j) {
            if(i == j) {
                check[i][j] = 1; continue;
            }
            
            if(check[i][j] == 0 && computers[i][j] == 1) {
                check[i][j] = 1;
                check[j][i] = 1;
                System.out.println(j);
                checkBlock(check, computers, n, j);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int[][] check = new int[n][n];
        int answer = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(check[i][j] == 0 && computers[j][i] == 1) {
                    check[i][j] = 1;
                    check[j][i] = 1;
                    System.out.printf("i: %d, j: %d \n", i, j);
                    checkBlock(check, computers, n, j);
                    ++answer;
                }
            }
        }
        return answer;
    }
}
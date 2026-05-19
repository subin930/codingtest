class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int[] periods = new int[signals.length];
        // 주기 최소 공배수
        int lcm = 1;
        for(int i = 0; i < signals.length; ++i) {
            int T = signals[i][0] + signals[i][1] + signals[i][2]; // 주기
            periods[i] = T;
            
            int g = gcd(lcm, T);    // 최대 공약수 
            
            lcm = lcm * T / g;
        }
        
        for(int i = 0; i < lcm; ++i) {
            boolean check = true;
            
            for(int j = 0; j < signals.length; ++j) {
                int r = i % periods[j];     // 위치 확인
                
                if(r < signals[j][0] || r >= signals[j][0] + signals[j][1]) {
                    check = false;
                    break;
                }
            }
            
            
            if(check == true) {
                return i + 1;
            }
        }
        
        return answer;
    }
    
    int gcd(int a, int b) {
        if(b > a) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        int r = a % b;
        
        if(r == 0) return b;
        
        return gcd(b, r);
    }
}
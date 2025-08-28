import java.util.*;

class Solution {
    int answer = 0;
    
    public void dfs(int curTotal, int[] numbers, int index, int target) {
        if(index >= numbers.length) {
            if(curTotal == target) {
                answer += 1;
            }
            return;
        }
            
        
        dfs(curTotal - numbers[index], numbers, index + 1, target);
        dfs(curTotal + numbers[index], numbers, index + 1, target);
    }
    public int solution(int[] numbers, int target) {      
        dfs(0, numbers, 0, target);
        
        return answer;
    }
}
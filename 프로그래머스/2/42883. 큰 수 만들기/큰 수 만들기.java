import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuffer answer = new StringBuffer();
        Deque<Character> q = new ArrayDeque<>();
        
        for(char c : number.toCharArray()) {
            while(k > 0 && !q.isEmpty() && q.peekLast() < c) {
                --k;
                q.pollLast();
            }
            q.addLast(c);            
        }
        
        while(k > 0) {
            q.pollLast();
            --k;
        }
        
        q.stream().forEach(x -> answer.append(x));
        
        return answer.toString();
    }
}
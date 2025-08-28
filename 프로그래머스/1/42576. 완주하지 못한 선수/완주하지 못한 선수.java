import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>(participant.length * 2);
        
        for(String p : participant) {
            map.merge(p, 1, Integer::sum); //기존값 + 1, 없으면 1 저장
        }
        
        for(String c: completion) {
            int left = map.merge(c, -1, Integer::sum);
            if(left == 0) {
                map.remove(c);
            }
        }
        
        return map.keySet().iterator().next();
    }
}

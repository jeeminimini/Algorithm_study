import java.util.Arrays;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dLast = n - 1;
        int pLast = n - 1;
        
        dLast = updateIndex(dLast, deliveries);
        pLast = updateIndex(pLast, pickups);
        
        int nowD = cap;
        int nowP = cap;
        
        while (dLast >= 0 || pLast >= 0) {
            answer += (Math.max(dLast, pLast) + 1) * 2;
            for(int i = dLast; i >= 0; i--) {
                if (deliveries[i] > 0) {
                    if (deliveries[i] <= nowD) {
                        nowD -= deliveries[i];
                        deliveries[i] = 0;
                        dLast = i - 1;
                    } else {
                        deliveries[i] -= nowD;
                        nowD = 0;
                        dLast = i;
                    }
                }
                if (nowD == 0) {
                    break;
                }
            }
            
            if (nowD != 0) {
                dLast = -1;
            } 
            
            //System.out.println(Arrays.toString(deliveries) + nowD + dLast);
            
            
            for(int i = pLast; i >= 0; i--) {
                if (pickups[i] > 0) {
                    if (pickups[i] <= nowP) {
                        nowP -= pickups[i];
                        pickups[i] = 0;
                        pLast = i - 1;
                    } else {
                        pickups[i] -= nowP;
                        nowP = 0;
                        pLast = i;
                    }
                }
                if (nowP == 0) {  
                    break;
                }
            }
            
            if (nowP != 0) {
                pLast = -1;
            } 
            
           // System.out.println(answer);
                
            nowD = cap;
            nowP = cap;
            
            dLast = updateIndex(dLast, deliveries);
            pLast = updateIndex(pLast, pickups);
        }
        return answer;
    }
    
    public int updateIndex(int last, int[] items) {
        boolean isOver = true;
        
        for(int i = last; i >= 0; i--) {
            if (items[i] != 0) {
                last = i;
                isOver = false;
                break;
            }   
        }
        
        if (isOver) {
            return -1;
        } else {
            return last;
        }
    }
}
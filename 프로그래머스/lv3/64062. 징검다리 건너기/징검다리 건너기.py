from collections import deque
import heapq

def solution(stones, k):
    q = []
    
    for i in range(0, k - 1):
        heapq.heappush(q, [-stones[i], i])
    
    mini = 200000001
    for i in range(k - 1, len(stones)):
        heapq.heappush(q, [-stones[i], i])
        while q and q[0][1] < i - (k - 1):
            heapq.heappop(q)
        mini = min(mini, -q[0][0])
        
    return mini
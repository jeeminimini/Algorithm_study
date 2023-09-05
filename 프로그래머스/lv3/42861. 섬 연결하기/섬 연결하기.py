from heapq import heappop, heappush

def setParent(old, new, parents):
    for i in range(len(parents)):
        if parents[i] == old:
            parents[i] = new

def changeParent(a, b, parents):
    if parents[a] < parents[b]:
        # parents[parents[b]] = parents[a]
        setParent(parents[b], parents[a], parents)
    else:
        # parents[a] = parents[b]
        setParent(parents[a], parents[b], parents)
    
    
def solution(n, costs):
    answer = 0
    parents = [i for i in range(n)]
    pq = []
    for c in costs:
        heappush(pq, (c[2], c[0], c[1]))
    
    total = 0
    while pq:
        now = heappop(pq)
        # print(f"now {now} parents {parents} total {total}")
        if parents[now[1]] != parents[now[2]]:
            changeParent(now[1], now[2], parents)
            # print(f"after parents {parents}")
            total += now[0]
        
        if set(parents) == 1:
            break
            
    
    return total 


    
    
    
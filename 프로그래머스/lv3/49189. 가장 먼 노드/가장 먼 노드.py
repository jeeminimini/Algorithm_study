from collections import deque

def solution(n, edge):
    graphs = dict()
    for a, b in edge:
        if a in graphs.keys():
            graphs[a].append(b)
        else:
            graphs[a] = [b]
            
        if b in graphs.keys():
            graphs[b].append(a)
        else:
            graphs[b] = [a]
    
    queue = deque([1])
    visited = [0 for _ in range(n + 1)]
    visited[1] = 1
    num = 1
    while queue:
        now = queue.popleft()
        for m in graphs[now]:
            if visited[m] == 0:
                visited[m] = visited[now] + 1
                queue.append(m)
        
    result = visited.count(max(visited))
    return result
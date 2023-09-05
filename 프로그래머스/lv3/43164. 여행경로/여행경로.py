result = []
def dfs(now, tickets, visited, paths):
    global result
    if all(visited):
        result.append(paths + [now])
        return
    
    for i in range(len(tickets)):
        if not visited[i] and tickets[i][0] == now:
            paths.append(tickets[i][0])
            visited[i] = 1
            dfs(tickets[i][1], tickets, visited, paths[:])
            del paths[-1]
            visited[i] = 0
    

def solution(tickets):
    global result
    dfs("ICN", tickets, [0 for _ in range(len(tickets))], [])
    return sorted(result)[0]
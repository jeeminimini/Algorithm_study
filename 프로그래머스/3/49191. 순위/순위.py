def solution(n, results):
    players = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    for i in range(len(results)):
        a, b = results[i]
        players[a][b] = 1
        players[b][a] = -1
        
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if i != j and players[i][j] == 0:
                    if players[i][k] * players[k][j] > 0:
                        players[i][j] = players[i][k]

    result = 0
    for i in range(1, n + 1):
        num = 0
        for j in range(1, n + 1):
            if players[i][j] == 0:
                num += 1
        if num == 1:
            result += 1

    
    return result
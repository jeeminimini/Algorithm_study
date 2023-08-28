def solution(m, n, puddles):
    ground = [[0 for _ in range(m)] for _ in range(n)]
    dx = [-1, 0]
    dy = [0, -1]
    ground[0][0] = 1
    
    for i in range(n):
        for j in range(m):
            if (i == 0 and j == 0) or[j + 1, i + 1] in puddles:
                continue
            num = 0
            for k in range(2):
                if 0 <= i + dx[k] < n and 0 <= j + dy[k] < m and [j + dy[k] + 1, i + dx[k] + 1] not in puddles:
                    num += ground[i + dx[k]][j + dy[k]]
            ground[i][j] = num
            
            # print(f"i {i} j {j}")
            # for t in range(n):
            #     print(ground[t])
    return (ground[n - 1][m - 1]) % 1000000007
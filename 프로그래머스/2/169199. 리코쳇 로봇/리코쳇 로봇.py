from collections import deque

def solution(board):
    n, m = len(board), len(board[0])
    start = []
    end = []
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                start = [i, j]
            elif board[i][j] == 'G':
                end = [i, j]
                
    queue = deque([])
    queue.append(start)
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    visited = [[[999999, -1] for _ in range(m)] for _ in range(n)]
    visited[start[0]][start[1]] = [1, -1]
    
    while queue:
        x, y = queue.popleft()
        
        if [x, y] == end:
            break
        
        for i in range(4):
            nx, ny = x, y
            while 0 <= nx + dx[i] < n and 0 <= ny + dy[i] < m:
                if board[nx + dx[i]][ny + dy[i]] == 'D':
                    break
                
                nx, ny = nx + dx[i], ny + dy[i]
                    
            if [nx, ny] != [x, y] and visited[nx][ny][0] > visited[x][y][0] + 1:
                queue.append([nx, ny])
                visited[nx][ny] = [visited[x][y][0] + 1, i]
        
    if visited[end[0]][end[1]][0] == 999999:
        return -1
    else:
        return visited[end[0]][end[1]][0] - 1
    
#     visited[nx][ny][1] != i and 
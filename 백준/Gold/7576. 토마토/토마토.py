import sys
from collections import deque

m, n = map(int, sys.stdin.readline().split())
tomato = []
visited = [[0 for _ in range(m)] for _ in range(n)]

for i in range(n):
    tomato.append(list(map(int, sys.stdin.readline().split())))

queue = deque([])
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1:
            queue.append([i, j])

while queue:
    nx, ny = queue.popleft()

    for i in range(4):
        if 0 <= nx + dx[i] < n and 0 <= ny + dy[i] < m:
            if tomato[nx + dx[i]][ny + dy[i]] == 0:
                queue.append([nx + dx[i], ny + dy[i]])
                tomato[nx + dx[i]][ny + dy[i]] = tomato[nx][ny] + 1

result = 0
for i in range(n):
    for j in range(m):
        if tomato[i][j] == 0:
            print("-1")
            sys.exit()
        else:
            result = max(result, tomato[i][j])

print(result - 1)
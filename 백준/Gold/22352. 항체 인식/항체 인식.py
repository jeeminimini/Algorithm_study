import sys
from collections import deque


n, m = map(int, sys.stdin.readline().split())
before = []
after = []
visited = [[False for _ in range(m)] for _ in range(n)]

for i in range(n):
    before.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    after.append(list(map(int, sys.stdin.readline().split())))


def bfs(x, y):
    queue = deque([[x, y]])
    data = before[x][y]
    update = after[x][y]
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    possible = 0

    if data != update:
        possible = 1

    while queue:
        nx, ny = queue.popleft()
        visited[nx][ny] = True
        if after[nx][ny] != update:
            possible = -1

        for i in range(4):
            if 0 <= nx + dx[i] < n and 0 <= ny + dy[i] < m:
                if not visited[nx + dx[i]][ny + dy[i]] and before[nx + dx[i]][ny + dy[i]] == data:
                    queue.append([nx + dx[i], ny + dy[i]])

    return possible


result = 0
for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            possible = bfs(i, j)
            if possible == -1:
                print("NO")
                sys.exit()
            else:
                result += bfs(i, j)

if result <= 1 :
    print("YES")
else:
    print("NO")
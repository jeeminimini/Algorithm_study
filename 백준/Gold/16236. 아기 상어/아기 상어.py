from collections import deque


def bfs(x, y):
    global n, result, baby_size, eaten_fish
    queue = deque()
    queue.append([x, y])
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    visited = [[0 for _ in range(n)] for _ in range(n)]
    eatable = []
    while queue:
        now_x, now_y = queue.popleft()
        # print("now", now_x, now_y)
        for i in range(4):
            if 0 <= now_x + dx[i] < n and 0 <= now_y + dy[i] < n:
                if baby_size >= oceans[now_x + dx[i]][now_y + dy[i]] and visited[now_x + dx[i]][now_y + dy[i]] == 0:
                    visited[now_x + dx[i]][now_y + dy[i]] = visited[now_x][now_y] + 1
                    if baby_size > oceans[now_x + dx[i]][now_y + dy[i]] > 0:
                        eatable.append([now_x + dx[i], now_y + dy[i], visited[now_x + dx[i]][now_y + dy[i]]])
                    else:
                        queue.append([now_x + dx[i], now_y + dy[i]])
    if not eatable:
        return -1, -1
    eatable.sort(key=lambda x: (x[2], x[0], x[1]))
    # print("eatable", eatable)
    oceans[eatable[0][0]][eatable[0][1]] = 0
    result += eatable[0][2]
    eaten_fish += 1
    if eaten_fish == baby_size:
        baby_size += 1
        eaten_fish = 0
    return eatable[0][0], eatable[0][1]


n = int(input())
oceans = []
for i in range(n):
    oceans.append(list(map(int, input().split())))

result = 0
baby = []
baby_size = 2
eaten_fish = 0
for i in range(n):
    for j in range(n):
        if oceans[i][j] == 9:
            baby = [i, j]
            oceans[i][j] = 0

while True:
    x, y = bfs(baby[0], baby[1])
    if x == -1 and y == -1:
        break
    # print(x, y)
    baby[0], baby[1] = x, y
print(result)
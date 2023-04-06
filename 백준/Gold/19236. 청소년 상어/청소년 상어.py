import copy
fishes = []
for i in range(4):
    f = list(map(int, input().split()))
    fish = []
    for j in range(4):
        # 번호, 방향
        fish.append([f[2 * j], f[2 * j + 1] - 1])
    fishes.append(fish)
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]


def dfs(s_x, s_y, num, fishes):
    global result
    # 물고기 먹기
    num += fishes[s_x][s_y][0]
    result = max(num, result)
    fishes[s_x][s_y][0] = 0
    
    # 물고기 이동
    for i in range(1, 17):
        f_x, f_y = -1, -1
        for x in range(4):
            for y in range(4):
                if fishes[x][y][0] == i:
                    f_x, f_y = x, y
                    break
        if f_x == -1 and f_y == -1:
            continue

        f_d = fishes[f_x][f_y][1]

        for j in range(8):
            nd = (f_d + j) % 8
            nx = f_x + dx[nd]
            ny = f_y + dy[nd]

            if not (0 <= nx < 4 and 0 <= ny < 4) or nx == s_x and ny == s_y:
                continue

            fishes[f_x][f_y][1] = nd
            fishes[f_x][f_y], fishes[nx][ny] = fishes[nx][ny], fishes[f_x][f_y]
            break

    # 상어 이동
    s_d = fishes[s_x][s_y][1]
    for i in range(1, 4):
        nx = s_x + dx[s_d] * i
        ny = s_y + dy[s_d] * i
        if 0 <= nx < 4 and 0 <= ny < 4 and fishes[nx][ny][0] > 0:
            dfs(nx,ny, num, copy.deepcopy(fishes))


result = 0
dfs(0, 0, 0, fishes)
print(result)

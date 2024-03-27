import sys

n, m, r = map(int, sys.stdin.readline().split())
games = []
origin = []
strikers = []
defenders = []
directions = {'E':0, 'W':1, 'S':2, 'N':3}

for i in range(n):
    games.append(list(map(int, sys.stdin.readline().split())))
    origin.append(games[-1][:])

result = 0
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
for i in range(r):
    sx, sy, sd = map(lambda x: directions[x] if(x.isalpha()) else int(x) - 1, sys.stdin.readline().split())
    fx, fy = map(lambda x: int(x) - 1, sys.stdin.readline().split())

    num = games[sx][sy] - 1
    games[sx][sy] = 0
    result += 1
    while num > 0:
        sx += dx[sd]
        sy += dy[sd]

        if 0 <= sx < n and 0 <= sy < m:
            num = max(num, games[sx][sy])
            num -= 1
            if games[sx][sy] != 0:
                result += 1
            games[sx][sy] = 0
        else:
            break

    games[fx][fy] = origin[fx][fy]

print(result)
for i in range(n):
    for j in range(m):
        if games[i][j] > 0:
            print("S", end=" ")
        else:
            print("F", end=" ")
    print()


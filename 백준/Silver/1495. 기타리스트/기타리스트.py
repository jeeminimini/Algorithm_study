
n, s, m = map(int, input().split())
v = list(map(int, input().split()))
dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
dp[0][s] = 1
for i in range(0, n):
    for j in range(m + 1):
        if dp[i][j] == 1:
            plus = j + v[i]
            minus = j - v[i]
            if 0 <= plus <= m:
                dp[i + 1][plus] = 1
            if 0 <= minus <= m:
                dp[i + 1][minus] = 1

maxi = -1
for i in range(m + 1):
    if dp[-1][i] == 1:
        maxi = i
print(maxi)
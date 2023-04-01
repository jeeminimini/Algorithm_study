n = int(input())
advices = [[0, 0]]
for i in range(n):
    advices.append(list(map(int, input().split(" "))))
dp = [[0 for i in range(n + 2)] for j in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 2):
        if j >= i + advices[i][0]:
            if dp[i - 1][j] >= dp[i - 1][i] + advices[i][1]:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = dp[i - 1][i] + advices[i][1]
        else:
            dp[i][j] = dp[i - 1][j]

print(dp[n][n + 1])

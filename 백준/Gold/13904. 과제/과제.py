n = int(input())
assignments = [[0, 0]]
for i in range(n):
    assignments.append(list(map(int, input().split())))
assignments = sorted(assignments, key = lambda  x:x[0])
dp = [[0 for _ in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if j <= assignments[i][0]:
            if dp[i - 1][j - 1] + assignments[i][1] > dp[i - 1][j]:
                dp[i][j] = dp[i - 1][j - 1] + assignments[i][1]
            else:
                dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = dp[i - 1][j]

max_value = 0
for d in dp:
    max_value = max(max(d), max_value)
print(max_value)
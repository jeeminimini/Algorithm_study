import sys

t = int(sys.stdin.readline())

for i in range(t):
    w = sys.stdin.readline()
    k = int(sys.stdin.readline())

    alphabet = [[] for _ in range(26)]

    for i in range(len(w) - 1):
        alphabet[ord(w[i]) - ord('a')].append(i)

    mini = 10_001
    maxi = -1

    for i in range(26):
        if len(alphabet[i]) >= k:
            for j in range(0, len(alphabet[i]) - k + 1):
                mini = min(mini, alphabet[i][j + k - 1] - alphabet[i][j] + 1)
                maxi = max(maxi, alphabet[i][j + k - 1] - alphabet[i][j] + 1)

    if maxi == -1:
        print(-1)
    else:
        print(mini, maxi)


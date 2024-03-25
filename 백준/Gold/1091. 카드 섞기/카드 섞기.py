import sys

n = int(sys.stdin.readline())
P = list(map(int, sys.stdin.readline().split()))
S = list(map(int, sys.stdin.readline().split()))
card = [i for i in range(n)]
# history = []
player = [0, 1, 2]

tmp = 0
for i in range(n):
    if P[i] == player[i % 3]:
        tmp += 1
    else:
        break

if tmp == n:
    print("0")
    sys.exit()

count = 1
while count < 200_000:
    new_card = [0 for _ in range(n)]
    for i in range(n):
        new_card[S[i]] = card[i]

    tmp = 0
    for i in range(n):
        if P[new_card[i]] == player[i % 3]:
            tmp += 1
        else:
            break

    if tmp == n:
        break

    card = new_card
    count += 1

if count == 200_000:
    print(-1)
else:
    print(count)
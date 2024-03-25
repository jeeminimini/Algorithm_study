import sys

n = int(sys.stdin.readline())
P = list(map(int, sys.stdin.readline().split()))
S = list(map(int, sys.stdin.readline().split()))
card = [i for i in range(n)]
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

origin = [i for i in range(n)]
count = 1
while True:
    new_card = [0 for _ in range(n)]
    for i in range(n):
        new_card[S[i]] = card[i]

    if new_card == origin:
        print(-1)
        sys.exit()

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

print(count)
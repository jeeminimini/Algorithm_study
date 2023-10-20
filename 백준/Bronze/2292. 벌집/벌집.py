import sys
n = int(sys.stdin.readline())

k = 1
cnt = 1
while n > k:
    k = k + cnt * 6
    cnt += 1

print(cnt)
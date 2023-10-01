'''
0-1 너비 우선 탐색이라는 알고리즘 분류를 보고 풀었다. 한 눈에 보고 0-1 인지 몰랐음

처음에는 * + - 순으로 했는데,
질문 게시판을 보고 * - + 이 우선 순위라는 것을 깨달았다!

'''

import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
dots = [0 for _ in range(100001)]
visited = [0 for _ in range(100001)]

queue = deque([n])
visited[n] = 1

while queue:
    now = queue.popleft()
    if now == k:
        break

    if 0 <= now * 2 <= 100000 and not visited[now * 2]:
        queue.appendleft(now * 2)
        visited[now * 2] = 1
        dots[now * 2] = dots[now]

    if 0 <= now - 1 <= 100000 and not visited[now - 1]:
        queue.append(now - 1)
        visited[now - 1] = 1
        dots[now - 1] = dots[now] + 1

    if 0 <= now + 1 <= 100000 and not visited[now + 1]:
        queue.append(now + 1)
        visited[now + 1] = 1
        dots[now + 1] = dots[now] + 1

print(dots[k])

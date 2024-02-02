import sys
import heapq

input = sys.stdin.readline
N = int(input())
lessons = [list(map(int, input().split())) for _ in range(N)]

# '수업 시작 시간' 기준으로 오름차순 정렬
lessons = sorted(lessons, key=lambda x: x[0])

q = []
for lesson in lessons:
    # 이전 수업이 끝나는 시간과 다음 수업이 시작하는 시간을 비교
    if q and q[0] <= lesson[0]:
        heapq.heappop(q)
    heapq.heappush(q, lesson[1])

# 큐의 각각 원소는 한 강의실에서 하나의 수업이 진행중이라고 생각하면 쉽다.
# 즉, 큐의 사이즈가 강의실의 개수가 된다.
print(len(q))
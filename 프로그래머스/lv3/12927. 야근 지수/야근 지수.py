import heapq
def solution(n, works):
    if n >= sum(works):
        return 0
    works = list(map(lambda x: x * -1, works))
    heapq.heapify(works)
    answer = 0
    for i in range(n):
        work = heapq.heappop(works)
        heapq.heappush(works, work + 1)
        
    for i in works:
        answer += i * i
    return answer
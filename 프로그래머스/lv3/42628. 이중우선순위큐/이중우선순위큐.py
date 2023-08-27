import heapq
def solution(operations):
    pq = []
    for operation in operations:
        command, num = map(lambda x: x if x.isalpha() else int(x), operation.split())
        if command == 'I':
            heapq.heappush(pq, num)
        elif command == 'D':
            if num == -1 and pq:
                heapq.heappop(pq)
            elif num == 1 and pq:
                pq_max = list(map(lambda x: x * -1, pq))
                heapq.heapify(pq_max)
                heapq.heappop(pq_max)
                pq.clear()
                pq = list(map(lambda x: x * -1, pq_max))
                heapq.heapify(pq)
        
    result = [0, 0]
    if len(pq) == 1:
        mini = heapq.heappop(pq)
        result = [mini, mini]
    elif len(pq) > 1:
        mini = heapq.heappop(pq)
        maxi = max(pq)
        result = [maxi, mini]
    return result
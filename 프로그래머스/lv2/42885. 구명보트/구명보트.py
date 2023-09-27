from collections import deque
def solution(people, limit):
    queue = deque(sorted(people))
    answer = 0
    while len(queue) >= 2:
        now = queue.popleft()
        big = queue.pop()
        if now + big > limit:
            queue.appendleft(now)
        answer += 1
        # print(f"now {now} big {big} answer {answer} {queue}")
            
    return answer + len(queue)
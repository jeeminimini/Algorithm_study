def canJump(n, k, stones):
    num = 0
    maxi = 0
    for s in stones:
        if s <= n:
            num += 1
        else:
            num = 0
        if num == k:
            return False
    return True

def solution(stones, k):
    stones_length = len(stones)
    start = 0
    end = max(stones)
    
    while start <= end:
        mid = (start + end) // 2
        if canJump(mid, k, stones):
            start = mid + 1
        else:
            end = mid - 1
    
    return start
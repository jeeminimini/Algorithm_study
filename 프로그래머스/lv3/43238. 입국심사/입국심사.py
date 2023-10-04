import sys
def solution(n, times):
    answer = sys.maxsize

    front = 1
    last = 1_000_000_000 * 1_000_000_000
    
    while front <= last:
        mid = (front + last) // 2
        num = 0
        for t in times:
            num += mid // t
            # print(f"num {num} {mid // t} {mid, t} {front, last}")
        # if num == n:
        #     answer = mid
        #     break
        if num < n:
            front = mid + 1
        else:
            last = mid - 1
            answer = mid
        # print(f"answer {answer} mid {mid} {front} {last}")

    # mid = answer
    # while True:
    #     num = 0
    #     new = mid - 1
    #     for t in times:
    #         num += new // t
    #     if num != n:
    #         answer = mid
    #         break
    #     else:
    #         mid -= 1
    
    return answer
from collections import defaultdict

def solution(k, tangerine):
    info = defaultdict(int)
    for t in tangerine:
        info[t] += 1
    info = sorted(info.items(), key = lambda x: x[1], reverse = True)
    
    result = 0
    for _, v in info:
        k -= v
        result += 1
        if k <= 0:
            break
    return result
from collections import defaultdict
def solution(n, words):
    dic = defaultdict(int)
    num = 0
    while len(words) // n > num:
        for i in range(n):
            now = words[n * num + i]
            if i == 0 and num == 0:
                dic[now] = 1
                continue
            before = words[n * num + i - 1]
            
            if dic[now] != 0:
                return [i + 1, num + 1]
            else:
                dic[now] = 1
            if now[0] != before[-1]:
                return [i + 1, num + 1]
            if len(now) == 1:
                return [i + 1, num + 1]
        num += 1

    return [0, 0]
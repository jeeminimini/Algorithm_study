from collections import deque

def solution(s):
    new = deque([s[0]])
    idx = 0
    for i in range(1, len(s)):
        if new and new[-1] == s[i]:
            new.pop()
        else:
            new.append(s[i])
        
    return 0 if new else 1
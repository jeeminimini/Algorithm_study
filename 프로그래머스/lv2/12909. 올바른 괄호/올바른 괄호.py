from collections import deque

def solution(s):
    q = deque()
    
    for ss in s:
        if ss == '(':
            q.append(ss)
        else:
            if len(q) == 0:
                return False
            else:
                q.pop()
    if len(q) == 0:
        return True
    else:
        return False
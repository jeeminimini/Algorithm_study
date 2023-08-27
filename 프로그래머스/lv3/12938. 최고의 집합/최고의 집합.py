def solution(n, s):
    quotient = s // n
    remainder = s % n  
    result = []
    if quotient == 0:
        return [-1]
    for i in range(remainder):
        n -= 1
        result.append(quotient + 1)
    for i in range(n):
        result.append(quotient)
    return sorted(result)

def getOneNum(n):
    total = 0
    while n > 0:
        total += n % 2
        n = n // 2
    return total

def solution(n):
    origin = getOneNum(n)
    new = 0
    newNum = 0
    while True:
        n += 1
        new = getOneNum(n)
        if new == origin:
            newNum = n
            break
    return newNum
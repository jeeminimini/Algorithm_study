import math
def make2digit(n, num):
    if n == 1:
        return num + 1
    else: 
        return make2digit(n // 2, num + n % 2) 


def solution(n):
    result = make2digit(n, 0)
    return result
import math
def make2digit(n, s):
    if n == 1:
        return '1' + s
    else: 
        return make2digit(n // 2, str(n % 2) + s) 


def solution(n):
    # s = make2digit(n, '')
    result = len(bin(n)[2:].replace('0', ''))
    return result
def solution(elements):
    n = len(elements)
    num = set([])
    for i in range(1, n):
        for j in range(n):
            new = elements[:]
            if i + j >=  n:
                new += elements[:i + j - n]
            num.add(sum(new[j: j+i]))
            
    return len(num) + 1
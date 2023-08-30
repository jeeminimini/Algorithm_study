def solution(n, stations, w):
    start = 1
    total = 0
    for i in range(len(stations) + 1):
        if i == len(stations):
            end = n
        else:
            end = stations[i] - 1 - w
        num = end - start + 1
        total += num // (w * 2 + 1)
        if num % (w * 2 + 1) != 0:
            total += 1
        if i != len(stations):
            start = stations[i] + 1 + w

    return total
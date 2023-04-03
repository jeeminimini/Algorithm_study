n, k = map(int, input().split())
courses = list(map(int, input().split()))
now = 0
for idx, c in enumerate(courses + list(reversed(courses))):
    now += c
    if now > k:
        if idx < n:
            print(idx + 1)
            break
        else:
            print(2 * n - idx)
            break
    elif now == k:
        if idx < n:
            print(idx + 2)
            break
        else:
            print(2 * n - idx - 1)
            break

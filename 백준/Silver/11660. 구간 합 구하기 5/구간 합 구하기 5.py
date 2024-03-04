import sys

n, m = map(int, sys.stdin.readline().split())
numbers = []
sum_info = []

for i in range(n):
    numbers.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    sub_info = []
    for j in range(n):
        if j == 0:
            sub_info.append(numbers[i][j])
        else:
            sub_info.append(sub_info[-1] + numbers[i][j])

    sum_info.append(sub_info)

for i in range(m):
    x1, y1, x2, y2 = map(lambda x: int(x) - 1, sys.stdin.readline().split())

    result = 0
    for j in range(x1, x2 + 1):
        if y1 == 0:
            result += sum_info[j][y2]
        else:
            result += sum_info[j][y2] - sum_info[j][y1 - 1]

    print(result)
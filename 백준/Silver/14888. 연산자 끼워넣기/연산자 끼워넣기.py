from itertools import permutations

n = int(input())
numbers = list(map(int, input().split()))
operators = list(map(int, input().split()))
operators_list = []
for i in range(4):
    for j in range(operators[i]):
        operators_list.append(i)

result_max = -98765434210
result_min = 98765434210
for permu in permutations(operators_list):
    num = numbers[0]
    for idx, p in enumerate(permu):
        if p == 0:  # +
            num += numbers[idx + 1]
        elif p == 1:  # -
            num -= numbers[idx + 1]
        elif p == 2:
            num *= numbers[idx + 1]
        else:
            if num < 0 < numbers[idx + 1]:
                num = (num * (-1) // numbers[idx + 1]) * (-1)
            else:
                num = num // numbers[idx + 1]
    result_max = max(result_max, num)
    result_min = min(result_min, num)
print(result_max)
print(result_min)
